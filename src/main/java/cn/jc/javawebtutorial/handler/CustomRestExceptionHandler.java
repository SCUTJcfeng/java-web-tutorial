package cn.jc.javawebtutorial.handler;

import org.apache.logging.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import cn.jc.javawebtutorial.api.ApiError;


@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    private static Logger logger = LogManager.getLogger(CustomRestExceptionHandler.class.getName());

    private String getLocalizedMessage(Exception ex) {
        String messString = ex.getLocalizedMessage();
        logger.error(messString);
        return messString;
    }

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public ApiError keyErrorHandler(HttpServletRequest req, ArithmeticException e) {
        return new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, getLocalizedMessage(e),
                e.getLocalizedMessage() + " ArithmeticException error");
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, getLocalizedMessage(ex), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, getLocalizedMessage(ex),
                ex.getValue() + " type mismatch error");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        String error = ex.getMethod() + " is not supported";
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, getLocalizedMessage(ex), error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}

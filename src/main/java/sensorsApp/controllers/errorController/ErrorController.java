package sensorsApp.controllers.errorController;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sensorsApp.errors.ValidationErrorResponse;
import sensorsApp.errors.Violation;
import sensorsApp.exceptions.SensorCreateException;

import java.util.List;

/**
 * Error controller
 */
@Slf4j
@RestControllerAdvice
public class ErrorController {

    /**
     * Validation data
     * @param e Exception
     * @return response with violations
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {

        log.warn(e.getMessage(), e);
        final List<Violation> violations = e.getConstraintViolations().stream()
                .map(
                        violation -> new Violation(
                                violation.getPropertyPath().toString(),
                                violation.getMessage()
                        )
                )
                .toList();

        return new ValidationErrorResponse(violations);
    }

    /**
     * Validation method parameters
     * @param e Exception
     * @return response with violations
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        log.warn(e.getMessage(), e);
        final List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(
                        error -> new Violation(
                                error.getField(),
                                error.getDefaultMessage())
                )
                .toList();

        return new ValidationErrorResponse(violations);
    }

    /**
     * Sensor creation parameter
     * @param e Exception
     * @return response with violation
     */
    @ExceptionHandler(SensorCreateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Violation onSensorCreateException(SensorCreateException e){

        log.warn(e.getMessage(), e);

        return new Violation("name", "Already exist");
    }
}
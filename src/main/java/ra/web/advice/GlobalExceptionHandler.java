package ra.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoHandlerFoundException.class)
    public String handleException(NoHandlerFoundException e) {
        // Log the exception (optional)
        System.err.println("An error occurred: " + e.getMessage());

        // Return a view name to display an error page
        return "404"; // This should correspond to an error.html view
    }
}

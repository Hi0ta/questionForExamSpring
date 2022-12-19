package sky.pro.questionforexamspring.exception;

public class FieldsShouldNotBeEmptyException extends RuntimeException {
    public FieldsShouldNotBeEmptyException(String message) {
        super(message);
    }
}

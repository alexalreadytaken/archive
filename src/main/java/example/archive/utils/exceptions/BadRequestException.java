package example.archive.utils.exceptions;

public class BadRequestException extends ForClientException{
    public BadRequestException(String message) {
        super(message);
    }
}

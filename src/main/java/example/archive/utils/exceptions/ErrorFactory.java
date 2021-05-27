package example.archive.utils.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorFactory {

    public static<T extends ForClientException> Error newError(T ex){
        String message = ex.getMessage();
        log.trace("new error for client '{}'", message);
        return new Error(message);
    }

}

package co.za.bike.race.bikerace.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResultsNotFoundException extends RuntimeException {
    public ResultsNotFoundException() {
        super();
    }
    public ResultsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public ResultsNotFoundException(HttpStatus notFound, String message, ResultsNotFoundException exc) {
        super(message);
    }
    public ResultsNotFoundException(Throwable cause) {
        super(cause);
    }
}

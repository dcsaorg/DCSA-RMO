package org.dcsa.rmo.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RequestFailureTO {

    private final String httpMethod;

    private final String requestUri;

    private final List<DomainError> errors;

    @JsonIgnore
    private final HttpStatus httpStatus;

    public int getStatusCode() {
        return httpStatus.value();
    }

    public String getStatusCodeText() {
        return httpStatus.getReasonPhrase();
    }

    private final ZonedDateTime errorDateTime = ZonedDateTime.now();
}

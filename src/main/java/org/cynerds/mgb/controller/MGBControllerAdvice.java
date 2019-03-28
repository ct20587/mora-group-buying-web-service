package org.cynerds.mgb.controller;

import com.google.gson.JsonSyntaxException;
import org.cynerds.mgb.dao.MGBDuplicateTrackException;
import org.cynerds.mgb.model.MGBTrackValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MGBControllerAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(MGBControllerAdvice.class);
    private static String unexpectedErrorMessage = "Unexpected error, please inform our site owner to help.";

    @ExceptionHandler(MGBDuplicateTrackException.class)
    @ResponseBody
    public ResponseEntity<MGBErrorResponse> duplicateTrackErrorHandler(MGBDuplicateTrackException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        new MGBErrorResponse(e.getMessage(), e.getTrack())
                );
    }

    @ExceptionHandler(MGBTrackValidationException.class)
    @ResponseBody
    public ResponseEntity<MGBErrorResponse> invalidInputErrorHandler(MGBTrackValidationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        new MGBErrorResponse(e.getMessage())
                );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<MGBErrorResponse> JsonSyntaxErrorHandler(HttpMessageNotReadableException e) {
        if (e.getCause() instanceof JsonSyntaxException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(
                            new MGBErrorResponse("Please check your input json is correctly formed.")
                    );
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            new MGBErrorResponse(unexpectedErrorMessage)
                    );
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<MGBErrorResponse> defaultErrorHandler(Exception e) {
        LOG.error("Unknown error caught!", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new MGBErrorResponse(unexpectedErrorMessage)
                );
    }

}

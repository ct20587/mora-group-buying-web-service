package org.cynerds.mgb.controller;

import org.cynerds.mgb.dao.MGBDuplicateTrackException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MGBControllerAdvice {

    @ExceptionHandler(MGBDuplicateTrackException.class)
    @ResponseBody
    public ResponseEntity<MGBErrorResponse> duplicateTrackErrorHandler(MGBDuplicateTrackException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                        new MGBErrorResponse(e.getMessage(), e.getTrack())
                );
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<MGBErrorResponse> defaultErrorHandler(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new MGBErrorResponse("Unexpected error, please inform our site owner to help.")
                );
    }

}

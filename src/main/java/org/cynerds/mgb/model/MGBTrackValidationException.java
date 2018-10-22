package org.cynerds.mgb.model;

public class MGBTrackValidationException extends RuntimeException {
    private static String validationErrorMessageTemplate = "%s of %s: <%s> can't be empty or less than 1";

    public MGBTrackValidationException(String message) {
        super(message);
    }

    public MGBTrackValidationException(Type type, String field, String identifier) {
        super(String.format(validationErrorMessageTemplate, field, type.toString(), identifier));
    }

    public static enum Type {
        ALBUM, TRACK;
    }
}

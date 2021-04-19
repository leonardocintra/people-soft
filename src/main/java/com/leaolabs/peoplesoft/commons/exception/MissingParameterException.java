package com.leaolabs.peoplesoft.commons.exception;

public class MissingParameterException extends BaseControllerException {

    public MissingParameterException(Object... parameters) {
        super(parameters);
    }
}

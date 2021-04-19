package com.leaolabs.peoplesoft.commons.exception;

public class EntityNotFoundException extends BaseControllerException {

	private static final long serialVersionUID = -1366979614080419696L;

	public EntityNotFoundException(Object... parameters) {
		super(parameters);
	}

}

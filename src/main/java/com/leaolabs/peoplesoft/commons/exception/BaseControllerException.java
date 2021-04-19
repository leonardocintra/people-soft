package com.leaolabs.peoplesoft.commons.exception;

import static java.util.Optional.ofNullable;

import java.nio.channels.FileChannel;

public class BaseControllerException extends RuntimeException {

	private static final long serialVersionUID = 6011730611178683208L;

	private final Object[] parameters;

	public BaseControllerException(final Object... parameters) {
		this.parameters = parameters;
	}

	public Object[] getParameters() {
		return this.parameters.clone();
	}

	public Object[] getParametersOrElse(final Object... objects) {
		return ofNullable(this.parameters)
				.map(Object[]::clone)
				.orElse(objects);
	}
}

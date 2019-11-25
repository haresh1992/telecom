package com.telecom.utils;

import org.springframework.http.HttpHeaders;

public class HeadersHandler {

	public static final void parseHeadersOnSuccess(HttpHeaders headers, String successMessage, String displayMessage) {

		headers.set("success-msg", successMessage);

		headers.set("display-msg", displayMessage);
	}

	public static final void parseHeadersOnError(HttpHeaders headers, String errorMessage, String displayMessage) {

		headers.set("error-msg", errorMessage);

		headers.set("display-msg", displayMessage);
	}
}

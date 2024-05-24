package org.jsp.reservationapi2.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String message;
	private T data;
	private int statusCode;
}

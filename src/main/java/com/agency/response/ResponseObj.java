package com.agency.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseObj {
	public ResponseObj(String message, Object object, String status) {
		super();
		this.message = message;
		this.object = object;
		this.status = status;
	}
	public ResponseObj() {
		
	}
	@Override
	public String toString() {
		return "ResponseObj [message=" + message + ", object=" + object + ", status=" + status + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String message;
	private Object object;
	private String status;

}

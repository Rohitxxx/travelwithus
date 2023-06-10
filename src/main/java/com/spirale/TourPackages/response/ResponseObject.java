package com.spirale.TourPackages.response;

import org.springframework.stereotype.Component;

@Component
public class ResponseObject {
	private String message;
	private Object object;
	private String status;
	@Override
	public String toString() {
		return "ResponseBody [message=" + message + ", object=" + object + ", status=" + status + "]";
	}
public ResponseObject()
{
	}
	public ResponseObject(String message, Object object, String status) {
		super();
		this.message = message;
		this.object = object;
		this.status = status;
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
}

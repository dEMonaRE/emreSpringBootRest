package com.emre.spring.rest;

import java.util.ArrayList;
import java.util.List;

public class ErrorDTO {
	private String errorDesc;
	private int errorCode;
	private List<ErrorDTO> errorObjs;

	public ErrorDTO() {
	}

	public ErrorDTO(String errorDesc, int errorCode) {
		super();
		this.errorDesc = errorDesc;
		this.errorCode = errorCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void addErrorObjs(ErrorDTO errorObj) {
		if (this.getErrorObjs() == null) {
			this.setErrorObjs(new ArrayList<>());
		}
		this.getErrorObjs().add(errorObj);
	}

	public List<ErrorDTO> getErrorObjs() {
		return errorObjs;
	}

	public void setErrorObjs(List<ErrorDTO> errorObjs) {
		this.errorObjs = errorObjs;
	}
}

package com.eliteartisans.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;


public class ErrorResponseDto {

	private String apiPath;
	private HttpStatus errorCode;
	private String erroMsg;
	private LocalDateTime errorTime;
	public ErrorResponseDto(String apiPath, HttpStatus errorCode, String erroMsg, LocalDateTime errorTime) {
		super();
		this.apiPath = apiPath;
		this.errorCode = errorCode;
		this.erroMsg = erroMsg;
		this.errorTime = errorTime;
	}
	public String getApiPath() {
		return apiPath;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	public HttpStatus getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
	public String getErroMsg() {
		return erroMsg;
	}
	public void setErroMsg(String erroMsg) {
		this.erroMsg = erroMsg;
	}
	public LocalDateTime getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}
	@Override
	public String toString() {
		return "ErrorResponseDto [apiPath=" + apiPath + ", errorCode=" + errorCode + ", erroMsg=" + erroMsg
				+ ", errorTime=" + errorTime + "]";
	}	
}

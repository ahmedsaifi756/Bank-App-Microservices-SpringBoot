package com.eliteartisans.accounts.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {
	@Schema(
			description = "APi path invoked by client"
			)
	private String apiPath;
	@Schema(
			description = "Error code of the error"
			)
	private HttpStatus errorCode;
	@Schema(
			description = "Error msg of the error"
			)
	private String erroMsg;
	@Schema(
			description = "Error time of the error"
			)
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

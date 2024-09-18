package com.eliteartisans.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Response",
        description = "Schema to hold succesful response information"
)
public class ResponseDto {

	@Schema(
			description = "status code of the response"
			)
	private String statusCode;
	@Schema(
			description = "status messgae in the response"
			)
	private String statusMsg;
	
	
	public ResponseDto(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	@Override
	public String toString() {
		return "ResponseDto [statusCode=" + statusCode + ", statusMsg=" + statusMsg + "]";
	}
}

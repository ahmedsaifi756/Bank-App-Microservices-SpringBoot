package com.eliteartisans.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

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
}

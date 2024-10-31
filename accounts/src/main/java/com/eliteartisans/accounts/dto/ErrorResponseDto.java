package com.eliteartisans.accounts.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Getter
@Setter
@ToString
@AllArgsConstructor

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
}

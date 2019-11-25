package com.telecom.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimCardRequest {

	@NotNull(message = "LoginUserName cannot be Null")
	@NotBlank(message = "LoginUserName cannot be Blank")
	private String loginUserName;

	@NotNull(message = "IMEI cannot be Null")
	private long imei;

	@NotNull(message = "SimNo cannot be Null")
	private long simno;


}

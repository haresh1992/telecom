package com.telecom.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

	@NotNull(message = "LoginUserName cannot be Null")
	@NotBlank(message = "LoginUserName cannot be Blank")
	private String loginUserName;

	@NotNull(message = "Name cannot be Null")
	@NotBlank(message = "Name cannot be Blank")
	private String name;

	@NotNull(message = "EmailId cannot be Null")
	@NotBlank(message = "EmailId cannot be Blank")
	private String emailId;


}

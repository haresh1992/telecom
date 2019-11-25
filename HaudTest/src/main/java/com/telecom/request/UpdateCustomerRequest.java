package com.telecom.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerRequest {

	@NotNull(message = "LoginUserName cannot be Null")
	@NotBlank(message = "LoginUserName cannot be Blank")
	private String loginUserName;

	@NotNull(message = "SimCard Id cannot be Null")
	private List<Long> simcardId;

	private Long customerId;

}

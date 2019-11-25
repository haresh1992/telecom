package com.telecom.mapper;

import com.telecom.dto.SimCardDTO;
import com.telecom.model.SimCard;
import com.telecom.request.SimCardRequest;
import com.telecom.response.SimCardResponse;

public class SimCardMapper {

	private SimCardMapper() {
	}

	public static SimCard toSimCard(SimCardRequest simCardRequest) {

		return SimCard.builder().imei(simCardRequest.getImei()).simno(simCardRequest.getSimno()).build();
	}

	public static SimCardDTO toSimCardDTO(SimCard simCard) {

		return SimCardDTO.builder()
				.id(simCard.getId())
				.imei(simCard.getImei())
				.simno(simCard.getSimno())
				.createdBy(simCard.getCreatedBy())
				.createdOn(simCard.getCreatedOn())
				.updatedBy(simCard.getUpdatedBy())
				.updatedOn(simCard.getUpdatedOn())
				.build();
	}

	public static SimCardResponse toSimCardResponse(SimCardDTO simCardDTO) {

		return SimCardResponse.builder()
				.id(simCardDTO.getId())
				.imei(simCardDTO.getImei())
				.simno(simCardDTO.getSimno())
				.createdBy(simCardDTO.getCreatedBy())
				.createdOn(simCardDTO.getCreatedOn())
				.updatedBy(simCardDTO.getUpdatedBy())
				.updatedOn(simCardDTO.getUpdatedOn())
				.build();
	}
}

package com.telecom.mapper;

import com.telecom.dto.CustomerDTO;
import com.telecom.model.Customer;
import com.telecom.request.CustomerRequest;
import com.telecom.response.CustomerResponse;

public class CustomerMapper {

	private CustomerMapper() {
	}

	public static Customer toCustomer(CustomerRequest customerRequest) {

		return Customer.builder().name(customerRequest.getName()).emailId(customerRequest.getEmailId()).build();
	}

	public static CustomerDTO toCustomerDTO(Customer customer) {

		return CustomerDTO.builder()
				.id(customer.getId())
				.name(customer.getName())
				.emailId(customer.getEmailId())
				.simCards(customer.getSimCards())
				.createdBy(customer.getCreatedBy())
				.createdOn(customer.getCreatedOn())
				.updatedBy(customer.getUpdatedBy())
				.updatedOn(customer.getUpdatedOn())
				.build();
	}

	public static CustomerResponse toCustomerResponse(CustomerDTO customerDTO) {

		return CustomerResponse.builder()
				.id(customerDTO.getId())
				.name(customerDTO.getName())
				.emailId(customerDTO.getEmailId())
				.simCards(customerDTO.getSimCards())
				.createdBy(customerDTO.getCreatedBy())
				.createdOn(customerDTO.getCreatedOn())
				.updatedBy(customerDTO.getUpdatedBy())
				.updatedOn(customerDTO.getUpdatedOn())
				.build();


	}


}

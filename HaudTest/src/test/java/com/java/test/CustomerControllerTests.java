package com.java.test;

import com.telecom.request.CustomerRequest;
import com.telecom.request.UpdateCustomerRequest;
import com.telecom.response.CustomerResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerControllerTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createCustomer() throws Exception {

		System.out.println("******************************** TEST CASES ********************************");

		System.out.println("createCustomer Test Cases");

		String uri = "/customer";

		CustomerRequest customerRequest = new CustomerRequest();
		customerRequest.setName("Name102");
		customerRequest.setEmailId("name102@gmail.com");
		customerRequest.setLoginUserName("LoginU1");

		String inputJson = super.mapToJson(customerRequest);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);

		String content = mvcResult.getResponse().getContentAsString();

		System.out.println("Result : " + content);

		CustomerResponse customerResponse = super.mapFromJson(content, CustomerResponse.class);
		assertTrue(Objects.nonNull(customerResponse));
	}

	@Test
	public void linkSimCardToCustomer() throws Exception {

		System.out.println("******************************** TEST CASES ********************************");

		System.out.println("linkSimCardToCustomer Test Cases");

		String uri = "/customer/update/7";

		UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest();
		updateCustomerRequest.setCustomerId(7L);
		updateCustomerRequest.setLoginUserName("LoginU4");

		List<Long> simCardList = new ArrayList<>();
		simCardList.add(1L);
		simCardList.add(3L);
		simCardList.add(7L);

		updateCustomerRequest.setSimcardId(simCardList);

		String inputJson = super.mapToJson(updateCustomerRequest);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

		String content = mvcResult.getResponse().getContentAsString();

		System.out.println("Result : " + content);

		CustomerResponse customerResponse = super.mapFromJson(content, CustomerResponse.class);
		assertTrue(Objects.nonNull(customerResponse));
	}

	@Test
	public void getCustomerInfo() throws Exception {

		System.out.println("******************************** TEST CASES ********************************");

		System.out.println("getCustomerInfo Test Cases");

		String uri = "/customer/3";

		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		System.out.println("Result : " + content);

		CustomerResponse customerResponse = super.mapFromJson(content, CustomerResponse.class);
		assertTrue(Objects.nonNull(customerResponse));
	}

}


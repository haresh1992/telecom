package com.java.test;

import com.telecom.request.SimCardRequest;
import com.telecom.response.SimCardResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimCardControllerTests extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createSimCard() throws Exception {

		System.out.println("******************************** TEST CASES ********************************");

		System.out.println("createSimCard Test Cases");

		String uri = "/simcard";

		SimCardRequest simCardRequest = new SimCardRequest();
		simCardRequest.setImei(919191);
		simCardRequest.setSimno(929292);
		simCardRequest.setLoginUserName("LoginU101");

		String inputJson = super.mapToJson(simCardRequest);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);

		String content = mvcResult.getResponse().getContentAsString();

		System.out.println("Result : " + content);

		SimCardResponse simCardResponse = super.mapFromJson(content, SimCardResponse.class);
		assertTrue(Objects.nonNull(simCardResponse));
	}

}


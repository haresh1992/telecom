package com.telecom.service;

import com.telecom.dto.CustomerDTO;
import com.telecom.request.CustomerRequest;
import com.telecom.request.UpdateCustomerRequest;

public interface ICustomerService {

    CustomerDTO createCustomer(CustomerRequest customerRequest);

    CustomerDTO linkSimCardToCustomer(UpdateCustomerRequest updateCustomerRequest) throws Exception;

    CustomerDTO getCustomerInfo(long customerId) throws Exception;
}

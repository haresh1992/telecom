package com.telecom.controller;


import com.telecom.dto.CustomerDTO;
import com.telecom.mapper.CustomerMapper;
import com.telecom.request.CustomerRequest;
import com.telecom.request.UpdateCustomerRequest;
import com.telecom.response.CustomerResponse;
import com.telecom.service.ICustomerService;
import com.telecom.utils.HeadersHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController extends ExternalBaseController {

    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    private HttpHeaders headers;

    @Autowired
    private ICustomerService customerService;

    /**
     * This API is used to Create Customer
     * @param customerRequest
     * @return CustomerResponse Object
     */
    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {

        logger.info("CustomerController : createCustomer Method Called");

        headers = new HttpHeaders();

        try {

            CustomerDTO customerDTO = customerService.createCustomer(customerRequest);

            CustomerResponse customerResponse = CustomerMapper.toCustomerResponse(customerDTO);

            HeadersHandler.parseHeadersOnSuccess(headers, "Customer created.", "Customer created Successfully.");

            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(customerResponse);

        } catch (Exception ex) {

            HeadersHandler.parseHeadersOnSuccess(headers, ex.getMessage(), "Error occured while creating new Customer.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(null);
        }
    }

    /**
     * This API is use to link Simcard with Customer
     * @param customerId
     * @param updateCustomerRequest
     * @return CustomerResponse Object
     */
    @PutMapping(value ="update/{customerid}")
    public ResponseEntity linkSimCardToCustomer(@PathVariable("customerid") long customerId, @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {

        logger.info("CustomerController : linkSimCardToCustomer Method Called");

        headers = new HttpHeaders();

        try {

            updateCustomerRequest.setCustomerId(customerId);

            CustomerDTO customerDTO = customerService.linkSimCardToCustomer(updateCustomerRequest);

            CustomerResponse customerResponse = CustomerMapper.toCustomerResponse(customerDTO);

            HeadersHandler.parseHeadersOnSuccess(headers, "SimCard linked to Customer.", "SimCard linked to Customer.");

            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerResponse);

        } catch (Exception ex) {

            HeadersHandler.parseHeadersOnSuccess(headers, ex.getMessage(), "Error occured while linking SimCard to Customer.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(null);
        }
    }

    /**
     * This API is used to Get Customer Info
     * @param customerId
     * @return CustomerResponse Object
     */
    @GetMapping("/{customerid}")
    public ResponseEntity getCustomerInfo(@PathVariable("customerid") long customerId) {

        logger.info("CustomerController : getCustomerInfo Method Called");

        headers = new HttpHeaders();

        try {

            CustomerDTO customerDTO = customerService.getCustomerInfo(customerId);

            CustomerResponse customerResponse = CustomerMapper.toCustomerResponse(customerDTO);

            HeadersHandler.parseHeadersOnSuccess(headers, "Customer Info retrieved.", "Customer Info retrieved.");

            return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customerResponse);

        } catch (Exception ex) {

            HeadersHandler.parseHeadersOnSuccess(headers, ex.getMessage(), "Error occured while fetching Customer Info.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(null);
        }
    }
}
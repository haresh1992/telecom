package com.telecom.service.impl;

import com.telecom.dto.CustomerDTO;
import com.telecom.mapper.CustomerMapper;
import com.telecom.model.Customer;
import com.telecom.model.SimCard;
import com.telecom.repository.ICustomerRepository;
import com.telecom.repository.ISimCardRepository;
import com.telecom.request.CustomerRequest;
import com.telecom.request.UpdateCustomerRequest;
import com.telecom.service.ICustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);


    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ISimCardRepository simCardRepository;


    @Override
    public CustomerDTO createCustomer(CustomerRequest customerRequest) {

        logger.info("CustomerServiceImpl : createCustomer Method Called");

        CustomerDTO customerDTO;

        try {

            Customer customer = CustomerMapper.toCustomer(customerRequest);

            customer.setCreatedBy(customerRequest.getLoginUserName());

            customer = customerRepository.save(customer);

            customerDTO = CustomerMapper.toCustomerDTO(customer);

        } catch (Exception ex) {

            logger.error(ex.getMessage(), ex);
            throw ex;
        }

        return customerDTO;
    }

    @Override
    public CustomerDTO linkSimCardToCustomer(UpdateCustomerRequest updateCustomerRequest) throws Exception {

        logger.info("CustomerServiceImpl : linkSimCardToCustomer Method Called");

        CustomerDTO customerDTO;

        try {

            Optional<Customer> optionalCustomer = customerRepository.findById(updateCustomerRequest.getCustomerId());

            if (optionalCustomer.isPresent()) {

                Customer customer = optionalCustomer.get();

                List<SimCard> simCardList = simCardRepository.findAllById(updateCustomerRequest.getSimcardId());

                customer.setSimCards(simCardList);
                customer.setUpdatedBy(updateCustomerRequest.getLoginUserName());

                customer = customerRepository.save(customer);

                customerDTO = CustomerMapper.toCustomerDTO(customer);

            } else
                throw new Exception("Customer doesn't exist");

            return customerDTO;

        } catch (Exception ex) {

            logger.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    @Override
    public CustomerDTO getCustomerInfo(long customerId) throws Exception {

        logger.info("CustomerServiceImpl : getCustomerInfo Method Called");

        CustomerDTO customerDTO;

        try {

            Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

            if (optionalCustomer.isPresent())
                customerDTO = CustomerMapper.toCustomerDTO(optionalCustomer.get());
            else
                throw new Exception("Customer doesn't exist");

        } catch (Exception ex) {

            logger.error(ex.getMessage(), ex);
            throw ex;
        }

        return customerDTO;
    }

}

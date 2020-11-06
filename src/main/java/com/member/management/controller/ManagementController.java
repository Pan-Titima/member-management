package com.member.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.member.management.entity.CustomerData;
import com.member.management.repository.RegistrationServiceRepository;
import com.member.management.service.RegistrationServiceDatabaseImpl;

@RestController
@RequestMapping(path = "api")
public class ManagementController {
		
	@Autowired
	private RegistrationServiceDatabaseImpl service;
	
	@Autowired
	private RegistrationServiceRepository repository;
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	@RequestMapping(method = RequestMethod.POST, path = "registration")
	public ResponseEntity<CustomerData> registration(@RequestBody CustomerData customerData){

		CustomerData data = service.saveData(customerData);
		
		if(!"notMemer".equals(data.getMemberType()))
		{
			return ResponseEntity.ok(data);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
		}
		
	}
	
	
	@GetMapping(produces= {MediaType.APPLICATION_JSON_VALUE})
	@RequestMapping(method = RequestMethod.GET , path = "getUserInfo")
	public ResponseEntity<CustomerData> callGet(@RequestParam String userName)
	{
		CustomerData data = null;
		data = repository.findCustomerDataByUserName(userName);
		
		if(data != null)
		{
			return ResponseEntity.ok(data);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(data);
		}
		
	}

}

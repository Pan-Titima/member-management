package com.member.management.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.member.management.repository.RegistrationServiceRepository;

import com.member.management.entity.CustomerData;

@Service
public class RegistrationServiceDatabaseImpl {
	
	
	@Autowired
	private RegistrationServiceRepository repository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public CustomerData saveData(CustomerData customerData)
	{
				
			String password = customerData.getPassword();
			customerData.setPassword(bcryptEncoder.encode(password)); 
			CustomerData cd = modifyDataForSave(customerData);
			repository.save(cd);
			return cd;
	}
	
	public CustomerData modifyDataForSave(CustomerData customerData)
	{
		String lastFourPhone = customerData.getPhone().substring(6);
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat sf = new SimpleDateFormat("YYYYMMdd");
		String dateStr = sf.format(date);
		customerData.setReferenceCode(dateStr+lastFourPhone);
		
		//find member type
		Double salary = customerData.getSalary();
		String memberType = "";
		if(salary > 50000)
		{
			memberType = "Platinum";
			
		}else if(salary > 30000)
		{
			memberType = "Gold";
			
		}else if(salary > 15000)
		{
			memberType = "Silver";
			
		}else
		{
			memberType = "notMember";

		}
		
		customerData.setMemberType(memberType);
		return customerData;
	}

}

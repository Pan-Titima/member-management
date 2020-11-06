package com.member.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.member.management.entity.CustomerData;

@Repository
public interface RegistrationServiceRepository  extends JpaRepository<CustomerData, String>,
				JpaSpecificationExecutor<CustomerData>{
	
	  @Query("SELECT cd FROM CustomerData cd where cd.userName = :userName") 
	    public CustomerData findCustomerDataByUserName(
	    		@Param("userName") String userName);
}
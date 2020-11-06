package com.member.management.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "CustomerData.findAll", query = "SELECT c FROM CustomerData c")
public class CustomerData implements Serializable{

		private static final long serialVersionUID = 1L;
			
		//username, password, address, phone
		
		@Id
		@Column(name = "reference_code")
		private String referenceCode;
		
		@Column(name = "user_name")
		private String userName;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "address")
		private String address;
		
		@Column(name = "phone")
		private String phone;
		
		@Column(name = "salary")
		private Double salary;
		
		@Column(name = "member_type")
		private String memberType;

		public CustomerData(String referenceCode, String userName, String password, String address, String phone,
				Double salary, String memberType) {
			super();
			this.referenceCode = referenceCode;
			this.userName = userName;
			this.password = password;
			this.address = address;
			this.phone = phone;
			this.salary = salary;
			this.memberType = memberType;
		}
		
		public CustomerData()
		{
			
		}

		public String getReferenceCode() {
			return referenceCode;
		}

		public void setReferenceCode(String referenceCode) {
			this.referenceCode = referenceCode;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public String getMemberType() {
			return memberType;
		}

		public void setMemberType(String memberType) {
			this.memberType = memberType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((address == null) ? 0 : address.hashCode());
			result = prime * result + ((memberType == null) ? 0 : memberType.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((phone == null) ? 0 : phone.hashCode());
			result = prime * result + ((referenceCode == null) ? 0 : referenceCode.hashCode());
			result = prime * result + ((salary == null) ? 0 : salary.hashCode());
			result = prime * result + ((userName == null) ? 0 : userName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CustomerData other = (CustomerData) obj;
			if (address == null) {
				if (other.address != null)
					return false;
			} else if (!address.equals(other.address))
				return false;
			if (memberType == null) {
				if (other.memberType != null)
					return false;
			} else if (!memberType.equals(other.memberType))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (phone == null) {
				if (other.phone != null)
					return false;
			} else if (!phone.equals(other.phone))
				return false;
			if (referenceCode == null) {
				if (other.referenceCode != null)
					return false;
			} else if (!referenceCode.equals(other.referenceCode))
				return false;
			if (salary == null) {
				if (other.salary != null)
					return false;
			} else if (!salary.equals(other.salary))
				return false;
			if (userName == null) {
				if (other.userName != null)
					return false;
			} else if (!userName.equals(other.userName))
				return false;
			return true;
		}
			
			

	}




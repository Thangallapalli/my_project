package com.edubridge.app1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_details")
public class Admin {
	
	@Id
	@GeneratedValue
	private Integer adminId;
	private String adminName;
	private String adminEmail;
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(Integer adminId, String adminName, String adminEmail, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", password="
				+ password + "]";
	}
	
	

}

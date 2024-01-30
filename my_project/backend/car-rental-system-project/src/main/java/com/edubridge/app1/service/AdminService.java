package com.edubridge.app1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.AdminDao;
import com.edubridge.app1.model.Admin;


@Service
public class AdminService {

	@Autowired
	private AdminDao dao;
	
	public Admin saveAdmin(Admin a) {
		return dao.saveAdmin(a);
	}
	

	public List<Admin> getAdmins(){
		return dao.getAdmins();
	}
	
	public Admin getAdmin(Integer adminId) {
		return dao.getAdmin(adminId);
	}
	
	public void updateAdmin(Admin a) {
		dao.updateAdmin(a);
	}
	
	public void deleteAdmin(Integer adminId) {
		dao.deleteAdmin(adminId);
	}
	
	public Admin login(Integer adminId, String password) throws Exception{

		Admin admin = dao.getAdmin(adminId);

		System.out.println(admin.getPassword());

		if(admin.getAdminId().equals(adminId) && admin.getPassword().equals(password)) {

		return admin;

		}else {

		throw new Exception("invalid Credentials");
		}

	}
}
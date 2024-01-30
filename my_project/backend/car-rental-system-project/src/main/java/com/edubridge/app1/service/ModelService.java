package com.edubridge.app1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.app1.dao.ModelDao;
import com.edubridge.app1.model.Car;
import com.edubridge.app1.model.Models;

@Service
public class ModelService {
	
	@Autowired
	private ModelDao dao;
	
	public Models saveModel(Models m) {
		return dao.saveModel(m);
	}
	
	public List<Models> getModels(){
		return dao.getModels();
	}
	
	public Models getModel(Integer modelId) {
		return dao.getModel(modelId);
	}
	
	public void updateModel(Models m) {
		dao.updateModel(m);
	}
	
	public void deleteModel(Integer modelId) {
		dao.deleteModel(modelId);
	}

}

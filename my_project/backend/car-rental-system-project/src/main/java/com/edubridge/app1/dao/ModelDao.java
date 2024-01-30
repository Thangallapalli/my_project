package com.edubridge.app1.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.edubridge.app1.model.Models;
import com.edubridge.app1.repo.ModelRepository;

@Repository
public class ModelDao {
	
	@Autowired
	private ModelRepository repo;
	public Models saveModel(Models m) {
		return repo.save(m);
	}
	
	public List<Models> getModels(){
		return repo.findAll();
	}
	
	public Models getModel(Integer modelId) {
		return repo.findById(modelId).get();
	}
	
	public void updateModel(Models m) {
		repo.save(m);
	}
	
	public void deleteModel(Integer modelId) {
		repo.deleteById(modelId);
	}

}

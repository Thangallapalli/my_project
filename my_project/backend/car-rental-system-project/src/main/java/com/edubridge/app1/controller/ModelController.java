package com.edubridge.app1.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.edubridge.app1.model.Models;
import com.edubridge.app1.service.ModelService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ModelController {

	@Autowired
	private ModelService service;
	
	@PostMapping("/model")
	public ResponseEntity<Models> save(@RequestBody Models model){
		Models savedModel = service.saveModel(model);
		return new ResponseEntity<>(savedModel, HttpStatus.OK);
	}

	@GetMapping("/model")
	public ResponseEntity<List<Models>> getAllModels(){
	    List<Models> models =service.getModels();
	    return new ResponseEntity<>(models, HttpStatus.OK);
	}
	
	@GetMapping("/model/{id}")
	public ResponseEntity<Models> getOneModel(@PathVariable("id") Integer modelId){
		Models model = service.getModel(modelId);
		return new ResponseEntity<Models>(model, HttpStatus.OK);
	}
	
		@DeleteMapping("/model/{id}")
		public ResponseEntity<Models> deleteModel(@PathVariable("id") Integer modelId){
		    service.deleteModel(modelId);
			return new ResponseEntity<Models>(HttpStatus.OK);
	}
		@PutMapping("/model{id}")
		public ResponseEntity<Models> update(@RequestBody Models model){
		    service.saveModel(model);
		    return new ResponseEntity<>(HttpStatus.OK);
		}
}

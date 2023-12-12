package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.emp;
import com.example.repository.empRepo;

@Service
public class empSer {
	
	@Autowired
	private empRepo repo;
	
	public void addEmp(emp e) {
		
		repo.save(e);
		
	}
	
	public List<emp> getEmp(){
		
		return repo.findAll();
		
	}
	
	public emp getEdit(int id) {
		
		Optional<emp> e = repo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
		
	}
	
	public void deleteEmp(int id) {
		repo.deleteById(id);
		
	}
	

}

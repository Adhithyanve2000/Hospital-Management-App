package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.DelicaciesModel;
import com.reservation.model.TableModel;
import com.reservation.repository.AdminRepository;
import com.reservation.repository.TableRepository;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/cafe/api")
public class AdminController {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	TableRepository tableRepository;

	@PostMapping("/delicacies")
	public DelicaciesModel addDelicacies(@Validated @RequestBody DelicaciesModel delicaciesModel){
		delicaciesModel.getStatus();
		delicaciesModel.setStatus("waiting");
		return adminRepository.save(delicaciesModel);
	}
	
	@GetMapping("/getdelicacies")
	public List<DelicaciesModel> getItems(){		
		return adminRepository.findAll();
	}
	
	@GetMapping("/enable")
	public DelicaciesModel enableItem(@RequestParam int id){
		DelicaciesModel dm=adminRepository.findById(id);
		dm.getStatus();
		dm.setStatus("Enable");	
		adminRepository.save(dm);
		return dm;		
	}
	
	@GetMapping("/Disable")
	public DelicaciesModel disableItem(@RequestParam int id){
		DelicaciesModel ddm=adminRepository.findById(id);
		ddm.getStatus();
		ddm.setStatus("Disable");	
		adminRepository.save(ddm);
		return ddm;		
	}
	
	@GetMapping("/removedelicaciesbyid")
	public void getItemById(@RequestParam int id) {
		 adminRepository.deleteById(id);
	}
	
	@PostMapping("/addtables")
	public TableModel saveTables(@Validated @RequestBody TableModel tableModel) {
		tableModel.getTableusername();
		tableModel.setTableusername("waiting");
		tableModel.getTablestatus();
		tableModel.setTablestatus("waiting");
		return tableRepository.save(tableModel);
	}
	
}

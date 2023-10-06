package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.TableModel;
import com.reservation.model.UserModel;
import com.reservation.repository.TableRepository;
import com.reservation.repository.UserRepository;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/cafe/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
  
	@Autowired
	TableRepository tableRepository;
	
	@GetMapping("/userlogin")
	public UserModel getItemById(@RequestParam String username,@RequestParam String password) {
	return userRepository.findByUsernameAndPassword(username,password);
	}
	
	@PostMapping("/register")
	public UserModel getRegister(@Validated @RequestBody UserModel userModel) {
		return userRepository.save(userModel);
	}
	
	@GetMapping("/getTable")
	public List<TableModel> getTables(@RequestParam String tablerow){
		return tableRepository.findByTablerow(tablerow);
	}
	
	@GetMapping("/booktable")
	public TableModel bookTable(@RequestParam int id,@RequestParam String username) {
		
		TableModel tm=tableRepository.findById(id);
		String status=tm.getTablestatus();
		if(status!="Reserved") {
			tm.getTableusername();
			tm.setTableusername(username);
			tm.setTablestatus("Reserved");
		}
		return tableRepository.save(tm);
	}
	
	@GetMapping("/bookedtables")
	public List<TableModel> getBookedTable(@RequestParam String username){
		return tableRepository.findByTableusername(username);
		
	}
	
}

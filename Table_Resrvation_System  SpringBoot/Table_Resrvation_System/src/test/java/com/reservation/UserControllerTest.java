package com.reservation;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.reservation.controller.AdminController;
import com.reservation.repository.AdminRepository;
import com.reservation.repository.TableRepository;

@SpringBootTest
public class UserControllerTest {
	
	@InjectMocks
	private AdminController adminController;
	
	@Mock
	AdminRepository adminRepository;
	
	@Mock
	TableRepository tableRepository;
	
	

}

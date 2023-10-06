package com.reservation;

import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.reservation.model.DelicaciesModel;
import com.reservation.controller.AdminController;
import com.reservation.repository.AdminRepository;
import com.reservation.repository.TableRepository;

@SpringBootTest
public class AdminControllerTest {
	
	@InjectMocks
	private AdminController adminController;
	
	@Mock
	AdminRepository adminRepository;
	
	@Mock
	TableRepository tableRepository;
	
	  @Test
	    public void testAddDelicacies() {
	        DelicaciesModel delicaciesModel = new DelicaciesModel();
	        
	        delicaciesModel.setStatus("waiting");

	        when(adminRepository.save(delicaciesModel)).thenReturn(delicaciesModel);

	        DelicaciesModel returnedModel = adminController.addDelicacies(delicaciesModel);

	        assertEquals("waiting", returnedModel.getStatus(), "The status should be waiting");
	        
	        verify(adminRepository).save(delicaciesModel);
	    }
	   @Test
	    public void testEnableItem() {
	        int id = 1;
	        DelicaciesModel mockDelicacy = new DelicaciesModel();
	        mockDelicacy.setStatus("waiting");
	        when(adminRepository.findById(id)).thenReturn(mockDelicacy);

	        DelicaciesModel result = adminController.enableItem(id);

	        assertEquals("Enable", result.getStatus());
	        verify(adminRepository).save(any(DelicaciesModel.class));
	    }

	    @Test
	    public void testDisableItem() {
	        int id = 1;
	        DelicaciesModel mockDelicacy = new DelicaciesModel();
	        mockDelicacy.setStatus("waiting");
	        when(adminRepository.findById(id)).thenReturn(mockDelicacy);

	        DelicaciesModel result = adminController.disableItem(id);

	        assertEquals("Disable", result.getStatus());
	        verify(adminRepository).save(any(DelicaciesModel.class));
	    }
	}



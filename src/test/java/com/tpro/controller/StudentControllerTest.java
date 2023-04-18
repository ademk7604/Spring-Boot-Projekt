package com.tpro.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tpro.controller.StudentController;
import com.tpro.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
	
	@Mock
	StudentRepository studentRepository;
	
	
	
	
	
	@InjectMocks 			    	// mock bit obje ile bu sekilde enjekte ediliyor
	StudentController underTest;    // studentRepository objesini  underTest icine enjekte etmis olacak

}

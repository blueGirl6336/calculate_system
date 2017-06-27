package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.Classes;
import com.cesystem.pojo.Major;

public interface ClassesService {

	public Major getMajor(int studentId);
	
	List<Classes> getAllClass();
}

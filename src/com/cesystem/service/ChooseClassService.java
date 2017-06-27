package com.cesystem.service;

import java.util.List;

import com.cesystem.pojo.ChooseClass;
import com.cesystem.pojo.Student;

public interface ChooseClassService {

    void addChooseClass(ChooseClass chooseClass);
    
    void addChooseClassByExcel(String path);
    
    void modifyChooseClass(ChooseClass chooseClass);
    
    void deleteChooseClass(ChooseClass chooseClass);
    
    List<ChooseClass> searchChooseClassByUserName(String userName);
    
    List<ChooseClass> searchAllChooseClass();
    
    ChooseClass searchChooseClassById(int ccId);
    
	List<ChooseClass> searchByMajorNameAndGradeNumber(String majorName,
			int gradeNumber);

	List<ChooseClass> searchMainByMajorNameAndGradeNumber(String majorName,
			int gradeNumber);
	
	ChooseClass searchChooseClassByUserNameAndCourseId(String userName, Integer courseId);
}

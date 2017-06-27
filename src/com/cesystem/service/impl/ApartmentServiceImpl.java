package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.ApartmentDao;
import com.cesystem.dao.StudentDao;
import com.cesystem.pojo.Apartment;
import com.cesystem.pojo.Student;
import com.cesystem.service.ApartmentService;
@Service
public class ApartmentServiceImpl implements ApartmentService {
	
	@Autowired
	private ApartmentDao apartmentDao;
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Apartment> getAll() {
		List<Apartment> apartmentList = null;
		apartmentList = apartmentDao.getAll();
		if(apartmentList.size() == 0)
			return null;
		else
			return apartmentList;
	}

	@Override
	public int addApartment(String apartmentName) {

		if(apartmentDao.getByName(apartmentName)!=null)
			return 1;
		//Apartment apartment = new Apartment(apartmentName);
		//apartmentDao.add(apartment);
		return 0;
	}

	
	/**
	 * 这个东西暂时不好用233
	 */
	@Override
	public boolean deleteApartment(int apartmentId) {
		// TODO Auto-generated method stub
		Apartment apartment = apartmentDao.getById(apartmentId);
		if(apartment == null)
			return false;
		apartmentDao.delete(apartment);
		
		return true;
	}

	@Override
	public boolean distributeApartment(int apartmentId, int studentId) {
		
		Student student = studentDao.getStudentById(studentId);
		Apartment apartment = apartmentDao.getById(apartmentId);
		student.setApartment(apartment);
		studentDao.update(student);
		
		return true;
	}

}

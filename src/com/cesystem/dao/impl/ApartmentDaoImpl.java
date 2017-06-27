package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.ApartmentDao;
import com.cesystem.pojo.Apartment;
import com.cesystem.pojo.Users;
@Repository
public class ApartmentDaoImpl extends BaseDaoImpl implements ApartmentDao {

	@Override
	public List<Apartment> getAll() {
		// TODO Auto-generated method stub
		String hql = "from Apartment";
		
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public Apartment getById(int apartmentId) {
		// TODO Auto-generated method stub
		Apartment apartment = new Apartment();
		return (Apartment) this.getById(apartment, apartmentId);

	}

	@Override
	public Apartment getByName(String name) {
		// TODO Auto-generated method stub
		List<Apartment> apartmentList = null;
		String hql = "from Apartment as a where a.apartmentName=?";
		apartmentList = this.getHibernateTemplate().find(hql, name);
		if(apartmentList.size()==0) {
			return null;
		} else {
			return apartmentList.get(0);
		}
	}

}

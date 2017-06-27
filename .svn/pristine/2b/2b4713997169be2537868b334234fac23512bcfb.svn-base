package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cesystem.dao.PrizeDao;
import com.cesystem.pojo.Prize;
@Repository
public class PrizeDaoImpl extends BaseDaoImpl implements PrizeDao {

	@Override
	public List<Prize> getAll() {
		// TODO Auto-generated method stub
		String hql = "from Prize";
		return this.getHibernateTemplate().find(hql);
	}

	@Override
	public Prize getPrizeById(int prizeId) {
		// TODO Auto-generated method stub
		Prize prize = new Prize();
		prize = (Prize) this.getById(prize, prizeId);
		
		return prize;
	}

}

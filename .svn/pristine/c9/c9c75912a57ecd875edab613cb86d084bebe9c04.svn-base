package com.cesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cesystem.dao.ScoreItemsDao;
import com.cesystem.pojo.ScoreItems;

@Repository
public class ScoreItemsDaoImpl extends BaseDaoImpl implements ScoreItemsDao {

	@Override
	public List<ScoreItems> getAllScoreItems() {
		String hql = "from ScoreItems ";
		List<ScoreItems> scoreItemsList = (List<ScoreItems>) this.getHibernateTemplate().find(hql);
		return scoreItemsList;
	}

	@Override
	public ScoreItems getById(int siId) {
		String hql = "from ScoreItems as s where s.siId = " + siId;
		List<ScoreItems> scoreItemsList = (List<ScoreItems>) this.getHibernateTemplate().find(hql);
		if(scoreItemsList!=null && scoreItemsList.size()!=0)
		return scoreItemsList.get(0);
		else
			return null;
	}

}

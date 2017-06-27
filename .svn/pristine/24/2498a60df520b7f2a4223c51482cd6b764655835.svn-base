package com.cesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesystem.dao.ScoreItemsDao;
import com.cesystem.pojo.ScoreItems;
import com.cesystem.service.ScoreItemService;

@Service
public class ScoreItemServiceImpl implements ScoreItemService {

	@Autowired
	private ScoreItemsDao scoreItemsDao;
	
	@Override
	public List<ScoreItems> getAll() {
		// TODO Auto-generated method stub
		List<ScoreItems> list = scoreItemsDao.getAllScoreItems();
		
		return list;
	}

	@Override
	public ScoreItems getById(int siId) {
		return scoreItemsDao.getById(siId);
	}

}

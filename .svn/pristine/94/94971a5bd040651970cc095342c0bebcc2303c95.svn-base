package com.cesystem.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cesystem.pojo.ScoreItems;
import com.cesystem.service.ScoreItemService;

@Controller
@RequestMapping(value = "/scoreItem")
public class ScoreItemController {

	@Autowired
	private ScoreItemService scoreItemService;
	
	@RequestMapping(value = "/getAll")
	@ResponseBody
	public List<ScoreItems> getAll()
	{
		List<ScoreItems> scoreItemList = null;
		scoreItemList = scoreItemService.getAll();
		
		return scoreItemList;
	}
}

package com.qbt.web.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.persistent.entity.OrgGroup;
import com.qbt.service.OrgGroupService;

@Controller
@RequestMapping(value="/testController")
public class TestController {

	@Resource
	private OrgGroupService orgGroupService;
	
	@RequestMapping(value="testDate")
	public void testDate(){
		OrgGroup orgGroup = orgGroupService.selectById(1);
		Boolean rightDate = false;
		Date nowDate = new Date();
		if((nowDate.after(orgGroup.getStartDate()) && (nowDate.before(orgGroup.getEndDate())))){
			rightDate = true;
		}
		System.out.println(rightDate);
	}

	
}

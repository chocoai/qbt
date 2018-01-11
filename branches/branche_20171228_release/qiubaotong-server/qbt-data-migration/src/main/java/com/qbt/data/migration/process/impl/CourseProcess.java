package com.qbt.data.migration.process.impl;

import java.util.HashMap;
import java.util.Map;

import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.JSonUtil;
import com.qbt.data.migration.config.ProcessServiceConfig;
import com.qbt.data.migration.pgsql.entity.Course;
import com.qbt.data.migration.process.AbstractProcess;
import com.qbt.data.migration.utils.DataCacheUtil;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseCourseInfo;
import com.qbt.service.BaseCourseInfoService;
import com.qbt.service.BaseCourseService;

/**
 *  微信业务
  * @ClassName: AccountProcess
  * @Description: TODO
  * @author share 2016年8月31日
  * @modify share 2016年8月31日
 */
public class CourseProcess extends AbstractProcess {

	
	
	public CourseProcess(String name, ProcessServiceConfig config) {
		super(name, config);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void before() {
		
	}

	@Override
	public void process() throws Exception {
		// TODO Auto-generated method stub
		BaseCourseService baseCourseService = SpringContextHolder.getBean("baseCourseServiceImpl");
		BaseCourseInfoService baseCourseInfoService = SpringContextHolder.getBean("baseCourseInfoServiceImpl");
		// 球场
		for(BaseCourse area : baseCourseService.list()){
			DataCacheUtil.putCourseMap(area.getName(), area);
		}
		
		while(rs.next()){
			Map<String,Object> rowMap = new HashMap<String,Object>();
			for(String columnLabel : columnList){
				rowMap.put(columnLabel,rs.getObject(columnLabel));
			}
			String json = JSonUtil.toJSonString(rowMap);
			Course old = JSonUtil.toObject(json, Course.class);
			if(DataCacheUtil.getCourseMap(old.getName()) != null){
				
				BaseCourse newCourse = DataCacheUtil.getCourseMap(old.getName());
				BaseCourseInfo info = baseCourseInfoService.selectByCourseId(newCourse.getId());
				
				String contact = old.getMobile();
				if(contact !=null && !"".equals(contact) && !contact.equals(info.getMobile()))
					System.out.println("update base_course_info set mobile = '"+contact+"' where course_id="+newCourse.getId()+";--"+old.getName());
			}
		}
	}

}

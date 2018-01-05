package com.qbt.base;

import java.io.FileInputStream;
import java.nio.charset.Charset;

import javax.annotation.Resource;

import org.apache.commons.lang.BooleanUtils;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.csvreader.CsvReader;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseCourseInfo;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.mapper.BaseCourseInfoMapper;
import com.qbt.persistent.mapper.BaseCourseMapper;
import com.qbt.persistent.mapper.BaseSfAreaMapper;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class CourseSyn extends AbstractJUnit4SpringContextTests {
	
	@Resource
	private BaseSfAreaMapper baseSfAreaMapper;
	
	@Resource
	private BaseCourseMapper baseCourseMapper;
	
	@Resource
	private BaseCourseInfoMapper baseCourseInfoMapper;
	
	@Test
	public void initCourse(){
		CsvReader reader = null;
		try {
			reader = new CsvReader(new FileInputStream("./src/test/java/com/qbt/base/csv/_public_._course_ - utf8.csv"), ',', Charset.forName("utf-8"));
			reader.readHeaders();
			
			BaseCourse course = null;
			BaseCourseInfo info = null;
			BaseSfArea area = null;
			while(reader.readRecord()){
				String name = reader.get("name");
				String province = reader.get("province");
				String city = reader.get("city");
				String county = reader.get("county");
				String address = reader.get("address");
				String telephone = reader.get("telephone");
				String description = reader.get("description");
				String status = reader.get("status");
				String contact = reader.get("contact");
				String mobile = reader.get("mobile");
				String logo = reader.get("logo");
				String english_name = reader.get("english_name");
				String golf_hole = reader.get("golf_hole");
				String short_name = reader.get("short_name");
				String initial = reader.get("initial");
				String lon = reader.get("lon");
				String lat = reader.get("lat");
				String remark = reader.get("remark");
				String first_letter = reader.get("first_letter");
				String introducing = reader.get("introducing");
				String website = reader.get("website");
				String introduction_href = reader.get("introduction_href");
				String wechat = reader.get("wechat");
				String introducing_href = reader.get("introducing_href");
				String has_assistant = reader.get("has_assistant");
				String sign_place = reader.get("sign_place");
				String send_place = reader.get("send_place");
				String start_work_time = reader.get("start_work_time");
				String end_work_time = reader.get("end_work_time");
				String product_intro = reader.get("product_intro");
				String feature_intro = reader.get("feature_intro");
				String food_intro = reader.get("food_intro");
				String other_intro = reader.get("other_intro");
				String weather = reader.get("weather");
				String bag_deposit_charge = reader.get("bag_deposit_charge");
				String tee_time_interval = reader.get("tee_time_interval");
				String tee_time_earliest = reader.get("tee_time_earliest");
				String tee_time_latest = reader.get("tee_time_latest");
				String transition_closed_time = reader.get("transition_closed_time");
				String transition_closed_begin_time = reader.get("transition_closed_begin_time");
				String transition_closed_end_time = reader.get("transition_closed_end_time");
				String deleted_at = reader.get("deleted_at");
				
				if(!city.equals(county)){
					area = baseSfAreaMapper.findByDistrict(city, county);
				}else{
					area = baseSfAreaMapper.findByFullName(county);
					if(Checker.isEmpty(area)){
						area = baseSfAreaMapper.findByName(county, null);
					}
				}
				int areaId = area == null ? 0 : area.getId();
				String treePath = area == null ? "" : area.getTreePath() ;
				
				course = new BaseCourse();
				course.setName(name);
				course.setShortName(short_name);
				course.setEnglishName(english_name);
				course.setInitial(initial);
				course.setFirstLetter(first_letter);
				course.setLogo(logo);
				course.setAreaId(areaId);
				course.setTreePath(treePath);
				course.setAddress(address);
				course.setLon(Double.valueOf(lon));
				course.setLat(Double.valueOf(lat));
				course.setStatus(Integer.valueOf(status) == 0 ? 4 : Integer.valueOf(status));
				course.setIsDelete(Checker.isNotEmpty(deleted_at) || name.contains("删除"));
				baseCourseMapper.insert(course);
				int courseId = course.getId();
				
				info = new BaseCourseInfo();
				info.setCourseId(courseId);
				info.setGolfHole(Integer.valueOf(golf_hole));
				info.setTelephone(telephone);
				info.setContact(contact);
				info.setMobile(mobile);
				info.setRemark(remark);
				info.setWebsite(website);
				info.setWechat(wechat);
				info.setHasAssistant(BooleanUtils.toBooleanObject(has_assistant));
				info.setSignPlace(sign_place);
				info.setSendPlace(send_place);
				info.setStartWorkTime(start_work_time);
				info.setEndWorkTime(end_work_time);
				info.setBagDepositCharge(Checker.isNotEmpty(bag_deposit_charge) ? Float.valueOf(bag_deposit_charge) : null);
				info.setTeeTimeInterval(Checker.isNotEmpty(tee_time_interval) ? Short.valueOf(tee_time_interval) : null);
				info.setTeeTimeEarliest(tee_time_earliest);
				info.setTeeTimeLatest(tee_time_latest);
				info.setTransitionClosedBeginTime(transition_closed_begin_time);
				info.setTransitionClosedEndTime(transition_closed_end_time);
				info.setWeather(weather);
				info.setDescription(description);
				info.setIntroducing(introducing);
				info.setIntroducingHref(introducing_href);
				info.setProductIntro(product_intro);
				info.setFeatureIntro(feature_intro);
				info.setFoodIntro(food_intro);
				info.setOtherIntro(other_intro);
				baseCourseInfoMapper.insert(info);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(reader != null){
				reader.close();
			}
		}
	}
	
}

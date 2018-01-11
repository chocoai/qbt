/**
 * Project Name:qbt-persistent
 * File Name:SolrTest.java
 * Package Name:com.solr
 * Date:2017年3月30日下午4:13:58
 *
*/

package com.solr;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.spatial.util.GeoHashUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.common.entity.search.SearchPage;
import com.qbt.common.entity.search.SolrLocation;
import com.qbt.common.entity.search.Sort;
import com.qbt.common.enums.CollectionType;
import com.qbt.common.enums.SortType;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.BaseCourseInfo;
import com.qbt.persistent.mapper.BaseCourseInfoMapper;
import com.qbt.persistent.mapper.BaseCourseMapper;
import com.qbt.persistent.solr.SolrCourse;
import com.qbt.solr.SolrService;

/**
 * ClassName:SolrTest
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月30日 下午4:13:58
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class SolrTest  extends AbstractJUnit4SpringContextTests {
	
	@Resource
	private BaseCourseMapper baseCourseMapper;
	
	@Resource
	private BaseCourseInfoMapper baseCourseInfoMapper;
	
	@Resource
	private SolrService solrService;
	
	@Test
	public void query(){
//		String queryStr = "*:*";
//		String filterQueryStr = "";
//		SearchPage<SolrCourse> page = new SearchPage<SolrCourse>();
//		SearchPage<SolrCourse> results = null;
//		try {
//			results = solrService.selectByPage(queryStr, filterQueryStr, page, SolrCourse.class, CollectionType.course);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(JSonUtil.toJSonString(results));
		
		SolrCourse course = solrService.selectById("800", SolrCourse.class, CollectionType.course);
		
		System.out.println(JSonUtil.toJSonString(course));
	}
	
	
	@Test
	public void add(){
		BaseCourse course = baseCourseMapper.findById(800);
		BaseCourseInfo courseInfo = baseCourseInfoMapper.selectByCourseId(800);
		SolrCourse solrCourse = new SolrCourse();
		
		BeanUtils.copyProperties(course, solrCourse);
		BeanUtils.copyProperties(courseInfo, solrCourse);
		
		SolrLocation location = new SolrLocation();
		location.setLatitude(course.getLat());;
		location.setLongitude(course.getLon());;
		solrCourse.setLocation(location);
		
		solrService.addBean(solrCourse, CollectionType.course);
	}
	
	@Test
	public void queryGeo(){
		String queryStr = "*:*";
		String filterQueryStr = "{!geofilt sfield=latlng pt=20.35,120.55 d=1000}";
		SearchPage<SolrCourse> searchPage = new SearchPage<SolrCourse>();
		String latlon = GeoHashUtils.stringEncode(20.35, 120.55);
		System.out.println(latlon);
//		List<Sort> sortList = new ArrayList<Sort>();
//		Sort sort1 = new Sort();
//		sort1.setSortKey("geodist()");
//		sort1.setSortType(SortType.ASC);
//		sortList.add(sort1);
//		searchPage.setSortList(sortList);
//		SearchPage<SolrCourse> courses = solrService.selectByPage(queryStr, filterQueryStr, searchPage, SolrCourse.class, CollectionType.course);
//		System.out.println(JSonUtil.toJSonString(courses));
	}
	
}

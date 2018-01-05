package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.course.CourseDetailVo;
import com.qbt.web.pojo.course.CoursePageReqVo;
import com.qbt.web.pojo.course.CoursePageRespVo;

public interface CourseSupport {
	
	/**
	 * 球场分页查询
	 * @param reqVo
	 * @return
	 */
	List<CoursePageRespVo> findByPage(CoursePageReqVo reqVo);
	
	/**
	 * 球场详情
	 * @param id
	 * @return
	 */
	CourseDetailVo findById(Integer id);
	
	/**
	 * 新增球场
	 * @param reqVo
	 * @return
	 */
	int add(CourseDetailVo reqVo) throws BusinessException;
	
	/**
	 * 更新球场
	 * @param vo
	 * @return
	 */
	boolean update(CourseDetailVo vo) throws BusinessException;
	
	/**
	 * 删除球场
	 * @param id
	 * @return
	 */
	boolean delete(int id, boolean isDelete);

}

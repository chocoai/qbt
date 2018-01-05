package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.BaseNewsCategory;
import com.qbt.service.BaseNewsCategoryService;
import com.qbt.web.pojo.baseNewsCatagory.BaseNewsCatagoryVo;
import com.qbt.web.pojo.baseNewsCatagory.NewsCatagoryPageVo;
import com.qbt.web.support.BaseNewsCategorySupport;

@Service
public class BaseNewsCategorySupportImpl implements BaseNewsCategorySupport {

	@Resource
	private BaseNewsCategoryService categoryService;
	
	/**
	 * 
	 * <b>方法名：</b>：doSave<br>
	 * <b>功能说明：</b>：添加保存新闻分类<br>
	 * @see com.qbt.web.support.BaseNewsCategorySupport#doSave(com.qbt.web.pojo.baseNewsCatagory.BaseNewsCatagoryVo)
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:25:17
	 * @param catagoryVo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public int doSave(BaseNewsCatagoryVo catagoryVo) throws BusinessException {
		BaseNewsCategory category = BeanUtil.a2b(catagoryVo, BaseNewsCategory.class);
		category.setName(catagoryVo.getName().trim());
		List<BaseNewsCategory> list = categoryService.findByName(category);
		//校验分类名称是否重复
		if (Checker.isNotEmpty(list)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(), "该分类名称已经被使用");
		}
		int categoryId = categoryService.insert(category);
		return categoryId;
	}

	/***
	 * 
	 * <b>方法名：</b>：doUpdate<br>
	 * <b>功能说明：</b>：修改新闻分类信息<br>
	 * @see com.qbt.web.support.BaseNewsCategorySupport#doUpdate(com.qbt.web.pojo.baseNewsCatagory.BaseNewsCatagoryVo)
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:25:32
	 * @param catagoryVo
	 * @return
	 * @throws BusinessException
	 */
	@Override
	public boolean doUpdate(BaseNewsCatagoryVo catagoryVo) throws BusinessException {
		//校验ID是否为空
		if (Checker.isEmpty(catagoryVo.getId())) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"请选择需要修改新闻分类");
		}
		//校验需要修改的数据是否存在
		BaseNewsCategory category = categoryService.selectById(catagoryVo.getId());
		if (Checker.isEmpty(category)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"您操作的数据不存在");
		}
		if (category.getStatus() != 1) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"你操作的数据已删除");
		}
		category = BeanUtil.a2b(catagoryVo, BaseNewsCategory.class);
		
		//校验被修改的分类名称 是否已被其他分类使用
		List<BaseNewsCategory> valiList = categoryService.findByNameExceptSelf(category);
		if (Checker.isNotEmpty(valiList)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"该分类名称经被使用");
		}
		int result = categoryService.updateById(category);
		return result > 0;
	}

	/**
	 * 
	 * <b>方法名：</b>：doFindNewsCatagortList<br>
	 * <b>功能说明：</b>：查询新闻分类列表<br>
	 * @see com.qbt.web.support.BaseNewsCategorySupport#doFindNewsCatagortList()
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:25:44
	 * @return
	 */
	@Override
	public List<BaseNewsCatagoryVo> doFindNewsCatagortList() {
		List<BaseNewsCategory> list = categoryService.findList();
		if (Checker.isNotEmpty(list)) {
//			List<BaseNewsCatagoryVo> resList = new ArrayList<BaseNewsCatagoryVo>();
//			for (BaseNewsCategory category :list ) {
//				BaseNewsCatagoryVo categoryVo = new BaseNewsCatagoryVo();
//				BeanUtils.copyProperties(category, categoryVo);
//				resList.add(categoryVo);
//			}
			List<BaseNewsCatagoryVo> resList = BeanUtil.list2list(list, BaseNewsCatagoryVo.class);
			return resList;
		}
		return null;
	}

	/**
	 * 
	 * <b>方法名：</b>：doFindNewsCatagoryPage<br>
	 * <b>功能说明：</b>：分页查询新闻分类<br>
	 * @see com.qbt.web.support.BaseNewsCategorySupport#doFindNewsCatagoryPage(com.qbt.web.pojo.baseNewsCatagory.NewsCatagoryPageVo)
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:26:02
	 * @param pageVo
	 * @return
	 */
	@Override
	public List<BaseNewsCatagoryVo> doFindNewsCatagoryPage(NewsCatagoryPageVo pageVo) {
		PageEntity<BaseNewsCategory> page = BeanUtil.pageConvert(pageVo, BaseNewsCategory.class);
		
		List<BaseNewsCategory> pageList = categoryService.findByPage(page);
		//复制结果集
		List<BaseNewsCatagoryVo> resultList = BeanUtil.list2list(pageList, BaseNewsCatagoryVo.class);
		
		pageVo.setTotalCount(page.getTotalCount());
		return resultList;
	}

	/**
	 * 
	 * <b>方法名：</b>：doDelete<br>
	 * <b>功能说明：</b>：删除新闻分类<br>
	 * @see com.qbt.web.support.BaseNewsCategorySupport#doDelete(int)
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:26:14
	 * @param id
	 * @return
	 */
	@Override
	public boolean doDelete(int id) {
		//校验ID是否为空
		if (Checker.isEmpty(id)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"请选择需要删除新闻分类");
		}
		//校验需要修改的数据是否存在
		BaseNewsCategory category = categoryService.selectById(id);
		if (Checker.isEmpty(category)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"你需要操作的数据不存在");
		}
		int result = categoryService.deleteById(id);
		return result>0;
	}

	@Override
	public BaseNewsCatagoryVo doFindCategoryDetail(Integer id) {
		if (Checker.isEmpty(id)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"请选择新闻分类");
		}
		BaseNewsCategory category =  categoryService.selectById(id);
		if (Checker.isEmpty(category)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL.getCode(),"数据不存在");
		}
		BaseNewsCatagoryVo categoryVo = BeanUtil.a2b(category, BaseNewsCatagoryVo.class);
		return categoryVo;
	}

}

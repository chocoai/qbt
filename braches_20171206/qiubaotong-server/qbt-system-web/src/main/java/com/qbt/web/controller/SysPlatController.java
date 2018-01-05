package com.qbt.web.controller;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.SysPlat.AdminSysPlatVO;
import com.qbt.web.support.AdminSysPlatSupport;

/**
 * 平台模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/sysPlat")
public class SysPlatController {

	@Resource
	private AdminSysPlatSupport adminSysPlatSupport;
	
	/**
	 * 获取列表
	 * @return
	 */
	@RequestMapping("list")
	public Result<List<AdminSysPlatVO>> list(){
		Result<List<AdminSysPlatVO>> result = new Result<List<AdminSysPlatVO>>();
		List<AdminSysPlatVO> adminSysPlatVOList = adminSysPlatSupport.list();
		result.setDatas(adminSysPlatVOList);
		return result;
	}
	
}

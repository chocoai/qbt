package com.qbt.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Producer;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.sms.api.service.CaptachaCodeService;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.web.pojo.comm.CaptachaResp;
import com.qbt.web.pojo.comm.SmsCodeReq;

/**
 *  短信验证码 及图片验码
  * @ClassName: CaptchaController
  * @Description: TODO
  * @author share 2017年3月2日
  * @modify share 2017年3月2日
 */
@Controller
@RequestMapping("/code")
public class CaptchaController {

	@Resource
	private Producer captchaProducer;
	
	@Resource
	private CaptachaCodeService captachaCodeService;
	
	@Resource
	private SmsCodeService smsCodeService;

	@RequestMapping(value ="/captchaImage")
	public Result<CaptachaResp> getKaptchaImage(){
		ByteArrayOutputStream out = null;
		Result<CaptachaResp> result = new Result<CaptachaResp>();
		try {
			CaptachaResp resp = new CaptachaResp();
			 // 图片验证码
			 String capText = captchaProducer.createText();// 生成验证码字符串
			 String token = captachaCodeService.saveCaptachaCode(capText);
			 resp.setCaptchaToken(token);
			 // 图片base 64验证码
			 BufferedImage bi = captchaProducer.createImage(capText);// 生成验证码图片
			 out = new ByteArrayOutputStream();
			 ImageIO.write(bi, "jpg", out);
			 String picBaseStr =  Base64.encodeBase64String(out.toByteArray());
			 resp.setImage(picBaseStr);
			 result.setDatas(resp);
		} catch (Exception e) {
			// TODO: handle exception
			LogCvt.error(e.getMessage(),e);
		}finally{
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
				}
		}
		
		return result;
		 
	 }
	
	/**
	 *  获取短信验证码
	  * @Title: getSmsCode
	  * @Description: TODO
	  * @author: share 2017年3月2日
	  * @modify: share 2017年3月2日
	  * @param request
	  * @param req
	  * @return
	 */
	@RequestMapping("/sms")
	public Result<String> getSmsCode(@RequestBody SmsCodeReq req){
		Result<String> result = new Result<String>();
		try {
			captachaCodeService.checkCaptachaCode(req.getCaptchaCode(), req.getCaptchaToken());
			
			String smsToken = smsCodeService.getSmsCode(req.getMobile());
			if(smsToken == null){
				result.setCode("8001");
				result.setMsg("获取验证码失败,请重新获取！");
			}else{
				result.setDatas(smsToken);
			}
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			// TODO: handle exception
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
}

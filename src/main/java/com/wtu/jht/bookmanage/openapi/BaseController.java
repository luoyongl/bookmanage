package com.wtu.jht.bookmanage.openapi;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wtu.jht.bookmanage.modal.TUser;
import com.wtu.jht.bookmanage.openapi.constant.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import com.google.gson.Gson;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: BaseController
 * @Description: 基础类
 * @author huangjiakui
 * @date 2018年12月04日
 *
 */
@SuppressWarnings("deprecation")
public class BaseController extends MultiActionController {
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	protected Gson gson = new Gson();
	public void writeByMapString(HttpServletResponse response, Map<Object, Object> map) {
		try {
			response.setCharacterEncoding("text/html;UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			ServletOutputStream sos = response.getOutputStream();
			List<SerializerFeature> list = new ArrayList<SerializerFeature>();
			list.add(SerializerFeature.WriteMapNullValue);
			list.add(SerializerFeature.WriteNullStringAsEmpty);
			list.add(SerializerFeature.WriteDateUseDateFormat);
			list.add(SerializerFeature.DisableCircularReferenceDetect);
			list.add(SerializerFeature.WriteMapNullValue);
			list.add(SerializerFeature.WriteNullNumberAsZero);
			list.add(SerializerFeature.PrettyFormat);
			SerializerFeature[] toBeStored = list.toArray(new SerializerFeature[list.size()]);
			String outVal = JSONObject.toJSONString(map, toBeStored);
			sos.write(outVal.getBytes("UTF-8"));
			sos.flush();
			sos.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@ModelAttribute("ctx")
	public String basePath(HttpServletRequest req) {
		String protocolv = req.getProtocol();
		String protocol = protocolv.split("/")[0];
		protocol = protocol.toLowerCase();
		String proj = req.getContextPath();
		String server = req.getServerName();
		int port = req.getServerPort();
		String base = protocol + "://" + server + ":" + port + proj;
		return base;
	}


	/**
	 * 获取当前登录管理员
	 * 
	 * @return 当前登录管理员，若不存在则返回null
	 */
	public TUser getCurrentUser() {
		return (TUser) SecurityUtils.getSubject().getSession().getAttribute(Constant.CURRENT_USER);
	}

	/**
	 * 设置当前登录管理员
	 * 
	 * @return
	 */
	public void setCurrentUser(TUser user) {
		SecurityUtils.getSubject().getSession().setAttribute(Constant.CURRENT_USER, user);
	}

	/**
	 * 获取当前登录用户名
	 * 
	 * @return 当前登录用户名，若不存在则返回null
	 */
	public String getCurrentUserName() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null) {
				return principal.getUsername();
			}
		}
		return null;
	}

	/**
	 * 清空相关session
	 */
	public void removeUserLoginInfo() {
		SecurityUtils.getSubject().getSession().removeAttribute(Constant.CURRENT_USER);
		SecurityUtils.getSubject().getSession().removeAttribute(Constant.CURRENT_COMPANY);
		SecurityUtils.getSubject().getSession().removeAttribute(Constant.CURRENT_USER_PERMISSION);
	}

	/**
	 * 是否通过认证
	 * 
	 * @return
	 */
	public boolean isAuthenticated() {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			return subject.isAuthenticated();
		}
		return false;
	}
}

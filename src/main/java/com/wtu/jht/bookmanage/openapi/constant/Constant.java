package com.wtu.jht.bookmanage.openapi.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 
    * @ClassName: Constant
    * @Description: 常量类
    * @author huangjiakui
    * @date 2018年12月04日
    *
 */
public class Constant {
	
	public static final int PAGE_SIZE = 10;
	
	public static final int APP_PAGE_SIZE = 20;

	public static final String ADMIN = "admin";
	
	public static final String UPLOAD_FOLDER_NAME = "uploads";
	public static final String QRCODE_FOLDER_NAME = "qrcode";
	public static final String EQUIP_IMG_FOLDER_NAME = "equipImg";

	public static final String CURRENT_USER = "currentUser";
	public static final String CURRENT_COMPANY = "currentCompany";
	public static final String CURRENT_USER_PERMISSION = "userPermission";
	public static final String CURRENT_USER_MENU = "userMenu";

	public static final String API_CURRENT_USER = "currentApiUser";
	public static final String API_CURRENT_COMPANY = "currentApiCompany";
	public static final String API_CURRENT_USER_PERMISSION = "userApiPermission";
	public static final String API_CURRENT_USER_MENU = "userApiMenu";
	
	public static final Integer COMPANY_ADMIN_ID = 2;

	public static final Integer EQUIP_CONTROLLER_TYPE_ID = 1;
	public static final Integer EQUIP_FEED_SYS_ID = 8;
	/**
	 * 验证码类型
	 */
	public enum CaptchaType {
		/** 后台登录 */
		adminLogin,

		/** 找回密码 */
		findPassword,

		/** 重置密码 */
		resetPassword,

		/** 其它 */
		other
	}

	/**
	 * 保存已经正在使用的PID
	 */
	public static List<String> usedPidList = new ArrayList<String>();

}
package com.csssj.taobao.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.Before;

public class BaseAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2173476253663342513L;
	protected static Logger log = Logger.getLogger(BaseAction.class);

	public static final String SESSION_USER_STR = "User";

	protected HttpServletRequest request = null;
	protected HttpSession session = null;
	protected HttpServletResponse response = null;
	protected String product;
	protected String productXML;
	protected String productCode;

	public BaseAction() {
		log.debug("============BaseAction init===============");
		if (request != null) {
			return;
		}
		log.debug("============BaseAction init request is null===============");
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
	}

	@Before
	public void doBefore() {
		log.debug("============before action,init request and session and response===============");
		if (request != null) {
			return;
		}
		log.debug("============before action,init request and session and response  request is null===============");
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		session = request.getSession();
	}
	protected void setLoginUser(String username){
		session.setAttribute(SESSION_USER_STR, username);
	}
	protected boolean isLogin(){
		return isLogin(session);
	}
	public static boolean isLogin(HttpSession session){
		return session.getAttribute(SESSION_USER_STR) != null;
	}
	protected void removeLoginUser() {
		removeLoginUser(session);
	}

	public static void removeLoginUser(HttpSession session) {
		Enumeration<?> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			session.removeAttribute(key);
		}
		session.invalidate();
	}
	
}

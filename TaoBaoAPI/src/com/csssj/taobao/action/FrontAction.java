package com.csssj.taobao.action;

import com.pub.util.CF;


public class FrontAction extends BaseAction {
	private static final long serialVersionUID = -945145455301101378L;
	
	private String seller_nick,module_width,envMode,shop_id;
	
	public String Show(){
		shop_id = CF.getParameter(request, "shop_id");
		String mobileurl = "http://shop"+shop_id+".m.taobao.com";
		mobileurl  = "http://api.kuaipai.cn/qr?chs=120x120&chl="+mobileurl;
		request.setAttribute("mobileurl", mobileurl);
		return "show";
	}
	public String Download(){
		return "download";
	}
	public String SendSMS(){
		return "SendSMS";
	}
	
	

}

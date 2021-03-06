package com.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.entity.Company;
import com.service.CompanyService;

public class IOSCompanyServlet extends HttpServlet {

//	http://localhost:8080/SoBer_W1_0.1_Alpha/companyInfo
	/**
	 * Constructor of the object.
	 */
	public IOSCompanyServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	//查找新闻内容
	String companyInfo;
  public String getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}

	public String companyInfo(){
	  	
		HttpServletRequest request=ServletActionContext.getRequest();
		
		CompanyService companyService=new CompanyService();
		List<Company> companyList = companyService.findAll();
		
		JSONObject jsonContentAll=new JSONObject();
		JSONObject jsonContent=new JSONObject();
		String value=(String)companyList.get(0).getContent();
		jsonContent.put("content", value);//向前端传送键值对||此处的companyList是List<Company>的集合的实例化
		jsonContentAll.put("date", jsonContent);
		
		String jsonStr=jsonContentAll.toString();
		request.setAttribute("json", jsonStr);
		
		return "IOScompanyContent";//返回到Struts.xml中的action中的jsonDate.jsp
  }
	public void init() throws ServletException {
	 
	}
}

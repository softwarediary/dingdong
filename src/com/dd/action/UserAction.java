package com.dd.action;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.SessionAware;  
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dd.dao.Userdao;
import com.dd.model.User;
import com.opensymphony.xwork2.ActionSupport;


@Controller @Scope("prototype")

public class UserAction extends ActionSupport implements SessionAware{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*业务层对象*/
    @Resource Userdao userdao;
    
    private String prePage;
    
    //这两个成员变量是用来做登录拦截的，记得添加setter和getter
    private User user;
	private Map<String,Object> session;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	
	
	private String errMessage;
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
	
	/*
	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		session.put("curCustomer", customer);
		return "show_view";
		
	}*/
	
    //注册，并在session中加入用户名
	public String reg() throws Exception{
		user.setUvalue(0);
		userdao.addUser(user);
		session.put("user", user);
		return "successreg";

	}
    
	/* 验证用户登录 */
	/*public String login() {
		Customer db_customer = (Customer)customerDao.QueryCustomerInfo(customer.getName()).get(0);
		if(db_customer == null) { 
			
			this.errMessage = " 账号不存在 ";
			System.out.print(this.errMessage);
			return INPUT;
			
		} else if( !db_customer.getPassword().equals(customer.getPassword())) {
			
			this.errMessage = " 密码不正确! ";
			System.out.print(this.errMessage);
			return INPUT;
			
		}else{
			return "show_view";
			
		}	*/	

	
		/* 验证用户登录 */
		public String login() {
			
			ArrayList<User> listUser = userdao.QueryUserInfo(user.getUname());
			 //user=listUser.get(0); 
			 
			 System.out.print("输入密码="+user.getPasswd());
			if(listUser.size()==0) { 
				
				this.errMessage = " 账号不存在 ";
				System.out.print(this.errMessage);
				return "input";
				
			} 
			else{
				
			   User db_user = listUser.get(0);
			   System.out.print("用户密码="+db_user.getPasswd());
				if(!db_user.getPasswd().equals(user.getPasswd())) {
					this.errMessage = " 密码不正确! ";
					System.out.print(this.errMessage);
					return "input";
				
			    }else{
			    	user=listUser.get(0);
					session.put("user", db_user);
					return "success";
			    }
			}
		}

		public String getPrePage() {
			return prePage;
		}

		public void setPrePage(String prePage) {
			this.prePage = prePage;
		}


}
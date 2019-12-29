package com.dd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dd.model.User;



@Service @Transactional
public class Userdao {
	@Resource SessionFactory factory;
	
	 /*添加Customer信息*/
    public void addUser(User user) throws Exception {
    	Session s = factory.getCurrentSession();
    	s.save(user);
    }
    
    /*删除Customer信息*/
    public void deleteUser (Integer userId) throws Exception {
        Session s = factory.getCurrentSession(); 
        Object user = s.load(User.class, userId);
        s.delete(user);
    }
    
    /*更新Customer信息*/
    public void updateUser(User user) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(user);
    }
    
    /*查询所有Customer信息*/
    public ArrayList<User> QueryAllUser() {
        Session s = factory.getCurrentSession();
        String hql = "From User";
        Query q = s.createQuery(hql);
        List userList = q.list();
        return (ArrayList<User>) userList;
    }

    /*根据主键获取对象*/
    public User GetUserById(Integer userid) {
        Session s = factory.getCurrentSession();
        User user = (User)s.get(User.class, userid);
        return user;
    }
    
    /*根据查询条件查询*/
    public ArrayList<User> QueryUserInfo(String name) {
    	
    	Session s = factory.getCurrentSession();
    	List userList;
    	String hql = "From User user where 1=1";
    	if(!name.equals("")){ 
    		
    		hql = hql + " and user.uname like '%" + name + "%'";
	    	Query q = s.createQuery(hql);
	    	userList = q.list();
	    	
    	}else{
    		
    	   userList =null;	
    	
    	}
    	return (ArrayList<User>) userList;
    }

}

package com.dd.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dd.model.Habit;
import com.dd.model.User;

@Service @Transactional

public class HabitDao {
	
@Resource SessionFactory factory;
	
	public void addHabit(Habit habit){
		Session s= factory.getCurrentSession();
		s.save(habit);
		
	}
	
	public void deleteHabit(Integer hid){
		Session s= factory.getCurrentSession();
		Object habit= s.load(Habit.class, hid);
		s.delete(habit);
		
	}
	
    public void UpdateHabit(Habit habit) throws Exception {
        Session s = factory.getCurrentSession();
        s.update(habit);
    }
    
    /*public ArrayList<Habit> QueryAllHabit() {
        Session s = factory.getCurrentSession();
        String hql = "From Habit";
        Query q = s.createQuery(hql);
        List habitList = q.list();
        return (ArrayList<Habit>) habitList;
    }*/
    public ArrayList<Habit> QueryAllHabit(User user) {
    	Session s = factory.getCurrentSession();
    	String hql = "From Habit habit where 1=1";
    	if(null != user && user.getUid()!=0) 
    		hql = hql + " and habit.user.uid like '%" + user.getUid() + "%'";
    	Query q = s.createQuery(hql);
    	List habitList = q.list();
    	return (ArrayList<Habit>) habitList;
    }
    
    public Habit GetHabitById(Integer hid) {
        Session s = factory.getCurrentSession();
        Habit habit = (Habit)s.get(Habit.class, hid);
        return habit;
    }
    
    public ArrayList<Habit> QueryHabit(User user,String hname) { 
    	Session s = factory.getCurrentSession();
    	String hql = "From Habit habit where 1=1";
    	if(null != user && user.getUid()!=0) 
    		hql = hql + " and habit.user.uid like '%" + user.getUid() + "%'";
    	if(!hname.equals(" ")) 
    		hql = hql + " and habit.hname like '%" + hname + "%'";
    	Query q = s.createQuery(hql);
    	List habitList = q.list();
    	return (ArrayList<Habit>) habitList;
    }

}

package com.dd.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dd.dao.HabitDao;
import com.dd.dao.Userdao;
import com.dd.model.Habit;
import com.dd.model.Reward;
import com.dd.model.User;

import com.opensymphony.xwork2.ActionSupport;

@Controller @Scope("prototype")
public class HabitAction extends ActionSupport{
@Resource HabitDao habitDao;
@Resource Userdao userDao;
	
	private Habit habit;
	private User user;
	private File habitPhoto;
	private String habitPhotoFileName;
	private String habitPhotoContentType;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public File getHabitPhoto() {
		return habitPhoto;
	}

	public void setHabitPhoto(File habitPhoto) {
		this.habitPhoto = habitPhoto;
	}

	public String getHabitPhotoFileName() {
		return habitPhotoFileName;
	}

	public void setHabitPhotoFileName(String habitPhotoFileName) {
		this.habitPhotoFileName = habitPhotoFileName;
	}

	public String getHabitPhotoContentType() {
		return habitPhotoContentType;
	}

	public void setHabitPhotoContentType(String habitPhotoContentType) {
		this.habitPhotoContentType = habitPhotoContentType;
	}


	public Habit getHabit() {
		return habit;
	}

	public void setHabit(Habit habit) {
		this.habit = habit;
	}
	
	private List<Habit> habitList;

	public List<Habit> getHabitList() {
		return habitList;
	}

	public void setHabitList(List<Habit> habitList) {
		this.habitList = habitList;
	}
	 public String showAdd() throws Exception {
		user=userDao.QueryUserInfo(user.getUname()).get(0);
		 return "add_view";
	 }
	public String addHabit() throws Exception{
		String path = ServletActionContext.getServletContext().getRealPath("/upload"); 
        
        String habitPhotoFileName = ""; 
   	 	if(habitPhoto!= null) {
   	 		InputStream is = new FileInputStream(habitPhoto);
   			String fileContentType = this.getHabitPhotoContentType();
   			System.out.println(fileContentType);
   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
   				habitPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
   			else if(fileContentType.equals("image/gif"))
   				habitPhotoFileName = UUID.randomUUID().toString() +  ".gif";
   			else if(fileContentType.equals("image/png"))
   				habitPhotoFileName = UUID.randomUUID().toString() +  ".png";

   			File file = new File(path, habitPhotoFileName);
   			OutputStream os = new FileOutputStream(file);
   			byte[] b = new byte[1024];
   			int bs = 0;
   			while ((bs = is.read(b)) > 0) {
   				os.write(b, 0, bs);
   			}
   			is.close();
   			os.close();
   	 	}
        if(habitPhoto != null)
        	habit.setPic("upload/" + habitPhotoFileName);
        else
        	habit.setPic("upload/NoImage.jpg");
		user=userDao.QueryUserInfo(user.getUname()).get(0);
		habit.setUser(user);
		habit.setFinishedNum(0);
		habitDao.addHabit(habit);
		return "message";
	}
	
	public String showHabit(){
		User u=userDao.QueryUserInfo(user.getUname()).get(0);
		habitList=habitDao.QueryAllHabit(u);
		return "show_habit";
	}
	
	 public String editHabit() throws Exception {
		 System.out.println("编辑习惯");
	    	String path = ServletActionContext.getServletContext().getRealPath("/upload"); 

	        String habitPhotoFileName = ""; 
	   	 	if(habitPhoto!= null) {
	   	 		InputStream is = new FileInputStream(habitPhoto);
	   			String fileContentType = this.getHabitPhotoContentType();
	   			System.out.println(fileContentType);
	   			if(fileContentType.equals("image/jpeg")  || fileContentType.equals("image/pjpeg"))
	   				habitPhotoFileName = UUID.randomUUID().toString() +  ".jpg";
	   			else if(fileContentType.equals("image/gif"))
	   				habitPhotoFileName = UUID.randomUUID().toString() +  ".gif";
	   			else if(fileContentType.equals("image/png"))
	   				habitPhotoFileName = UUID.randomUUID().toString() +  ".png";

	   			File file = new File(path, habitPhotoFileName);
	   			OutputStream os = new FileOutputStream(file);
	   			byte[] b = new byte[1024];
	   			int bs = 0;
	   			while ((bs = is.read(b)) > 0) {
	   				os.write(b, 0, bs);
	   			}
	   			is.close();
	   			os.close();
	   	 	}
	        if(habitPhoto != null)
	        	habit.setPic("upload/" + habitPhotoFileName);
	        else
	        	habit.setPic("upload/NoImage.jpg");
	    	Habit h=habitDao.GetHabitById(habit.getHid());
	    	user=userDao.QueryUserInfo(user.getUname()).get(0);
	    	habit.setUser(user);
	    	habit.setFinishedNum(h.getFinishedNum());
	    	habitDao.UpdateHabit(habit);
	        return "edit_message";
	    }
	 public String showEdit() throws Exception {
		 user=userDao.QueryUserInfo(user.getUname()).get(0);
		 habit = habitDao.GetHabitById(habit.getHid());
		 return "edit_view";
	 }
	 

	 public String daka() throws Exception {
		 Habit h=habitDao.GetHabitById(habit.getHid());
		 System.out.println("hhh"+user.getUname());

		 user=userDao.QueryUserInfo(user.getUname()).get(0); 
		 h.setFinishedNum(h.getFinishedNum()+1);
		 user.setUvalue(user.getUvalue()+h.getHvalue());
		 userDao.updateUser(user);
		 habitDao.UpdateHabit(h);
		 System.out.println("�ɹ���һ��ϰ��"+user.getUvalue()+"  hhh");
		 return "daka_success";
	 }
	 public String deleteHabit() throws Exception {
		 habitDao.deleteHabit(habit.getHid());
		 return "delete_message";
	 }
  
	 private String hname;
	 public String getHname(){
		 return hname;
	 }
	 public void setHname(String hname){
		 this.hname=hname;
	 }
	 
	 public String selectHabit(){
		 User u=userDao.QueryUserInfo(user.getUname()).get(0);
		 habitList=habitDao.QueryHabit(u,hname);
		 return "show_habit";
	 }
	 
	 public String showDetail(){
		 user=userDao.QueryUserInfo(user.getUname()).get(0);
		 habit=habitDao.GetHabitById(habit.getHid());
		 return "detail_view";
	 }
}

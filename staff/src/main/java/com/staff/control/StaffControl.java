package com.staff.control;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import com.staff.dao.StaffDao;
import com.staff.domain.Staff;
import com.staff.service.StaffService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller("staffControl") 
@RequestMapping("/staff") 
public class StaffControl {
	static Logger log = Logger.getLogger(StaffControl.class);
	
  @Autowired StaffDao       staffDao; 
  @Autowired StaffService   staffService;
  @Autowired ServletContext  servletContext;
  
//  @RequestMapping(value="/add", method=RequestMethod.POST)
//  public Object updataPhoto(Staff staff) throws Exception {
//  	
//  	if(staff.getUserPhotofile() != null &&
//  			!staff.getUserPhotofile().isEmpty()) {
//  		
//  		String fileuploadRealPath = 
//  				servletContext.getRealPath("/fileupload");
//  		String filename = System.currentTimeMillis() + "_";
//  		File file = new File(fileuploadRealPath + "/" + filename);
//  		
//  		staff.getUserPhotofile().transferTo(file);
//  		staff.setUserPhoto(filename);
//  	}
//  	
//  	staffService.add(staff);
//  	
//  	HashMap<String, Object> resultMap = new HashMap<>();
//  	resultMap.put("status","success");
//  	
//  	return resultMap;
//  }
  
  public Object update (Staff staff) throws Exception {
  	staffService.update(staff);
  	
  	HashMap<String, Object> resultMap = new HashMap<>();
  	resultMap.put("status", "success");
  	
  	return resultMap;
  }
  
//  //회원정보 수정
//  @RequestMapping("/user_info")
//  public Object userInfo(HttpSession session) throws Exception {
//    
//    Staff loginUser =  (Staff)session.getAttribute("loginUser");
//    
//    int mno = loginUser.getStaffNo();
//    Staff staff = staffService.getUserInfo(mno);
//    
//    HashMap<String,Object> resultMap = new HashMap<>();
//    resultMap.put("status", "success");    
//    resultMap.put("staff", staff);
//    
//    return resultMap;
//  }
  
//  @RequestMapping(value="/update", method=RequestMethod.POST)
//  public Object edit(Staff staff) throws Exception {
//    System.out.println(staff);
//    staffService.edit(staff);
//    
//    HashMap<String,Object> resultMap = new HashMap<>();
//    resultMap.put("status", "success");
//    
//    return resultMap;
//  }
  
}


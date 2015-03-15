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
	
  @Autowired StaffDao       staffdao; 
  @Autowired StaffService   staffService;
  @Autowired ServletContext  servletContext;
  
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public Object updataPhoto(Staff staff) throws Exception {
  	
  	if(staff.getUserPhotofile() != null &&
  			!staff.getUserPhotofile().isEmpty()) {
  		
  		String fileuploadRealPath = 
  				servletContext.getRealPath("/fileupload");
  		String filename = System.currentTimeMillis() + "_";
  		File file = new File(fileuploadRealPath + "/" + filename);
  		
  		staff.getUserPhotofile().transferTo(file);
  		staff.setUserPhoto(filename);
  	}
  	
  	staffService.add(staff);
  	
  	HashMap<String, Object> resultMap = new HashMap<>();
  	resultMap.put("status","success");
  	
  	return resultMap;
  }
//파일업로드
  @RequestMapping(value="/test", method=RequestMethod.POST)
  public Object testPhoto(HttpSession session,MultipartFile userPhotofile) throws Exception {
    
    Staff loginUser =  (Staff)session.getAttribute("loginUser");
    
    
    //System.out.println(mno);
    
    System.out.println(userPhotofile);//org.springframework.web.multipart.commons.CommonsMultipartFile@129d4ef

    String fileuploadRealPath = 
        servletContext.getRealPath("/fileupload");
    String filename = System.currentTimeMillis() + "_"; 
    File file = new File(fileuploadRealPath + "/" + filename);

    System.out.println(file); ///home/bit/javaide/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/iumui/fileupload/1422322069827_
    System.out.println(filename); //1422322069827_
    System.out.println(userPhotofile);

    userPhotofile.transferTo(file);

    loginUser.setUserPhoto(filename); //1422322069827_

    System.out.println(file);   //home/bit/javaide/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/iumui/fileupload/1422322069827_
    System.out.println(filename);

    staffService.photoadd(loginUser);

    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");

    return resultMap;
  }
  
  
  public Object update (Staff staff) throws Exception {
  	staffService.update(staff);
  	
  	HashMap<String, Object> resultMap = new HashMap<>();
  	resultMap.put("status", "success");
  	
  	return resultMap;
  }
  
  public Object execute(int mno) throws Exception {
  	
  	Staff staff = staffService.get(mno);
  	
  	HashMap<String, Object> resultMap = new HashMap<>();
  	resultMap.put("status", "success");
  	resultMap.put("staff", staff);
  	resultMap.put("photos", staff.getUserPhotoList());
  	
  	return resultMap;
  }
  
  //회원정보 수정
  @RequestMapping("/user_info")
  public Object userInfo(HttpSession session) throws Exception {
    
    Staff loginUser =  (Staff)session.getAttribute("loginUser");
    
    int mno = loginUser.getStaffNo();
    Staff staff = staffService.getUserInfo(mno);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");    
    resultMap.put("staff", staff);
    
    return resultMap;
  }
  
  @RequestMapping("/user_info1")
  public Object userInfo1(HttpSession session) throws Exception {
    
    Staff loginUser =  (Staff)session.getAttribute("loginUser");
    
    int mno = loginUser.getStaffNo();
    String localName = staffService.getUserInfo1(mno);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");    
    resultMap.put("localName", localName);
    
    return resultMap;
  }
  
  @RequestMapping(value="/update", method=RequestMethod.POST)
  public Object edit(Staff staff) throws Exception {
    System.out.println(staff);
    staffService.edit(staff);
    
    HashMap<String,Object> resultMap = new HashMap<>();
    resultMap.put("status", "success");
    
    return resultMap;
  }
  
  //아이디 찾기
  @RequestMapping(value="/findId", method=RequestMethod.POST)
  public Object findId(String name,String birthDate,String phone) throws Exception {
    staffService.FindId(name,birthDate,phone);
    HashMap<String,Object> resultMap = new HashMap<>();
    
    resultMap.put("status", "success");
    resultMap.put("check", staffService.FindId(name, birthDate, phone));
    
    System.out.println(staffService.FindId(name, birthDate, phone));
    
    return resultMap;
    
  }
  
//비밀번호 찾기
  @RequestMapping(value="/findPw", method=RequestMethod.POST)
  public Object findPw(String name,String birthDate,String email) throws Exception {
    staffService.FindPw(name,birthDate,email);
    HashMap<String,Object> resultMap = new HashMap<>();
    
    resultMap.put("status", "success");
    resultMap.put("check", staffService.FindPw(name, birthDate, email));
    
    System.out.println(staffService.FindPw(name,birthDate, email));
    
    
    return resultMap;
  }
	@RequestMapping("/thisgroupstaffs")
	public Object getAllGroups ( 
			int gno) throws Exception {
		
		List<?> groupStaffs = staffService.getGroupStaffs(gno);
		
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("status","success");
		resultMap.put("groupStaffs", groupStaffs);
		
		return resultMap;
	}
}


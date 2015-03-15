package com.staff.control;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//import com.staff.domain.Staff;
//import com.staff.service.MakerService;
//import com.staff.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffControl {
  static Logger log = Logger.getLogger(StaffControl.class);
  static final int PAGE_DEFAULT_SIZE = 5;
  
  @Autowired StaffService     staffService;
  @Autowired MakerService       makerService;
  
  @Autowired ServletContext servletContext;

  @RequestMapping(value="/add", method=RequestMethod.GET)
  public ModelAndView form() throws Exception {
    ModelAndView mv = new ModelAndView();
    mv.addObject("makers", makerService.getList());
    mv.setViewName("staff/StaffForm");
    return mv;
  }
 
  @RequestMapping(value="/add", method=RequestMethod.POST)
  public String add(Staff staff) throws Exception {  
    String fileuploadRealPath = 
        servletContext.getRealPath("/fileupload");
    String filename = System.currentTimeMillis() + "_"; 
    File file = new File(fileuploadRealPath + "/" + filename);
    staff.getPhotofile().transferTo(file);
    staff.setPhoto(filename);

    staffService.add(staff);
    
    return "redirect:list.do";
  }

  @RequestMapping("/delete")
  public String delete(int no) throws Exception {
    staffService.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="5") int pageSize,
      Model model) throws Exception {
    
    if (pageSize <= 0)
      pageSize = PAGE_DEFAULT_SIZE;
    
    int maxPageNo = staffService.getMaxPageNo(pageSize);
    
    if (pageNo <= 0) pageNo = 1;
    if (pageNo > maxPageNo) pageNo = maxPageNo;
    
    model.addAttribute("staffs", 
        staffService.getList(pageNo, pageSize));
    
    model.addAttribute("currPageNo", pageNo);
    
    if (pageNo > 1) {
      model.addAttribute("prevPageNo", (pageNo - 1));
    }
    
    if (pageNo < maxPageNo) {
      model.addAttribute("nextPageNo", (pageNo + 1));
    }
    
    return "staff/StaffList";
  }
  
  @RequestMapping("/update")
  public String update(Staff staff) throws Exception {
    staffService.update(staff);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) throws Exception {
    Staff staff = staffService.get(no);
    model.addAttribute("staff", staff);
    model.addAttribute("photos", staff.getPhotoList());
    model.addAttribute("makers", makerService.getList());
    return "staff/StaffView";
  }
}













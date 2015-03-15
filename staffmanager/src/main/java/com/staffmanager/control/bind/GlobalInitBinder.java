package com.staffmanager.control.bind;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalInitBinder {
  static Logger log = Logger.getLogger(GlobalInitBinder.class);
  
  // 조언 하나! 
  // => 문자열의 요청 파라미터 값을 java.util.Date으로 바꿀 때는
  //    CustomDateEditor를 사용하라!
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    log.debug("initBinder() 호출됨");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
    dateFormat.setLenient(false);
    
    // 문자열을 특정 타입으로 바꿀 변환기를 등록
    binder.registerCustomEditor(
        Date.class, /* 어떤 타입으로 바꿀 것인지 지정*/ 
        new CustomDateEditor(dateFormat, true) /* 변환기 */
        );
  }
}













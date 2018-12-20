package com.tang.sso.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tang.common.utils.JasonUtils;

@RestController
public class UserController {

    @RequestMapping("/page/register")
    public String showRegister(){
	TbUser tbuser =new TbUser();
	tbuser.setCredata(new Date());
	tbuser.setName("zhangsan");
	return JasonUtils.objectToJson(tbuser);
	//return "hello world";
	
	
    }
}

class TbUser{
    private String name;
    private Date credata;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getCredata() {
        return credata;
    }
    public void setCredata(Date credata) {
        this.credata = credata;
    }
    
}

package cn.melonydi.fleamarket.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.melonydi.fleamarket.model.Admin;

@Controller
@Scope("prototype")
public class AdminAction extends BaseAction<Admin> {
	
	public String login() {
		System.out.println(adminService);
		return SUCCESS;
	}
}

package cn.melonydi.fleamarket.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 此action用来完成web-inf中jsp与jsp请求转发的功能，不处理任何的业务逻辑
 * @author mike
 *
 */
@Controller
public class SendAction extends ActionSupport{
	public SendAction() {
		System.out.println("---sendAction---");
	}
	
	public String execute() {
		System.out.println("---execute---");
		return "send";
	}
	
}

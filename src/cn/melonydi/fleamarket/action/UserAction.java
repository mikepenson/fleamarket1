package cn.melonydi.fleamarket.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.melonydi.fleamarket.model.Admin;
import cn.melonydi.fleamarket.model.User;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	public String queryByUsername() {
		// 创建jsonMap
		jsonMap=new HashMap<String, Object>();
		// 查询根据关键字分页查询用户数据
		List<User> userList=userService.queryByUsername(model.getUsername(),page,rows);
		// 查询根据关键字查询总记录数
		Long total=userService.getCount(model.getUsername());
		// 根据EasyUi的json格式存放数据： total：总数，rows：数据
		jsonMap.put("total", total);
		jsonMap.put("rows", userList);
		return "jsonMap";
	}
	
	public String delete() {
		//System.out.println(model.getId());
		userService.delete(model.getId());
		//如果删除成功就会往下执行，我们将"true"以流的形式传给前台 
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	// 创建createImage方法
	public String createImage() {
		inputStream=verifyCode.createImage();
		String securityCode=verifyCode.getSecurityCode();
		session.put("securityCode", securityCode);
		return "imageStream";
	}
	
	// 检查验证码
	public String checkCode() {
		String securityCode=(String) session.get("securityCode");
		String flag="false";
		System.out.println("securityCode:"+securityCode+"  veryCode："+veryCode);
		if (securityCode.equals(veryCode)) {
			flag="true";
		}
		inputStream=new ByteArrayInputStream(flag.getBytes());
		return "stream";
	}
	
	// 登录操作
	public String login() {
		User user=userService.login(model.getUsername());
		
		if (model.getPassword().equals(user.getPassword())) {
			session.put("user", user);
			if(session.get("goURL") == null) {  
                return "index"; //跳到首页  
            } else {  
                return "goURL";  
            }  
		}else{
			session.put("error", "登陆失败");
			return "login";
		}
	}
	
	// 退出操作,跳转到主页
	public String logout() {
		session.remove("user");
		return "index";
	}
	/**
	 * 以下是注册环节
	 */
	//  验证用户名
	public String validateName() {
		User user=userService.getUserByUsername(model.getUsername());
		if (user!=null) {
			inputStream=new ByteArrayInputStream("true".getBytes());
		}else {
			inputStream=new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	// 验证邮箱
	public String validateEmail() {
		User user=userService.getUserByEmail(model.getEmail());
		if (user!=null) {
			inputStream=new ByteArrayInputStream("true".getBytes());
		}else {
			inputStream=new ByteArrayInputStream("false".getBytes());
		}
		return "stream";
	}
	// 注册
	public String register() {
		userService.save(model);
		return "login";
	}
}

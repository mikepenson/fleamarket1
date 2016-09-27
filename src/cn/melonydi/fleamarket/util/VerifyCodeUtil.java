package cn.melonydi.fleamarket.util;

import java.io.InputStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("verifyCode")
@Scope("prototype")
public class VerifyCodeUtil implements VerifyCode{
	
	private String securityCode;
	
	public VerifyCodeUtil(){
		this.securityCode=SecurityCode.getSecurityCode();
	}
	
	// 返回图片流 
	public InputStream createImage() {
		// 获取默认难度和长度的验证码
		return SecurityImage.getImageAsInputStream(getSecurityCode());
		// 放入session中
		// 取输出流
	}

	// 返回验证码字符
	public String getSecurityCode() {
		return securityCode;
	}

	/**
	 * 验证，true 验证成功 false 验证失败
	 * 
	 * @return
	 * @throws Exception
	 */
//	public String checkVerifyCode(){
//		// 从session中取出生成的验证码
//		String securityCode = (String) ActionContext.getContext().getSession().get("securityCode");
//		// 取输出流
//		HttpServletResponse rsp = ServletActionContext.getResponse();
//		// 处理中文
//		/*rsp.setContentType("text/html;charset=gbk");
//		rsp.setCharacterEncoding("gbk");*/
//		try {
//			PrintWriter print = rsp.getWriter();
//			// 验证标志位:true 验证成功 false 验证失败
//			String flag = "0";
//			if (verycode == null || "".equals(verycode)) {
//				flag = "0"; // 验证失败
//			} else {
//				if (securityCode.equals(verycode)) {
//					flag = "1"; // 验证成功
//				}
//			}
//			
//			print.print(flag);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		return null;
//	}

}

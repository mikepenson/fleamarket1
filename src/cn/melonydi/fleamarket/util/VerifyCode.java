package cn.melonydi.fleamarket.util;

import java.io.InputStream;

public interface VerifyCode {
	public InputStream createImage();
	
	// 返回验证码字符
	public String getSecurityCode();
}

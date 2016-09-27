package cn.melonydi.fleamarket.util;

import cn.melonydi.fleamarket.model.FileImage;


public interface FileUpload {

	// 3： 实现文件上传的功能，返回上传后的文件名称
	public String uploadFile(FileImage fileImage);
	
}
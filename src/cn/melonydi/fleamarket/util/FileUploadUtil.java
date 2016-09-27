package cn.melonydi.fleamarket.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.melonydi.fleamarket.model.FileImage;


/**
 * 用来实现文件上传的业务逻辑
 * @author mike
 *
 */
@Component("fileUpload")
public class FileUploadUtil implements FileUpload {
	@Value("#{prop.basePath+prop.filePath}")
	private String filePath;
	
	// 1： 通过文件名获取扩展名
	private String getFileExt(String fileName) {
		return FilenameUtils.getExtension(fileName);
	}
	
	// 2: 生成UUID随机数，作为新的文件名
	private String newFileName(String fileName) {
		String ext=getFileExt(fileName);
		return UUID.randomUUID().toString()+"."+ext;
	}
	
	// 3： 实现文件上传的功能，返回上传后的文件名称
	/* (non-Javadoc)
	 * @see cn.it.shop.util.FileUpload#uploadFile(cn.it.shop.model.FileImage)
	 */
	@Override
	public String uploadFile(FileImage fileImage) {
		// 获取唯一文件名
		String pic=newFileName(fileImage.getFilename());
		try {
			FileUtil.copyFile(fileImage.getFile(),new File(filePath,pic));
			return pic;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			fileImage.getFile().delete();
		}
		
	}
}

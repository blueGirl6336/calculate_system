package com.cesystem.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileUtil {
	
	public static String savePath = "c:/CeFile";
	
	/**
	 * 上传文件
	 * @param filePath
	 * @param fileData
	 * @return
	 */
	public static boolean uploadFile(String filePath, File fileData,String fileName) {
		File dir = new File(filePath);
		if(!dir.exists()  && !dir.isDirectory())
		{
			//目录不存在，创建目录
			dir.mkdir();
		}

		File file=new File(filePath+"/"+fileName);    

		if(file.exists())    
		{    
			return false;
		}
		 if(fileData != null){ 
		        File savefile = new File(new File(filePath),fileName); 
		        if(!savefile.getParentFile().exists()) 
		            savefile.getParentFile().mkdirs(); 
		        try { 
		            FileUtils.copyFile(fileData , savefile); 
		        } catch (IOException e) { 
		            e.printStackTrace(); 
		        } 
		 }
		return true;
	}
}

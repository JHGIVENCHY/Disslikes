package com.controller.my;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;


public class UploadUtil {

	private String uploadPath;
	private ServletContext app;
	
	/* ���� �޼��� */
	public static UploadUtil create(ServletContext app) {
		
		UploadUtil uploadUtil = new UploadUtil();
		uploadUtil.setApp(app);
		uploadUtil.setUploadPath(app.getRealPath("/upload"));
		
		return uploadUtil;
	}
	
	private void setApp(ServletContext app) {
		this.app = app;
	}
	private void setUploadPath(String realPath) {
		this.uploadPath = realPath;
	}
	
		
	/* ���� ���� */
	public String saveFiles(Part filePart, String string, String folderPath) {
	
	    
		String realPath = this.uploadPath + File.separator + folderPath;
		String filePath = realPath + filePart.getSubmittedFileName();
		String a = "C:" + "\\" + "Study" + "\\" + "JAVA" + "\\" + "Work" + "\\" + "Java20-12" + "\\" + "A_dislikes" + "\\" + "WebContent" + "\\" + "Img_Data" + "\\";
		String fileName = filePart.getSubmittedFileName(); //�����̸�
		int fileName2 = fileName.indexOf("."); // ���� ���° ��ġ��..
		String fileName3 = fileName.substring(fileName2);//Ȯ���ڸ�
		//file�ߺ�üũ
		for(int i = 1; i < 100; i++) {
			fileName = i + fileName3; // 1.jpg
			File target = new File(a, fileName);
			if (target.exists()){
		    	System.out.println("������ �ߺ���" + i);
		     }else {
		    	 break; //�ߺ��ƴҰ�� ���� Ż��.
		     }
		}
		String filePath2 = a + fileName;
		System.out.println("�����̸� : " +fileName);
		System.out.println("������� : " +filePath2);
		try(
			InputStream fis = filePart.getInputStream();
			OutputStream fos = new FileOutputStream(filePath2);)
		{
			byte[] buf = new byte[1024];
			int len = 0;
			
			while((len = fis.read(buf, 0, 1024)) != -1)
				fos.write(buf, 0, len);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	private void printList(File file) {
		// TODO Auto-generated method stub
		
	}

	/*/upload ���� ���� ��� ���� */
	public String createFilePath() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String[] paths = formatter.format(date).split("/");
		
		String result = paths[0] + File.separator + paths[1] + File.separator + paths[2];
		
		createFolders(result);
		
		return result; 
	}
	
	private void createFolders(String paths) {
		
		File folders = new File(uploadPath, paths);
		
		if(!folders.exists())
			folders.mkdirs();
	}
}
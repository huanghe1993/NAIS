/**
 * 
 */
package com.anyikang.controller.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @author wangwei
 * @date 2017年6月2日
 */
@RestController
@RequestMapping(value = "/web/file")
public class WebFileController {

	@Value("${spring.files.images-path}")
	private String imagePath;

	/**
	 * 单文件上传
	 * 
	 * @param req
	 * @param multiReq
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public void uploadFile(HttpServletRequest req,MultipartHttpServletRequest multiReq) {
		File folder = new File(imagePath);
        if (!folder.exists()) {
        	folder.mkdirs();
        }
		// 获取上传文件的路径
		String uploadFilePath = multiReq.getFile("file1").getOriginalFilename();
		// 截取上传文件的文件名
		String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,uploadFilePath.indexOf('.'));
		// 截取上传文件的后缀
		String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1, uploadFilePath.length());
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fis = (FileInputStream) multiReq.getFile("file1").getInputStream();
			fos = new FileOutputStream(new File(imagePath + uploadFileName+ ".")+ uploadFileSuffix);
			byte[] temp = new byte[1024];
			int i = fis.read(temp);
			while (i != -1) {
				fos.write(temp, 0, temp.length);
				fos.flush();
				i = fis.read(temp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 多文件上传
	 * 
	 * @param request
	 */
	@RequestMapping(value = "uploadFiles", method = RequestMethod.POST)
	public void uploadFiles(HttpServletRequest request) {
		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
		File folder = new File(imagePath);
        if (!folder.exists()) {
        	folder.mkdirs();
        }
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		for (int i = 0; i < files.size(); ++i) {
			file = files.get(i);
			if (!file.isEmpty()) {
				try {
					String uploadFilePath = file.getOriginalFilename();
					// 截取上传文件的文件名
					String uploadFileName = uploadFilePath.substring(uploadFilePath.lastIndexOf('\\') + 1,uploadFilePath.indexOf('.'));
					// 截取上传文件的后缀
					String uploadFileSuffix = uploadFilePath.substring(uploadFilePath.indexOf('.') + 1,uploadFilePath.length());
					stream = new BufferedOutputStream(new FileOutputStream(new File(imagePath + uploadFileName + "."+ uploadFileSuffix)));
					byte[] bytes = file.getBytes();
					stream.write(bytes, 0, bytes.length);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if (stream != null) {
							stream.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} else {
				System.out.println("上传文件为空");
			}
		}
		System.out.println("文件接受成功了");
	}

	/**
	 * 下载
	 * 
	 * @param res
	 */
	@RequestMapping(value = "/downloadFile/{fileName}", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse res,HttpServletRequest req) {
		String [] fileNames =req.getRequestURI().split("/");
		String fileName=fileNames[fileNames.length-1];
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		
		
		File folder = new File(imagePath);
        if (!folder.exists()) {
        	folder.mkdirs();
        }
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File(imagePath + fileName)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}

}

package com.gzepro.internal.query.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lw
 * @version 1.0 Created on: 2012-7-1
 */
public class UploadUtil {

	private static final Logger log = LoggerFactory.getLogger(UploadUtil.class);

	/**
	 * 路径分隔符
	 */
	public static final char SPT = '/';

	public static void saveFile(String fileName, File attachFile) {
		try {
			fileName = getFileRootPath() + SPT + fileName;
			File toSave = new File(fileName);
			FileUtils.copyFile(attachFile, toSave);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void saveFile(String path, String fileName, File attachFile) {
		try {
			fileName = path + SPT + fileName;
			File toSave = new File(fileName);
			FileUtils.copyFile(attachFile, toSave);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 获文件的全路径名
	 * 
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static String getFullFilePath(String fileName) {
		return getFileRootPath() + SPT + fileName;
	}

	public static void removeFile(String fileName) {
		File file = new File(fileName);
		if (file.delete()) {
			log.debug("删除未被使用的文件：{}", file.getName());
		} else {
			log.warn("删除文件失败：{}", file.getName());
		}
	}

	/**
	 * 获文件名
	 * 
	 * @param fileName
	 *            文件名
	 * @param isGenName
	 *            是否产生文件名
	 * @param module
	 *            文件类型
	 * @param suffix
	 *            后缀
	 * @return
	 */
	public static String getFileName(String fileName, boolean isGenName,
			String module) {
		String uploadPath = module;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		uploadPath += "/" + year + (month > 9 ? month : "0" + month);
		String suffix = fileName.substring(fileName.indexOf(".") + 1);
		String targetFileName = UUID.randomUUID().toString() + "." + suffix;
		uploadPath += "/" + targetFileName;
		return uploadPath;
	}

	/**
	 * 获文件名
	 * 
	 * @param fileName
	 *            文件名
	 * @param isGenName
	 *            是否产生文件名
	 * @param module
	 *            文件类型
	 * @param suffix
	 *            后缀
	 * @return
	 */
	public static String getBigFileName(String module) {
		String uploadPath = "telewiki/" + module;
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		uploadPath += "/" + year + (month > 9 ? month : "0" + month);
		return uploadPath;
	}

	/**
	 * 获得文件名 4位随机数加上当前时间
	 */
	public static String genFileName() {
		String name = StrUtils.longToN36(System.currentTimeMillis());
		return RandomStringUtils.random(4, StrUtils.N36_CHARS) + name;
	}

	/**
	 * 获得文件路径
	 * 
	 * @return
	 */
	public static String genFilePath() {
		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		sb.append(SPT).append(cal.get(Calendar.YEAR)).append('_').append(
				cal.get((Calendar.MONTH)) / 3 + 1).append(SPT).append(
				cal.get(Calendar.MONTH) + 1).append('_').append(
				cal.get(Calendar.DAY_OF_MONTH)).append(SPT);
		return sb.toString();
	}

	/**
	 * 读取配置文件
	 * 
	 * @param filePath
	 * @param proName
	 * @return
	 */
	public static String getFileRootPath() {
		PropertyUtil propertyUtil = new PropertyUtil();
		return propertyUtil.getPropertieValue("config/webservice.properties",
				"FileRootPath");
	}

}

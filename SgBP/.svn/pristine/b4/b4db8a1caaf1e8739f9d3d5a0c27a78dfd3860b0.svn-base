package com.gzepro.internal.query.common.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;
import javax.imageio.ImageIO;

/**
 * 对人才信息截图保存
 * @author lw
 * @version 1.0
 * Created on: 2012-7-27
 */
public class ScreenShots {

	/**
	 * 路径分隔符
	 */
	public static final char SPT = '/';
	/**
	 * 路径分隔符
	 */
	public static final char DOT = '.';
	/**
	 * 文件类型
	 */
	public static final String FileType = "jpg";
	
	/**
	 * 获文件的全路径名
	 * @param fileName 文件名
	 * @return
	 */
	public static String  saveInfoToJPG(String fileName){
		//String fileName = "";
		String filePath = "";
		try {
			String _path = getFileRootPath();
			fileName +=  DOT + FileType;
			filePath = _path + SPT + fileName;
			File f = new File(filePath);
			if(!f.exists()){
				f.mkdirs();
			}
			
			//获取屏幕大小
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			//截图
			BufferedImage bim = new Robot().createScreenCapture(new Rectangle(0, 0, dim.width, dim.height));
			ImageIO.write(bim, FileType, new File(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	/**
     * 读取配置文件
     * 
     * @return 获得图片保存路径
     */
	public static String getFileRootPath() {
		PropertyUtil propertyUtil = new PropertyUtil();
		return propertyUtil.getPropertieValue("config/webservice.properties", "ScreenShotsPath");
	}
	/**
	 * 产生文件名
	 * @param fileName 文件名
	 * @param suffix 后缀
	 * @return 产生的文件名
	 */
	public static String getFileName(String suffix) {
		return UUID.randomUUID().toString() +"."+ suffix;
	}
}

package com.gzepro.internal.query.common.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class DeleteTemporaryFile {

	private Logger logger = LoggerFactory.getLogger(DeleteTemporaryFile.class);
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public void wcmFnAddTest() {
		try {
			System.out.println("1213123131231");
			String folder = DateUtil.dateToDateString(new Date(), "yyyyMMdd");
			String folder4=folder.substring(0,3);
			String path = "D://file";
			if (path != null && path.trim().length() > 0) {
				File[] tmp = new File(path).listFiles();
				for (File file2 : tmp) {
					if (file2.isDirectory()) {
						if (!folder.equals(file2.getName())&&file2.getName().substring(0, 3).equals(folder4)) {
							try {
								del(file2);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void del(File file) throws IOException {
		if (file.exists() && file.isDirectory()) {// 判断是文件还是目录
			if (file.listFiles().length == 0) {// 若目录下没有文件则直接删除
				file.delete();
			} else {// 若有则把文件放进数组，并判断是否有下级目录
				File delFile[] = file.listFiles();
				int i = file.listFiles().length;
				for (int j = 0; j < i; j++) {
					if (delFile[j].isDirectory()) {
						del(delFile[j]);// 递归调用del方法并取得子目录路径
					} else {
						delFile[j].delete();// 删除文件
					}
				}
				file.delete();
			}
		}

	}
	
}

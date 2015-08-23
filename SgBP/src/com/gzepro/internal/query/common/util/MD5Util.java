package com.gzepro.internal.query.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class MD5Util {
	/**
	 * 默认的密码字符串组合，用来将字节转换成 16 进制表示的字符,apache校验下载的文件的正确性用的就是默认的这个组合
	 */
	protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6','7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	protected static MessageDigest messagedigest = null;
	
	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsaex) {
			System.err.println(MD5Util.class.getName() + "初始化失败，MessageDigest不支持MD5Util。");
			nsaex.printStackTrace();
		}
	}

	/**
	 * 生成字符串的md5校验值
	 * @param s
	 * @return
	 */
	public static String getMD5String(String s) {
		try {
			return getMD5String(s.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 判断字符串的md5校验码是否与一个已知的md5码相匹配
	 * @param password  要校验的字符串
	 * @param md5PwdStr 已知的md5校验码
	 * @return
	 */
	public static boolean checkPassword(String password, String md5PwdStr) {
		String s = getMD5String(password);
		return s.equals(md5PwdStr);
	}

	/**
	 * 生成文件的md5校验值
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String getFileMD5String(File file) throws IOException {
		InputStream fis;
		fis = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			messagedigest.update(buffer, 0, numRead);
		}
		fis.close();
		return bufferToHex(messagedigest.digest());
	}

	public static String getMD5String(byte[] bytes) {
		messagedigest.update(bytes);
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];// 取字节中高 4 位的数字转换,为逻辑右移，将符号位一起右移,此处未发现两种符号有何不同
		char c1 = hexDigits[bt & 0xf];// 取字节中低 4 位的数字转换
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}
	
	/**
	 * 方法说明： 该函数获得随机数字符串
	 * 
	 * @param iLen int :需要获得随机数的长度
	 * @param iType int:随机数的类型： '0 ':表示仅获得数字随机数； '1 '：表示仅获得字符随机数； '2'：表示获得数字字符混合随机数
	 * @since 1.0.0
	 */
	public static final String createRadom(int iLen, int iType) {
		String strRandom = "";// 随机字符串
		Random rnd = new Random();
		if (iLen < 0) {
			iLen = 5;
		}
		if ((iType > 2) || (iType < 0)) {
			iType = 2;
		}
		switch (iType) {
		case 0:
			for (int iLoop = 0; iLoop < iLen; iLoop++) {
				strRandom += Integer.toString(rnd.nextInt(10));
			}
			break;
		case 1:
			for (int iLoop = 0; iLoop < iLen; iLoop++) {
				strRandom += Integer.toString((35 - rnd.nextInt(10)), 36);
			}
			break;
		case 2:
			for (int iLoop = 0; iLoop < iLen; iLoop++) {
				strRandom += Integer.toString(rnd.nextInt(36), 36);
			}
			break;
		}
		return strRandom;
	}

	public static void main(String[] args) throws IOException {
		long begin = System.currentTimeMillis();
		String md5 = getMD5String("123");
		System.out.println(md5);
	}
}

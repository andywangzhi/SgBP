
package com.gzepro.internal.query.common.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.UUID;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicEditorPaneUI;

import org.apache.commons.io.FileUtils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * @author lw
 * @version 1.0 Created on: 2012-8-17
 */
public class HtmlToJpgUtil {

	public static int DEFAULT_IMAGE_WIDTH = 1124;

	// 默认值最好设置大点，因为我们再导之前，不知道这个流有多大，如果过小，则生成的图片后面的为黑色，因为流没有读取完整
	public static int DEFAULT_IMAGE_HEIGHT = 10000;
	
	public static String setHtml(String html){
		StringBuffer sb = new StringBuffer();
		
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd \">\n");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml \">     \n");
		sb.append("<head>     \n");
		
		sb.append("<style type=\"text/css\">\n");
		//sb.append(".inp { border:none; border-bottom:1px #CCC solid}\n");
    	//sb.append(".inp2 { border:none; border-bottom:1px #CCC solid}\n");
	
		/*sb.append("html,body,div,p {margin:0;padding:0;border:0}\n");
		sb.append("dl,dt,dd,ol,ul,li {margin:0;padding:0;border:0;list-style: none;}\n");
		sb.append("table,caption,tbody,tfoot,thead,tr,th,td {margin:0;padding:0}\n");
		sb.append("h1,h2,h3,h4,h5,h6,a,span,small {margin:0;padding:0}\n");
		sb.append("input, textarea, select,button { margin:0;padding:0;}\n");
		sb.append("img {border:0px;}\n");
		sb.append("body {font: 12px SimSun,'Microsoft YaHei',SimHei,Verdana,sans-serif; color:#000; }\n");*/
		sb.append(".table_yl { width:840px; margin:0px auto 0px auto; text-align:center}\n");
		sb.append(".table_yl table { width:100%; border-collapse:collapse; font-size:12px}\n");

		sb.append(".table_yl th,.table_yl td {border:1px solid #000000; padding-left:6px; padding-right:10px;height:28px; line-height:20px;overflow:hidden}\n");

		sb.append(".table_yl caption {padding:2px 6px 10px 6px; color:#15689c;font-size:20px;font-weight:bold; letter-spacing:6px}\n");
		sb.append(".table_yl thead th,table_yl thead td {background-color:#dddddd;color:#033f69; font-size:12px; text-align:left}\n");
		sb.append(".table_yl tbody th {color:#333;text-align:right; font-weight:lighter;background-color:#fff}\n");
		sb.append(".table_yl tbody td {color:#333;vertical-align:middle; background-color:#fff}\n");
		sb.append(".table_yl tfoot th,.table_yl tfoot td  {font-size:12px;color:#777;background-color:#f5f9f9;text-align:center}\n");
		sb.append(".table_yl .input { vertical-align:middle}\n");
		sb.append(".table_yl .inp {color:#666; width:100%}\n");
		sb.append(".table_yl textarea { width:100%; margin-top:6px; margin-bottom:6px;padding-left:6px;}\n");
		sb.append(".table_yl .table_info { margin-top:15px;line-height:36px; overflow:hidden; clear:both}\n");
		sb.append(".table_yl .table_info_b { color:#999; line-height:30px; text-indent:24px;}\n");
		sb.append(".table_yl .tbody_t { background:#dddddd !important;}\n");
		sb.append(".table_yl .table_t h2 { margin-top:20px;font-size:28px; text-align:center; font-weight:bold; line-height:28px; overflow:hidden; clear:both}\n");
		sb.append(".table_yl .tbody_t h3 { float:left; display:inline; overflow:hidde;font-size:14px; text-align:left; font-weight:bold}\n");
		sb.append(".table_yl .tbody_t h4 { float:left; display:inline; overflow:hidde; color:#666;sfont-size:12px; text-align:left; font-weight:normal}\n");
		/**/
		sb.append("</style>\n</head>\n<body>\n");
		
		sb.append(html.toLowerCase());
		
		sb.append("</body>\n");
		sb.append("</html>\n");
		
		//System.out.println(sb.toString());
		
		return sb.toString();
	}

	public static byte[] toJpg(String html) {
		byte[] buff = null;
		try {
			int width = DEFAULT_IMAGE_WIDTH;
			int height = DEFAULT_IMAGE_HEIGHT;
			EmptyBorder eb = new EmptyBorder(0, 0, 0, 0);
			Color bgColor = null;
			JTextPane tp = new JTextPane();
			tp.setSize(width, height);
			
			if (bgColor != null) {
				tp.setBackground(bgColor);
			}
			
			tp.setBorder(eb);
			tp.setContentType("text/html");
			tp.setText(setHtml(html));
			Dimension d = ((BasicEditorPaneUI) tp.getUI()).getPreferredSize(tp);
			// 此处是将一个页面生成一张图片，如果要人为控制图片大小进行分页生成，则再自行进行高度设置，但是分页之后可能出现的情况就是分页的时候字体被截断的可能，因为在截断的之后，他不知道流是否刚好将一行字显示完成
			if (d.height > DEFAULT_IMAGE_HEIGHT) {
				height = d.height + 100;
			}
			height = d.height + 150;
			GraphImg gimg = new GraphImg(tp);
			int pageIndex = 1;
			boolean bcontinue = true;
			while (bcontinue) {
				BufferedImage image = new java.awt.image.BufferedImage(width,
						height, java.awt.image.BufferedImage.TYPE_INT_RGB);
				Graphics g = image.getGraphics();
				g.setClip(0, 0, width, height);
				bcontinue = gimg.paintPage(g, height, pageIndex);

				g.dispose();// 释放此图形的上下文并释放它所使用的所有系统资源
				// 111
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
				JPEGEncodeParam param = encoder
						.getDefaultJPEGEncodeParam(image);
				// param.setQuality(1.0f, false);
				param.setQuality(1f, false); // 1f是提高生成的图片质量
				encoder.setJPEGEncodeParam(param);
				encoder.encode(image);
				buff = baos.toByteArray();
				baos.close();
				
				
				//1111111111111111
				// 将字节流写入文件保存为图片
				/*String imageName = "E:\\"
						+ UUID.randomUUID().toString().replaceAll("-", "")
						+ ".jpg";
				System.out.println(imageName);
				FileUtils.writeByteArrayToFile(new File(imageName), buff);

				System.out.println("保存成功!....");
				 */
				/*
				 //222 
				 String path = "d:\\hehe.jpg"; File outFile = new
				 File("d:\\hehe.jpg"); ImageIO.write(image, "jpg", outFile);//写图片 
				 ret.add(path);
				 */

				pageIndex++;
			}
		} catch (Exception ex) {

		}
		return buff;
	}

	static class GraphImg {

		public JTextPane panel = null;

		public GraphImg(JTextPane panel) {
			this.panel = panel;
		}

		/**
		 * 绘制图片的方法
		 * 
		 * @param g
		 * @param hPage
		 * @param pageIndex
		 * @return
		 */
		public boolean paintPage(Graphics g, int hPage, int pageIndex) {
			Graphics2D g2 = (Graphics2D) g;
			Dimension d = ((BasicEditorPaneUI) panel.getUI()).getPreferredSize(panel);
			double panelHeight = d.height;
			double pageHeight = hPage;
			int totalNumPages = (int) Math.ceil(panelHeight / pageHeight);
			g2.translate(0f, -(pageIndex - 1) * pageHeight);

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);// 以达到边缘平滑的效果

			panel.paint(g2);
			boolean ret = true;
			if (pageIndex >= totalNumPages) {
				ret = false;
				return ret;
			}
			g2.dispose();// 释放此图形的上下文并释放它所使用的所有系统资源
			return ret;
		}
	}
}

package com.gzepro.internal.query.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gzepro.internal.query.system.action.BatchUploadExeclAction;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class ReadWord {
	public static void main(String[] args)  {
//		int[] columnsArray = new int[50];
//		columnsArray[0] = 0;// 不起作用，按1开始，且下面的数组需要按word的行数进行补充列树，如第1行有1列，2行有7列。3行身份证有19列
//		columnsArray[1] = 1;// 个人基本信息
//		columnsArray[2] = 8;// 姓名
//		columnsArray[3] = 19;// 公民身份号码
//		columnsArray[4] = 4;// 毕业院校
//		columnsArray[5] = 4;// 最高学历
//		columnsArray[6] = 4;// 通讯地址
//		columnsArray[7] = 6;// 联系电话
//
//		columnsArray[8] = 1;// 职业现状
//		columnsArray[9] = 4;// 现所在行业
//		columnsArray[10] = 4;// 单位性质
//		columnsArray[11] = 4;// 现就业单位名称
//		columnsArray[12] = 2;// 人才类型
//
//		columnsArray[13] = 1;// 职称技能信息
//		columnsArray[14] = 3;// 职称技能级别
//		columnsArray[15] = 3;// 第一行
//		columnsArray[16] = 3;// 第二行
//		columnsArray[17] = 3;// 第三行
//		columnsArray[18] = 3;// 第四行
//
//		columnsArray[19] = 1;// 教育简历
//		columnsArray[20] = 4;// 从何年何月
//		columnsArray[21] = 4;// 第一行
//		columnsArray[22] = 4;// 第二行
//		columnsArray[23] = 4;// 第三行
//		columnsArray[24] = 4;// 第四行
//
//		columnsArray[25] = 1;// 工作简历
//		columnsArray[26] = 4;// 从何年何月
//		columnsArray[27] = 4;// 第一行
//		columnsArray[28] = 4;// 第二行
//		columnsArray[29] = 4;// 第三行
//		columnsArray[30] = 4;// 第四行
//		columnsArray[31] = 4;// 第五行
//
//		columnsArray[32] = 1;// 科技成果
//		columnsArray[33] = 5;// 获取日期
//		columnsArray[34] = 5;// 第一行
//		columnsArray[35] = 5;// 第二行
//		columnsArray[36] = 5;// 第三行
//		columnsArray[37] = 5;// 第四行
//		columnsArray[38] = 5;// 第五行
//
//		columnsArray[39] = 1;// 项目经验
//		columnsArray[40] = 6;// 从何年从月
//		columnsArray[41] = 6;// 第一行
//		columnsArray[42] = 6;// 第二行
//		columnsArray[43] = 6;// 第三行
//		columnsArray[44] = 6;// 第四行
//		columnsArray[45] = 6;// 第五行
//
//		columnsArray[46] = 1;// 其他专长
//		columnsArray[47] = 1;// 第一行
//
//		columnsArray[48] = 1;// 个人申明
//		columnsArray[49] = 1;// 第一行
//
//		Dispatch wordDoc = null;
//		ActiveXComponent word = null;
//		 
//		try {
//			word = new ActiveXComponent("Word.Application");
//			word.setProperty("Visible", new Variant(true));
//			Dispatch documents = word.getProperty("Documents").toDispatch();
//			wordDoc = Dispatch.call(documents, "Open", "c:\\02.doc")
//					.toDispatch();

			// Dispatch selection = word.getProperty("Selection").toDispatch();
			// Dispatch.call(selection,"HomeKey",new Variant(6));

//			Dispatch paragraph_range;
//			String paragraph_data = "";
//			Dispatch paragraphs = Dispatch.get(wordDoc, "Paragraphs")
//					.toDispatch(); // 所有段落
//			int paragraphCount = Dispatch.get(paragraphs, "Count").toInt(); // 一共的段落数
//
//		
//			
//			
//			 for (int i = 1; i <= paragraphCount; i++) {
//			if(i==3){//只取前2个段落和最后一个段落 
//				Dispatch paragraph = Dispatch.call(paragraphs, "Item", new Variant(i)).toDispatch();
//			 paragraph_range = Dispatch.get(paragraph, "Range").toDispatch();
//			 paragraph_data = Dispatch.get(paragraph_range,
//			 "Text").getString(); System.out.println("段落数："+paragraph_data); }
//			 }
//			 paragraph_data=paragraph_data.substring(paragraph_data.lastIndexOf
//			 ("填表日期")+5); paragraph_data=paragraph_data.replace(" ", "");
//			 System.out.println(paragraph_data);
//			 
//			 paragraph_data=paragraph_data.replace("年", "-");
//				paragraph_data=paragraph_data.replace("月", "-");
//				paragraph_data=paragraph_data.substring(0,paragraph_data.indexOf("日"));
//				paragraph_data=BatchUploadExeclAction.parseDate(paragraph_data);
//			Date	operationalDate = BatchUploadExeclAction.sdfs.parse(paragraph_data);
//			 System.out.println( BatchUploadExeclAction.sdfs.format(operationalDate));
			 
//			Dispatch tables = Dispatch.get(wordDoc, "Tables").toDispatch();
//			Dispatch table = Dispatch.call(tables, "Item", new Variant(1))
//					.toDispatch();
//			Dispatch rows = Dispatch.get(table, "Rows").toDispatch();
//			Dispatch cell;
//			Dispatch range;
//			String data;
//			for (int i = 1; i <= Dispatch.get(rows, "Count").getInt(); i++) {
//				for (int j = 1; j <= columnsArray[i]; j++) {
//					cell = Dispatch.call(table, "Cell", i, j).toDispatch();
//					range = Dispatch.get(cell, "Range").toDispatch();
//					data = Dispatch.get(range, "Text").getString();
//					System.out.print(data.trim() + "  " + i + "#" + j + "|");
//				}
//				System.out.println();
//			}
//			Dispatch cell = Dispatch.call(table, "Cell", 2, 8).toDispatch();
//			Dispatch range = Dispatch.get(cell, "Fill").toDispatch();
			
			
//			Dispatch shapes = Dispatch.get(wordDoc, "InLineShapes").toDispatch();  
//			Dispatch shape =  Dispatch.call(shapes, "Item", new Variant(1)).toDispatch();;
//			List<Byte> shape1 =  (List<Byte>) Dispatch.call(shapes, "Item", new Variant(1)).toByteArray();
			
  System.out.println("1111");
			
  String one="440202196501010032";
  
  String[] birthDayAndSex = ValidateUtil.getBirthDayAndSex(one);// 获取人员的出生上期和性别
  for (String string : birthDayAndSex) {
	System.out.println(string);
}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			Dispatch.call(wordDoc, "Close", new Variant(true));
//			word.invoke("Quit", new Variant[0]);
//		}
//		
		

	}
	
	public static void change(String docfile, String htmlfile) {

		Dispatch wordDoc = null;
		ActiveXComponent word = null;
		try {
			word = new ActiveXComponent("Word.Application");
			word.setProperty("Visible", new Variant(false));
			Dispatch documents = word.getProperty("Documents").toDispatch();
			wordDoc = Dispatch.call(documents, "Open", "c:/ccc.doc")
					.toDispatch();
			Dispatch.invoke(wordDoc, "SaveAs", Dispatch.Method, new Object[]{"c:/test.html",new Variant(8)}, new int[1]);
			 Dispatch selection = word.getProperty("Selection").toDispatch();
			 Dispatch.call(selection,"HomeKey",new Variant(6));
			 Dispatch.call(wordDoc, "Close", new Variant(true));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			word.invoke("Quit", new Variant[0]);
		}
	}

	public static String getTextValue(Dispatch table, int i, int j) {
		try {
			Dispatch cell = Dispatch.call(table, "Cell", i, j).toDispatch();
			Dispatch range = Dispatch.get(cell, "Range").toDispatch();
			String data = Dispatch.get(range, "Text").getString();
			return data.trim();
		} catch (Exception e) {
			return null;
		}
	}
}
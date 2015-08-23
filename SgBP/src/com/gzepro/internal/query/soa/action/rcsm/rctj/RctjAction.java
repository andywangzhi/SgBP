package com.gzepro.internal.query.soa.action.rcsm.rctj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;

@SuppressWarnings("serial")
@Scope("prototype")
@Component("soa.Rctj")
public class RctjAction extends SoaBaseJsonAction{

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	
	public String rctj() {
		try {
			String url= getRealPath("file/123.xls");
			String fname= new Date().getTime() +".xls";
			File file=new File(fname);
			FileInputStream in = new FileInputStream(url);
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int c;
			while ((c = in.read(buf)) != -1) {
			  fos.write(buf, 0, c);
			}
			in.close();
			fos.close();
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet= workbook.getSheetAt(0);
			for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum() ; rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex);
				if(row!=null){
					for (int i = 0; i < row.getRowNum(); i++) {
						System.out.println(getCellString(row.getCell(i)));
					}
				}
			}
			HttpServletResponse response=getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流   
			response.reset();// 清空输出流   
			String n="321.xls";   
			String name=new String(n.getBytes("GB2312"), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment; filename=\""+name+"\"");// 设定输出文件头   
			response.setContentType("application/msexcel");// 定义输出类型 
			workbook.write(os); // 写入文件   
			os.close(); // 关闭流
			if(file.exists()){
				file.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.NONE;
		
	}
	
	
	
	private static String getCellString(HSSFCell cell) {
		String strRe = "";
		try {
			int iCellType = cell.getCellType();
			switch (iCellType) {
			case HSSFCell.CELL_TYPE_NUMERIC: {
				boolean b = HSSFDateUtil.isCellDateFormatted(cell);
				if (b) {
					cell.getDateCellValue();
					String strDate = sdf.format(cell.getDateCellValue());
					return strDate.trim();
				}
				double db = cell.getNumericCellValue();
				if (db == 0) {
					strRe = "0";
				}

				// 此处就是采用DecimalFormat 格式化的方式来解决的。
				java.text.DecimalFormat formatter = new java.text.DecimalFormat(
						"###########");
				strRe = formatter.format(cell.getNumericCellValue());
				break;
			}
			case HSSFCell.CELL_TYPE_STRING:
				strRe = cell.getRichStringCellValue().getString();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
			default:
				break;
			}
			return strRe.trim();
		} catch (Exception e) {
			return "";
		}
	}
}

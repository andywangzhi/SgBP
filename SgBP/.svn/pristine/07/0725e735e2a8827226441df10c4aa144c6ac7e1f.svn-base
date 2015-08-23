package com.gzepro.internal.query.soa.action.rcsm.base;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gzepro.internal.query.common.util.DateUtil;
import com.gzepro.internal.query.model.RsSocialworker;
import com.gzepro.internal.query.model.RsTalantteam;
import com.gzepro.internal.query.soa.base.SoaBaseJsonAction;
import com.gzepro.internal.query.soa.service.user.impl.RsTalantTeamService;

@SuppressWarnings("serial")
@Scope("prototype")
@Component("rsTalantTeam")
public class RsTalantTeamAction   extends SoaBaseJsonAction{

	public static DecimalFormat df = new DecimalFormat("0.00");//格式化小数，不足的补0
	public static SimpleDateFormat sdfDay=new SimpleDateFormat("yyyyMMdd");
	public static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
	public static String FNAME="人才工作考核及人才队伍建设情况.xls";
	@Resource
	private RsTalantTeamService rsTalantTeamService;
	
	private List<RsSocialworker> socialworkerList=new ArrayList<RsSocialworker>();
	
	private String queryYear;//查询条件年份，默认为当前年
	
	private Map<String, String> resultMap=new HashMap<String, String>();//统计的结果返回到页面
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 获取数据
	 * @return
	 */
	public float[] getDataMap(String pcounty,String year){
		float[] arr_pcountu = new float[4];
		queryYear = year;
		try {
			this.view();
			//每万人口中人才资源量比例增长率	
			float _max = Float.parseFloat(resultMap.get("2-0").substring(0, resultMap.get("2-0").indexOf("%")));
			for(int i = 1;i<10;i++){
				float _mid = Float.parseFloat(resultMap.get("2-"+i).substring(0, resultMap.get("2-"+i).indexOf("%")));			
				if(_mid > _max){
					_max = _mid;
				}
			}
			int _temp = Integer.parseInt(pcounty)-1;
			float _pcounty = Float.parseFloat(resultMap.get("2-"+_temp).substring(0, resultMap.get("2-"+_temp).indexOf("%")));
			arr_pcountu[0] = _pcounty/_max;
			//企业经营管理人才占从业人员的比例
			_max = Float.parseFloat(resultMap.get("4-0").substring(0, resultMap.get("4-0").indexOf("%")));
			for(int i = 1;i<10;i++){
				float _mid = Float.parseFloat(resultMap.get("4-"+i).substring(0, resultMap.get("4-"+i).indexOf("%")));			
				if(_mid > _max){
					_max = _mid;
				}
			}
			_temp = Integer.parseInt(pcounty)-1;
			_pcounty = Float.parseFloat(resultMap.get("4-"+_temp).substring(0, resultMap.get("4-"+_temp).indexOf("%")));
			arr_pcountu[1] = _pcounty/_max;
			//专业技术人才占从业人员的比例		
			_max = Float.parseFloat(resultMap.get("6-0").substring(0, resultMap.get("6-0").indexOf("%")));
			for(int i = 1;i<10;i++){
				float _mid = Float.parseFloat(resultMap.get("6-"+i).substring(0, resultMap.get("6-"+i).indexOf("%")));			
				if(_mid > _max){
					_max = _mid;
				}
			}
			_temp = Integer.parseInt(pcounty)-1;
			_pcounty = Float.parseFloat(resultMap.get("6-"+_temp).substring(0, resultMap.get("6-"+_temp).indexOf("%")));
			arr_pcountu[2] = _pcounty/_max;
			//农村实用人才占农村农运力的比例	
			_max = Float.parseFloat(resultMap.get("10-0").substring(0, resultMap.get("10-0").indexOf("%")));
			for(int i = 1;i<10;i++){
				float _mid = Float.parseFloat(resultMap.get("10-"+i).substring(0, resultMap.get("10-"+i).indexOf("%")));			
				if(_mid > _max){
					_max = _mid;
				}
			}
			_temp = Integer.parseInt(pcounty)-1;
			_pcounty = Float.parseFloat(resultMap.get("10-"+_temp).substring(0, resultMap.get("10-"+_temp).indexOf("%")));
			arr_pcountu[3] = _pcounty/_max;
		} catch (Exception e) {
		}
		return arr_pcountu;
	}
	
	//进入配置页面
	public String toConfig()throws Exception{
		try{
			if(queryYear==null||"".equals(queryYear)){
				queryYear=String.valueOf(DateUtil.getYear(new Date()));//当前的年份
			}
			if(queryYear!=null){
				int temp = Integer.parseInt(queryYear);
				if(temp > DateUtil.getYear(new Date())){
					queryYear = String.valueOf(DateUtil.getYear(new Date()));
				}
			}
			List<RsSocialworker> list=rsTalantTeamService.queryCurrentYearConf(queryYear);
			if(list!=null&&list.size()>0){
				socialworkerList=list;
			}else{
				socialworkerList=new ArrayList<RsSocialworker>();
				for(int i=1;i<11;i++){
					RsSocialworker rs=new RsSocialworker();
					rs.setSwdate(queryYear);
					rs.setQx(new Long(i));
					socialworkerList.add(rs);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "conf";
	}

	public String view()throws Exception{
		try{
			if(queryYear==null||"".equals(queryYear)){
				queryYear=String.valueOf(DateUtil.getYear(new Date()));//当前的年份
			}
			//首先查询当前年和上一年的配置信息
			List<RsSocialworker> curYearConfData=rsTalantTeamService.queryCurYearAndLastYearConf(queryYear);
			resultMap=new HashMap<String, String>();
			List<Long> rkzl=new ArrayList<Long>();//查询当前年各区县人口总量
			List<Long> cyry=new ArrayList<Long>();//查询当前年各区县从业人员总量
			List<Long> ncldl=new ArrayList<Long>();//查询当前年各区县农村农运力总量
			List<Long> czsg=new ArrayList<Long>();//查询当前年持证社工人数
			
			List<Long> rkzlLast=new ArrayList<Long>();//查询当前年上年各区县人口总量
			List<Long> cyryLast=new ArrayList<Long>();//查询当前年上年各区县从业人员总量
			List<Long> ncldlLast=new ArrayList<Long>();//查询当前年上年各区县农村农运力总量
			List<Long> czsgLast=new ArrayList<Long>();//查询当前年上年持证社工人数
			
			if(curYearConfData!=null&&curYearConfData.size()>0){
				for (int i=0;i<curYearConfData.size();i++) {
					if(curYearConfData.get(i).getSwdate().equals(queryYear)){
						rkzl.add(curYearConfData.get(i).getT1());
						cyry.add(curYearConfData.get(i).getT2());
						ncldl.add(curYearConfData.get(i).getT3());
						czsg.add(curYearConfData.get(i).getT4());
						if(curYearConfData.size()>10){
							resultMap.put(18+"-"+(i-10), curYearConfData.get(i).getT4().toString());//今年持证社工人数
						}
						resultMap.put(18+"-"+i, curYearConfData.get(i).getT4().toString());//今年持证社工人数
					}else{
						rkzlLast.add(curYearConfData.get(i).getT1());
						cyryLast.add(curYearConfData.get(i).getT2());
						ncldlLast.add(curYearConfData.get(i).getT3());
						czsgLast.add(curYearConfData.get(i).getT4());
						resultMap.put(17+"-"+i, curYearConfData.get(i).getT4().toString());//上年持证社工人数
					}
				}
			}
			
			List<RsTalantteam> AllData=rsTalantTeamService.queryCurYearAndLastYearDataByYear(queryYear);//查询当前年和上一年的统计数据
			List<RsTalantteam> curData=new ArrayList<RsTalantteam>();//当前年的所有数据
			List<RsTalantteam> lastData=new ArrayList<RsTalantteam>();//上一年的所有数据
			if(AllData!=null&&AllData.size()>0){
				for (RsTalantteam rs : AllData) {
					if(rs.getTd().equals(queryYear)){
						curData.add(rs);
					}else{
						lastData.add(rs);
					}
				}
			}
			//解析数据
			if(curData!=null&&curData.size()>0){
				for (int i = 0; i < curData.size(); i++) {
					RsTalantteam curT =curData.get(i);
					RsTalantteam lastT = (lastData==null||lastData.size()<=0?null:lastData.get(i));
					int part=curT.getTp().intValue();
					Long[] curDataArray=new Long[]{curT.getT1(),curT.getT2(),curT.getT3(),curT.getT4(),curT.getT5(),curT.getT6(),curT.getT7(),curT.getT8(),curT.getT9(),curT.getT10()};
					Long[] lastDataArray=null;
					if(lastT!=null){
						lastDataArray=new Long[]{lastT.getT1(),lastT.getT2(),lastT.getT3(),lastT.getT4(),lastT.getT5(),lastT.getT6(),lastT.getT7(),lastT.getT8(),lastT.getT9(),lastT.getT10()};
					}
					switch (part) {
					case 1:
						//统计第一部分每万人口中人才资源量
						this.calPct(1, curDataArray, rkzl,lastDataArray,rkzlLast,resultMap);
						break;
					case 2:
						//统计第二部分企业经营管理人才占从业人员的比例
						this.calPct(2, curDataArray, cyry,lastDataArray,cyryLast,resultMap);
						break;
					case 3:
						//统计第三部分专业技术人才占从业人员的比例
						this.calPct(3, curDataArray, cyry,lastDataArray,cyryLast,resultMap);
						break;
					case 4:
						//统计第四部分高技能人才占从业人员的比例
						this.calPct(4, curDataArray, cyry,lastDataArray,cyryLast,resultMap);
						break;
					case 5:
						//统计第五部分农村实用人才占农村农运力的比例
						this.calPct(5, curDataArray, ncldl,lastDataArray,ncldlLast,resultMap);
						break;				
					default:
						//统计第六部分持证社工
						this.calPct(6, curDataArray, czsg,lastDataArray,czsgLast,resultMap);
						break;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "view";
	}
	
	public String ExportExecl(){
		try {
			HttpServletResponse response=getResponse();
			OutputStream os = response.getOutputStream();// 取得输出流   
			response.reset();// 清空输出流   
			String name = new String(FNAME.getBytes("GB2312"), "ISO8859-1");
			response.setHeader("Content-disposition", "attachment; filename=\""+ name + "\"");// 设定输出文件头
			response.setContentType("application/msexcel");// 定义输出类型
			int index = this.getClass().getClassLoader().getResource("/").getPath().indexOf("/WEB-INF");
			String path = this.getClass().getClassLoader().getResource("/").getPath().substring(0,index) +"\\file";
			String folder= "K"+sdfDay.format(new Date(System.currentTimeMillis()));
			String dir= path+"\\"+folder+"\\";
		    File file=new File(dir);
		    if (file.exists()) { 
				//删除目录中的所有文件或者文件夹
				for(File f:file.listFiles()){
					f.delete();
				}
			}
		    dir+=sdf.format(new Date(System.currentTimeMillis()));
		    file=new File(dir);
		    file.mkdirs();//创建当天统计目录
		    
		    //拷贝一份模板文件
		    InputStream in=new  FileInputStream(path+"\\"+FNAME);
	        BufferedInputStream is=new BufferedInputStream(in);
	        file=new File(dir+"\\"+FNAME);
			OutputStream out=new FileOutputStream(file);
            int readLen=0;  
            byte[] buf=new byte[1024];  
            while ((readLen=is.read(buf, 0, 1024))!=-1) {  
            	out.write(buf, 0, readLen);  
            }
            is.close();
            in.close();
            out.close();

            //导入数据
            FileInputStream input= new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(input);
            out= new FileOutputStream(file);
            HSSFSheet sheet = workbook.getSheetAt(0);//第一页
            this.view();//查询当前数据
            if(resultMap!=null&&resultMap.size()>0){
            	HSSFRow row =sheet.getRow(0);
            	row.getCell(0).setCellValue(this.queryYear+"年韶关市县（市、区）人才工作考核人才队伍建设情况表");
            	for(int i=3;i<23;i++){
            		row = sheet.getRow(i);
            		writeValue(row,i-2+"-",resultMap);
            	}           
            }
            workbook.write(out);
            out.flush();
            workbook.write(os);  
            out.close();
            os.close();
            return this.NONE;
		} catch (Exception ex) {
			ex.printStackTrace();
			return this.NONE;
		}
	}
	/*
	 * param: part 统计的哪一部分
	 * param: curDataArray　当前年的数据
	 * param: lastDataArray　上一年的数据
	 * param: curYearConf　当年的配置信息
	 * param: resultMap　保存统计结果
	 * desc:统计各部分的百分比信息
	 */
	public void calPct(int part,Long[] curDataArray,List<Long> curTotalArray,Long[] lastDataArray,List<Long> lastTotalArray,Map<String, String> resultMap){
		if(part==6){
			//统计社工增长率
			Long curTotal=new Long(0);
			Long lastTotal=new Long(0);

			/**根据20130425新需求变更（第5项的社工比例增长率改为：增长率，即持证人数（（今年-去年） *100/ 去年） %），这部分取掉
			if(curTotalArray!=null&&curTotalArray.size()>0){
				for (Long ct : curTotalArray) {
					curTotal+=ct;
				}
			}
			if(lastTotalArray!=null&&lastTotalArray.size()>0){
				for (Long lt : lastTotalArray) {
					lastTotal+=lt;
				}
			}
			**/
			for(int i=0;i<10;i++){
				Long curD=(curTotalArray==null||curTotalArray.size()<=0)?0:(curTotalArray.get(i)==null?0:curTotalArray.get(i));
				Long lstD=(lastTotalArray==null||lastTotalArray.size()<=0)?0:(lastTotalArray.get(i)==null?0:lastTotalArray.get(i));
				
				//每万人口中持证社工人数
				this.ca1(part,i,curDataArray[i],curTotalArray.get(i),resultMap);
				this.ca2(part, i, curD, curTotal,lstD, lastTotal, resultMap);
			}
		}else{
			for (int i = 0; i < curDataArray.length; i++) {
				//先计算所占比例(持证社会除外)
				this.ca1(part,i,curDataArray[i],curTotalArray.get(i),resultMap);
				//再计算比例增长率
				this.ca2(part, i, (curDataArray[i]==null?0:curDataArray[i]), ((curTotalArray==null||curTotalArray.size()<=0)?0:curTotalArray.get(i)),(lastDataArray==null?0:(lastDataArray[i]==null?0:lastDataArray[i])), ((lastTotalArray==null||lastTotalArray.size()<=0)?0:(lastTotalArray.get(i)==null?0:lastTotalArray.get(i))), resultMap);
			}
		}
		//最后计算增长率排名，三个区内排，七个县内排
		this.ca3(part,resultMap);
	}
	
	//先计算所占比例
	public void ca1(int part,int i,Long curdata,Long curTotal,Map<String,String> resultMap){
		curdata=(curdata==null?0:curdata);
		double size = (double)curdata/curTotal;
		String str ="";
		if(part==1||part==6){
			df = new DecimalFormat("0");
			str=df.format(size*10000);//每万人口中人才资源量，每万人口中持证社工人数
		}else{
			str = df.format(size*100)+"%";//所占比例
		}
		resultMap.put((1+(part-1)*3)+"-"+i, str);
	}
	
	//新的计算比例增长率
	public void ca2(int part,int i,Long curdata,Long curTotal,Long lastData,Long lastTotal,Map<String,String> resultMap){
		curdata=(curdata==null?new Long(0):curdata);
		lastTotal=(lastTotal==null?new Long(0):lastTotal);
		if(part==6){
			//社工计算增长率
			if(lastData==0){
				resultMap.put(19+"-"+i, "");
			}else{
				Long a = curdata-lastData;
				double size=(double)a/lastData;
				String str = df.format(size*100)+"%";//增长率
				resultMap.put(19+"-"+i, str);
			}
		}else{
			//其他部分计算比例增长率
			if(curTotal==0||lastData==0){
				resultMap.put((part*3-1)+"-"+i, "");
			}else{
				Long a = curdata*lastTotal;
				Long b=curTotal*lastData;
				double size=(double)a/b-1;
				String str = df.format(size*100)+"%";//比例增长率
				resultMap.put((part*3-1)+"-"+i, str);
			}
		}
	}
	
	//增长率排名，三个区内排，七个县内排
	public void ca3(int part,Map<String,String> resultMap){
		Integer[] dbArray=new Integer[10];//保存每部分需求用来排名的比例数据，先进行了int类型值的转换
		String key="";
		if(part==6){
			key=String.valueOf(19+"-");
		}else{
			key=String.valueOf(part*3-1)+"-";
		}
		//持证社工排名
		for (int i = 0; i < 10; i++) {
			String tmpVal=resultMap.get(key+i);
			if(tmpVal==null||"".equals(tmpVal)){
				tmpVal="0";
			}else{
				tmpVal=tmpVal.substring(0,tmpVal.length()-1);
			}
			dbArray[i]=Integer.valueOf(tmpVal);
		}
		
		//构建一个三区七县的二维数组
		Integer[][] dbArraysWithoutDuplicateData=new Integer[][]{{dbArray[0],dbArray[1],dbArray[2]},{dbArray[3],dbArray[4],dbArray[5],dbArray[6],dbArray[7],dbArray[8],dbArray[9]}};
		
		//去重复数据
		dbArraysWithoutDuplicateData=this.getIntArrayWithoutDuplicateData(dbArraysWithoutDuplicateData);
		
		//比例对应的排名情况
		Map<Integer,Integer> sqSortMap=this.getSortResult(dbArraysWithoutDuplicateData[0]);//三区比例对应的排名情况
		Map<Integer,Integer> qxSortMap=this.getSortResult(dbArraysWithoutDuplicateData[1]);//七县比例对应的排名情况
		
		//页面显示排名情况
		if(part==6){
			for (int j = 0; j < 10; j++) {
				if(j<3){
					resultMap.put(20+"-"+j, sqSortMap.get(Integer.valueOf(dbArray[j])).toString());
				}else{
					resultMap.put(20+"-"+j, qxSortMap.get(Integer.valueOf(dbArray[j])).toString());
				}
			}
		}else{
			for (int j = 0; j < 10; j++) {
				if(j<3){
					resultMap.put(part*3+"-"+j, sqSortMap.get(Integer.valueOf(dbArray[j])).toString());
				}else{
					resultMap.put(part*3+"-"+j, qxSortMap.get(Integer.valueOf(dbArray[j])).toString());
				}
			}
		}
	}
	
	 /**
     * 给定一个数组，调用冒泡算法进行排序,计算排名情况
     * @param acceptArray 给定的一个没有重复数据的数组
     * @return 报名情况Map,比如:(50:1),(40:2)，表示比例为50%排第一，40%排第二
     */
	public Map<Integer,Integer> getSortResult(Integer[] acceptArray) {
		Map<Integer,Integer> sortMap=new HashMap<Integer, Integer>();
		if(acceptArray!=null&&acceptArray.length>0){
			acceptArray=sortByDesc(acceptArray);//降序
		}
		//组合比例对应的排名情况
		for (int i = 0; i < acceptArray.length; i++) {
			sortMap.put(acceptArray[i], i+1);
		}
        return sortMap;
    }
	
	/**
     * 给定一个数组，用set集合去重复数据
     * @param acceptArrays 给定的一个二维数组
     * @return 没有重复数据的二维数组
     */
	public Integer[][] getIntArrayWithoutDuplicateData(Integer[]... acceptArrays) {
		Set<Integer> dataSet=null;
		Integer[][] arrayWithoutDuplicateData=new Integer[2][];
		int i=0;
		for (Integer[] item : acceptArrays) {
			dataSet=new HashSet<Integer>();
			for (Integer is : item) {
				dataSet.add(is);
			}
			arrayWithoutDuplicateData[i]=dataSet.toArray(new Integer[]{});
			i++;
		}
		return arrayWithoutDuplicateData;
	}
	
	//由大到小排序
	public  Integer[] sortByDesc(Integer[] acceptArray){
      for(int i=0;i<acceptArray.length;i++){
          for(int j=i+1;j<acceptArray.length;j++){
              if(acceptArray[i] < acceptArray[j]){
                 int tem = acceptArray[i];
                 acceptArray[i] = acceptArray[j];
                 acceptArray[j] = tem;
              }
          }
      }
      return acceptArray;
	}
	
	//由小到大排序
	public  Integer[] sortByAsc(Integer[] acceptArray) {
	   for(int i = 0 ; i < acceptArray.length-1 ; i ++) {
		    if(acceptArray[i] > acceptArray[i+1]) {
		     int temp = acceptArray[i];
		     acceptArray[i] = acceptArray[i+1];
		     acceptArray[i+1] = temp;
		   }
	   }
	   return acceptArray;
	}
	/*
	 * param: row 当前行
	 * param: key 结果集的key
	 * desc:更改统计单元格的值
	 */
	public void writeValue( HSSFRow row,String key,Map<String, String> resultMap){
		for(int j=0;j<10;j++){
			row.getCell(j+3).setCellValue(resultMap.get(key+j)==null?null:new HSSFRichTextString(resultMap.get(key+j)));
		}
	}
	public String saveOrUpdate()throws Exception{
		JSONObject json=new	JSONObject();
		try{
			if(socialworkerList!=null&&socialworkerList.size()>0){
				for (RsSocialworker socialworker : socialworkerList) {
					rsTalantTeamService.saveOrUpdate(socialworker);
				}
			}
			json.put("flag", 1);
		}catch (Exception ex) {
			ex.printStackTrace();
			json.put("flag", 2);
			return "error";
		}
		outputJson(json);
		return this.NONE;
	}


	public List<RsSocialworker> getSocialworkerList() {
		return socialworkerList;
	}
	public void setSocialworkerList(List<RsSocialworker> socialworkerList) {
		this.socialworkerList = socialworkerList;
	}
	public String getQueryYear() {
		return queryYear;
	}

	public void setQueryYear(String queryYear) {
		this.queryYear = queryYear;
	}

	public Map<String, String> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, String> resultMap) {
		this.resultMap = resultMap;
	}
	
	
}

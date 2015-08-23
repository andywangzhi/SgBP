package com.gzepro.internal.query.common.util.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.gzepro.internal.query.system.model.SysLog;

/**
 * JSON工具类
 * 
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class JSONUtils {
	private static JsonConfig config = new JsonConfig();
	
	/**
	 * 初始化json配置
	 */
	public static void init() {
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));  
	}
	
	/**
	 * 将List对象序列化为JSON文本
	 */
	public static <T> String toJSONString(List<T> list) {
		init();
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		return jsonArray.toString();
	}

	/**
	 * 将对象序列化为JSON文本
	 * @param object
	 * @return
	 */
	public static String toJSONString(Object object) {
		init();
		JSONArray jsonArray = JSONArray.fromObject(object,config);
		return jsonArray.toString();
	}
	/**
	 * 将JSON对象数组序列化为JSON文本
	 * @param jsonArray
	 * @return
	 */
	public static String toJSONString(JSONArray jsonArray) {
		return jsonArray.toString();
	}

	/**
	 * 将JSON对象序列化为JSON文本
	 * @param jsonObject
	 * @return
	 */
	public static String toJSONString(JSONObject jsonObject) {
		return jsonObject.toString();
	}

	
	
	
	/**
	 * 将对象转换为List对象
	 * @param object
	 * @return
	 */
	public static List toArrayList(Object object) {
		init();
		List arrayList = new ArrayList();
		JSONArray jsonArray = JSONArray.fromObject(object,config);
		Iterator it = jsonArray.iterator();
		while (it.hasNext()) {
			JSONObject jsonObject = (JSONObject) it.next();
			Iterator keys = jsonObject.keys();
			while (keys.hasNext()) {
				Object key = keys.next();
				Object value = jsonObject.get(key);
				arrayList.add(value);
			}
		}
		return arrayList;
	}

	/**
	 * 将对象转换为Collection对象
	 * @param object
	 * @return
	 */
	public static Collection toCollection(Object object) {
		init();
		JSONArray jsonArray = JSONArray.fromObject(object,config);
		return JSONArray.toCollection(jsonArray);
	}
	

	/**
	 * 将对象转换为JSON对象数组
	 * @param object
	 * @return
	 */
	public static JSONArray toJSONArray(Object object) {
		init();
		return JSONArray.fromObject(object,config);
	}

	/**
	 * 将对象转换为JSON对象
	 * @param object
	 * @return
	 */
	public static JSONObject toJSONObject(Object object) {
		init();
		return JSONObject.fromObject(object,config);
	}

	/**
	 * 将对象转换为HashMap
	 * @param object
	 * @return
	 */
	public static HashMap toHashMap(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		JSONObject jsonObject = JSONUtils.toJSONObject(object);
		Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}

	/**
	 * 将对象转换为List<Map<String,Object>>
	 * @param object
	 * @return 返回非实体类型(Map<String,Object>)的List
	 */
	public static List<Map<String, Object>> toList(Object object) {
		init();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONArray jsonArray = JSONArray.fromObject(object,config);
		for (Object obj : jsonArray) {
			JSONObject jsonObject = (JSONObject) obj;
			Map<String, Object> map = new HashMap<String, Object>();
			Iterator it = jsonObject.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				Object value = jsonObject.get(key);
				map.put((String) key, value);
			}
			list.add(map);
		}
		return list;
	}

	/**
	 * 将JSON对象数组转换为传入类型的List
	 * @param <T>
	 * @param jsonArray
	 * @param objectClass
	 * @return
	 */
	public static <T> List<T> toList(JSONArray jsonArray, Class<T> objectClass) {
		init();
		return JSONArray.toList(jsonArray, objectClass);
	}

	/**
	 * 将对象转换为传入类型的List
	 * @param <T>
	 * @param jsonArray
	 * @param objectClass
	 * @return
	 */
	public static <T> List<T> toList(Object object, Class<T> objectClass) {
		init();
		JSONArray jsonArray = JSONArray.fromObject(object);
		return JSONArray.toList(jsonArray, objectClass,config);
	}

	/**
	 * 将JSON对象转换为传入类型的对象
	 * @param <T>
	 * @param jsonObject
	 * @param beanClass
	 * @return
	 */
	public static <T> T toBean(JSONObject jsonObject, Class<T> beanClass) {
		init();
		return (T) JSONObject.toBean(jsonObject, beanClass,config);
	}

	/**
	 * 将将对象转换为传入类型的对象
	 * @param <T>
	 * @param object
	 * @param beanClass
	 * @return
	 */
	public static <T> T toBean(Object object, Class<T> beanClass) {
		init();
		JSONObject jsonObject = JSONObject.fromObject(object,config);
		return (T) JSONObject.toBean(jsonObject, beanClass);
	}

	/**
	 * 将JSON文本反序列化为主从关系的实体
	 * @param <T> 泛型T 代表主实体类型
	 * @param <D> 泛型D 代表从实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailName 从实体类在主实体类中的属性名称
	 * @param detailClass 从实体类型
	 * @return
	 */
/*	public static <T, D> T toBean(String jsonString, Class<T> mainClass,
			String detailName, Class<D> detailClass) {
		init();
		JSONObject jsonObject = JSONObject.fromObject(jsonString,config);
		JSONArray jsonArray = (JSONArray) jsonObject.get(detailName);
		T mainEntity = JSONUtils.toBean(jsonObject, mainClass);
		List<D> detailList = JSONUtils.toList(jsonArray, detailClass);
		try {
			BeanUtils.setProperty(mainEntity, detailName, detailList);
		} catch (Exception ex) {
			throw new RuntimeException("主从关系JSON反序列化实体失败！");
		}
		return mainEntity;
	}
*/
	/**
	 * 将JSON文本反序列化为主从关系的实体
	 * @param <T>泛型T  代表主实体类型
	 * @param <D1>泛型D1 代表从实体类型
	 * @param <D2>泛型D2 代表从实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailName1 从实体类在主实体类中的属性
	 * @param detailClass1 从实体类型
	 * @param detailName2  从实体类在主实体类中的属性
	 * @param detailClass2 从实体类型
	 * @return
	 */
/*	public static <T, D1, D2> T toBean(String jsonString, Class<T> mainClass,
			String detailName1, Class<D1> detailClass1, String detailName2,
			Class<D2> detailClass2) {
		init();
		JSONObject jsonObject = JSONObject.fromObject(jsonString,config);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
		T mainEntity = JSONUtils.toBean(jsonObject, mainClass);
		List<D1> detailList1 = JSONUtils.toList(jsonArray1, detailClass1);
		List<D2> detailList2 = JSONUtils.toList(jsonArray2, detailClass2);
		try {
			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
		} catch (Exception ex) {
			throw new RuntimeException("主从关系JSON反序列化实体失败！");
		}
		return mainEntity;
	}*/

	/**
	 * 将JSON文本反序列化为主从关系的实体
	 * @param <T>泛型T  代表主实体类型
	 * @param <D1>泛型D1  代表从实体类型
	 * @param <D2>泛型D2  代表从实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailName1 从实体类在主实体类中的属性
	 * @param detailClass1 从实体类型
	 * @param detailName2 从实体类在主实体类中的属性
	 * @param detailClass2 从实体类型
	 * @param detailName3 从实体类在主实体类中的属性
	 * @param detailClass3 从实体类型
	 * @return
	 */
/*	public static <T, D1, D2, D3> T toBean(String jsonString,
			Class<T> mainClass, String detailName1, Class<D1> detailClass1,
			String detailName2, Class<D2> detailClass2, String detailName3,
			Class<D3> detailClass3) {
		init();
		JSONObject jsonObject = JSONObject.fromObject(jsonString,config);
		JSONArray jsonArray1 = (JSONArray) jsonObject.get(detailName1);
		JSONArray jsonArray2 = (JSONArray) jsonObject.get(detailName2);
		JSONArray jsonArray3 = (JSONArray) jsonObject.get(detailName3);
		T mainEntity = JSONUtils.toBean(jsonObject, mainClass);
		List<D1> detailList1 = JSONUtils.toList(jsonArray1, detailClass1);
		List<D2> detailList2 = JSONUtils.toList(jsonArray2, detailClass2);
		List<D3> detailList3 = JSONUtils.toList(jsonArray3, detailClass3);
		try {
			BeanUtils.setProperty(mainEntity, detailName1, detailList1);
			BeanUtils.setProperty(mainEntity, detailName2, detailList2);
			BeanUtils.setProperty(mainEntity, detailName3, detailList3);
		} catch (Exception ex) {
			throw new RuntimeException("主从关系JSON反序列化实体失败！");
		}
		return mainEntity;
	}*/

	/**
	 * 将JSON文本反序列化为主从关系的实体
	 * @param <T>  主实体类型
	 * @param jsonString JSON文本
	 * @param mainClass 主实体类型
	 * @param detailClass 存放了多个从实体在主实体中属性名称和类型
	 * @return
	 */
/*	public static <T> T toBean(String jsonString, Class<T> mainClass,
			HashMap<String, Class> detailClass) {
		init();
		JSONObject jsonObject = JSONObject.fromObject(jsonString,config);
		T mainEntity = JSONUtils.toBean(jsonObject, mainClass);
		for (Object key : detailClass.keySet()) {
			try {
				Class value = (Class) detailClass.get(key);
				BeanUtils.setProperty(mainEntity, key.toString(), value);
			} catch (Exception ex) {
				throw new RuntimeException("主从关系JSON反序列化实体失败！");
			}
		}
		return mainEntity;
	}*/
	

    public static void main(String args[]){
    	SysLog sysLog1 = new SysLog();
    	sysLog1.setId(1l);
    	sysLog1.setLoginId("1");
    	sysLog1.setAccountName("测试1");
    	sysLog1.setCreateDate(new Date());
    	sysLog1.setLogType("分类1");
    	sysLog1.setOperIp("127.0.0.1");
    	sysLog1.setRemark("测试测试1");
    	
    	SysLog sysLog2 = new SysLog();
    	sysLog2.setId(2l);
    	sysLog1.setLoginId("2");
    	sysLog2.setAccountName("测试2");
    	sysLog2.setCreateDate(new Date());
    	sysLog2.setLogType("分类2");
    	sysLog2.setOperIp("127.0.0.1");
    	sysLog2.setRemark("测试测试2");
    	
    	List<SysLog> list1 = new ArrayList<SysLog>();
    	System.out.println("0000---"+JSONUtils.toJSONString(list1));
    	list1.add(sysLog1);
    	list1.add(sysLog2);
    	System.out.println("11111---"+JSONUtils.toJSONString(list1));
    	
    	//
    	List list = new ArrayList();
    	list.add( "first" );
    	list.add( "second" );
    	System.out.println("----"+JSONUtils.toJSONString(list));
    	
    	//
    	Map map = new HashMap();
    	map.put("name", "json");
    	map.put("bool", Boolean.TRUE);
    	map.put("int", new Integer(1));
    	map.put("arr", new String[] { "a", "b" });
    	map.put("func", "function(i){ return this.arr; }");
    	JSONObject json = JSONObject.fromObject(map);
    	System.out.println("----"+JSONUtils.toJSONString(json));
    	
    	
    }
	
}

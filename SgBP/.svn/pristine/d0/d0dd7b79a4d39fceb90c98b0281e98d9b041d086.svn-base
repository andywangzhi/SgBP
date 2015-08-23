package com.gzepro.internal.query.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 * 类属性值Clone工具。Clone类并通过匹配getter和setter方法设置属性值
 * @author lw
 * @version 1.0
 * Created on: 2012-7-1
 */
public class CloneUtil {

	private CloneUtil() {
	}


    /**
     * 通过Clone o1创建一个o2Class的实例，并通过匹配getter和setter方法复制属性值
     * @param o1 待Clone对象
     * @param o2Class Clone出的对象类
     * @return Clone出的o2Class的实例
     * @throws Exception
     */
	public static Object cloneObject(Object o1, Class o2Class) throws Exception {
		Object o2 = null;
		if (o1 != null) {
			o2 = o2Class.newInstance();
		}
		return cloneObject(o1, o2);
	}

    /**
     * 通过匹配getter和setter方法从o1复制属性值o2
     * @param o1
     * @param o2
     * @return
     * @throws Exception
     */
	public static Object cloneObject(Object o1, Object o2) throws Exception {
		if (o1 == null)
			return null;

		Method[] methods = o2.getClass().getDeclaredMethods();
		for (Method setter : methods) {
			//只处理setter方法
			if (setter.getName().startsWith("set")) {
				String getterName = setter.getName().replaceFirst("set", "get");
				try {
					 //获取相应的getter方法
					Method getter = o1.getClass().getDeclaredMethod(getterName,null);
					Type[] setterParamTypes = setter.getGenericParameterTypes();
					//setter参数不止1个的，不进行赋值
					if (setterParamTypes.length != 1) {
						continue;
					}

					Object value = cloneValue(getter.invoke(o1, null),setterParamTypes[0]);

					//null值不赋值
					if (value == null) {
						continue;
					}

					//从entity取值赋予vo
					setter.invoke(o2, new Object[] { value });
				} catch (NoSuchMethodException e) {
					//                    log.warn("NoSuchMethod found:" + e.getMessage());
				} catch (Exception e) {
					//                    log.error("Exception occurs for " + setter.getName() + 
					//                              " occurs:" + e.getMessage());
					e.printStackTrace();
					throw e;
				}
			}
		}

		return o2;
	}

	 /**
     * Clone值，如果类型不一样，则做基本类型的转换
     * @param v1 待Clone的值
     * @param toType Clone后的类型
     * @return
     */
	public static Object cloneValue(Object v1, Type toType) {
		String class2 = toType.toString();

		if (v1 == null) {
			//处理基本类型
			if (class2.equals("long")) {
				return 0;
			} else if (class2.equals("int")) {
				return 0;
			} else if (class2.equals("double")) {
				return 0.0;
			} else if (class2.equals("float")) {
				return 0;
			} else {
				return null;
			}
		}

		String class1 = v1.getClass().toString();

		//如果相同类型，则直接返回原值   
		if (class1.equals(class2)) {
			return v1;
		}
		
		//返回String类型
		else if ( class2.indexOf("java.lang.String") != -1  ||  class2.equals("String") ) {
			if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).toString();
			} else if (class1.indexOf("java.lang.Double") != -1) {
				return NumberUtils.format((Double) v1,",###.###");
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return ((Float) v1).toString();
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).toString();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).toString();
			}

			return v1.toString();
		}

		//返回Integer/int类型
		else if ( class2.indexOf("java.lang.Integer") != -1  ||  class2.equals("int") ) {
			if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).intValue();
			} else if (class1.indexOf("java.lang.Double") != -1) {
				return ((Double) v1).intValue();
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return ((Float) v1).intValue();
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).intValue();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).intValue();
			}

			return Integer.parseInt(v1.toString());
		}
		
		//返回Long类型
		else if (class2.indexOf("java.lang.Long") != -1
				|| class2.equals("long")) {
			if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).longValue();
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).longValue();
			} else if (class1.indexOf("java.lang.Double") != -1) {
				return ((Double) v1).longValue();
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return ((Float) v1).longValue();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).longValue();
			}
			return Long.parseLong(v1.toString());
		}
		
		 //返回Double类型
		else if (class2.indexOf("java.lang.Double") != -1
				|| class2.equals("double")) {
			if (class1.indexOf("java.lang.Double") != -1) {
				return ((Double) v1).longValue();
			} else if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).longValue();
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return ((Float) v1).longValue();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).longValue();
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).longValue();
			}
			return Double.parseDouble(v1.toString());
		}
		//Float
		else if (class2.indexOf("java.lang.Float") != -1
				|| class2.equals("float")) {
			if (class1.indexOf("java.lang.Double") != -1) {
				return ((Double) v1).floatValue();
			} else if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).floatValue();
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return ((Float) v1).floatValue();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).floatValue();
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).floatValue();
			}
			return Float.parseFloat(v1.toString());
		}

		//返回Timestamp
		else if (class2.indexOf("java.sql.Timestamp") != -1) {
			if (class1.indexOf("java.util.Calendar") != -1) {
				return new Timestamp(((Calendar) v1).getTimeInMillis());
			} else if (class1.indexOf("java.util.Date") != -1) {
				return new Timestamp(((Date) v1).getTime());
			} else if (class1.indexOf("java.util.GregorianCalendar") != -1) {
				return new Timestamp(((GregorianCalendar) v1).getTimeInMillis());
			}
		}
		
		//返回Calendar
		else if (class2.indexOf("java.util.Calendar") != -1) {
			Calendar c = Calendar.getInstance();
			if (class1.indexOf("java.sql.Timestamp") != -1) {
				c.setTimeInMillis(((Timestamp) v1).getTime());
			} else if (class1.indexOf("java.util.Date") != -1) {
				c.setTimeInMillis(((Date) v1).getTime());
			} else if (class1.indexOf("java.util.GregorianCalendar") != -1) {
				c.setTimeInMillis(((GregorianCalendar) v1).getTimeInMillis());
			}
			return c;
		}

		 //返回GregorianCalendar
		else if (class2.indexOf("java.util.GregorianCalendar") != -1) {
			GregorianCalendar c = new GregorianCalendar();
			if (class1.indexOf("java.util.Calendar") != -1) {
				c.setTimeInMillis(((Calendar) v1).getTimeInMillis());
			} else if (class1.indexOf("java.sql.Timestamp") != -1) {
				c.setTimeInMillis(((Timestamp) v1).getTime());
			} else if (class1.indexOf("java.util.Date") != -1) {
				c.setTimeInMillis(((Date) v1).getTime());
			}
			return c;
		}
		
		 //返回Date
		else if (class2.indexOf("java.util.Date") != -1) {
			if (class1.indexOf("java.util.Calendar") != -1) {
				return new Date(((Calendar) v1).getTimeInMillis());
			} else if (class1.indexOf("java.sql.Timestamp") != -1) {
				return new Date(((Timestamp) v1).getTime());
			} else if (class1.indexOf("java.util.GregorianCalendar") != -1) {
				return new Date(((GregorianCalendar) v1).getTimeInMillis());
			}
		}
		
		//返回List
		//        else if (class2.indexOf("java.util.List") != -1) {
		//            List list = new ArrayList();
		//         //原值是数组
		//            if (class1.startsWith("class [")) {
		//                Object[] array = (Object[])v1;
		//
		//                for (Object o: array) {
		//                    list.add(o);
		//                }
		//            }
		//            return list;
		//        }
		//       //返回数组
		//        else if (class2.indexOf("class [") != -1) {
		//            List list = new ArrayList();
        //      //原值是List
		//            if (class1.indexOf("java.util.List") != -1) {
		//                return ((List)v1).toArray(new Object[0]);
		//            }
		//        }

		return null;
	}

	
	/**
     * 从列表中Clone第一个对象
     * @param o1List
     * @param o2Class
     * @return
     * @throws Exception
     */
	public static Object cloneFirstObject(List o1List, Class o2Class)
			throws Exception {
		if (o1List == null || o1List.size() == 0)
			return null;
		else
			return cloneObject(o1List.get(0), o2Class);
	}

	 /**
     * 从列表中Clone第一个对象
     * @param o1List
     * @param o2
     * @return
     * @throws Exception
     */
	public static Object cloneFirstObject(List o1List, Object o2)
			throws Exception {
		if (o1List == null || o1List.size() == 0)
			return null;
		else
			return cloneObject(o1List.get(0), o2);
	}

	/**
     * Clone列表
     * @param o1List
     * @param o2Class
     * @return
     * @throws Exception
     */
	public static List cloneList(List o1List, Class o2Class) throws Exception {
		List o2List = new ArrayList();

		if (o1List != null && o1List.size() > 0) {
			for (Object o1 : o1List) {
				o2List.add(cloneObject(o1, o2Class));
			}
		}

		return o2List;
	}

	/**
     * Clone数组
     * @param array
     * @param o2Class
     * @return
     * @throws Exception
     */
	public static List cloneArray(Object[] array, Class o2Class)
			throws Exception {
		List o2List = new ArrayList();

		if (array != null && array.length > 0) {
			for (Object o1 : array) {
				o2List.add(cloneObject(o1, o2Class));
			}
		}

		return o2List;
	}

	/**
     * Clone列表
     * @param o1List
     * @param o2List
     * @return
     * @throws Exception
     */
	public static List cloneList(List o1List, List o2List) throws Exception {
		if (o1List != null && o1List.size() > 0) {
			for (int i = 0; i < o1List.size(); i++) {
				Object o1 = o1List.get(i);
				o2List.set(i, cloneObject(o1, o2List.get(i)));
			}
		}

		return o2List;
	}


    /**
     * Clone数组
     * @param array
     * @param list
     * @return
     * @throws Exception
     */
	public static List cloneArray(Object[] array, List list) throws Exception {
		if (array != null && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				Object o1 = array[i];
				list.set(i, cloneObject(o1, list.get(i)));
			}
		}
		return list;
	}

	public static Object[] list2array(List list, Class clazz) throws Exception {
		if (list == null)
			return null;

		Object[] array = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
	
	/**
     * Clone值，如果类型不一样，则做基本类型的转换
     * @param v1 待Clone的值
     * @param toType Clone后的dto类型
     * @return
     */
	public static Object changeToDto(Object v1, Type toType){
		
		String class2 = toType.toString();

		if (v1 == null) {
			//处理基本类型
			if (class2.equals("long")) {
				return 0;
			} else if (class2.equals("int")) {
				return 0;
			} else if (class2.equals("double")) {
				return 0.0;
			} else if (class2.equals("float")) {
				return 0;
			} else {
				return null;
			}
		}

		String class1 = v1.getClass().toString();

		//如果相同类型，则直接返回原值   
		if (class1.equals(class2)) {
			return v1;
		}
		
		//返回String类型
		else if ( class2.indexOf("java.lang.String") != -1  ||  class2.equals("String") ) {
			
			if (class1.indexOf("java.lang.Integer") != -1) {
				return ((Integer) v1).toString();
			} else if (class1.indexOf("java.lang.Double") != -1) {
				return NumberUtils.format((Double) v1,",##0.00");
			} else if (class1.indexOf("java.lang.Float") != -1) {
				return NumberUtils.format((Float) v1,",##0.00");
			} else if (class1.indexOf("java.lang.Long") != -1) {
				return ((Long) v1).toString();
			} else if (class1.indexOf("java.math.BigDecimal") != -1) {
				return ((BigDecimal) v1).toString();
			} else if (class1.indexOf("java.util.Calendar") != -1) {
				return DateUtil.calendarToString( (Calendar)v1, "yyyy-MM-dd");
			}else if (class1.indexOf("java.util.GregorianCalendar") != -1) {
				return DateUtil.calendarToString( (Calendar)v1, "yyyy-MM-dd");
			}
			
			return v1.toString();
		}else if(class1.indexOf("java.lang.Integer") != -1  &&  class2.equals("int") ){
			return v1;
		}else if(class1.indexOf("java.lang.Byte") != -1  &&  class2.equals("byte") ){
			return v1;
		}
		
		return null;
	}
	
	
	/**
	 * 转换dto对象
	 * @param o1  soa服务查询到的对象
	 * @param o2  转换后的dto对象
	 * @param map 敏感字段
	 * @return o2
	 * @throws Exception
	 */
	public static Object cloneObject(Object o1, Object o2, Map map) throws Exception {
		
		if (o1 == null){
			return null;
		}

		Method[] methods = o2.getClass().getDeclaredMethods();
		
		for (Method setter : methods) {
			// 只处理setter方法
			if ( setter.getName().startsWith("set") ) {
				String getterName = setter.getName().replaceFirst("set", "get");
				try {
					
					boolean isContain = false; 
					Method[] o1Method = o1.getClass().getDeclaredMethods();
					for( int i = 0 ; i < o1Method.length; i++ ){
						if( o1Method[i].toString().indexOf(getterName) != -1){
							isContain = true;                          //包含此方法
						}
					}
					
					if( isContain ){
						// 获取相应的getter方法
						Method getter = o1.getClass().getDeclaredMethod(getterName,null);
						Type[] setterParamTypes = setter.getGenericParameterTypes();

						for (int i = 0; i < setterParamTypes.length; i++) {

							Object value = null;
							String validName = getterName.toString().replace("get", "");
							char firstChar = validName.charAt(0); // 第一个大写字符转成小写
							String low = String.valueOf(firstChar).toLowerCase();
							validName = low + validName.substring(1, validName.length());

							if (map != null && map.containsKey(validName)) { //如果是敏感字段
								value = map.get(validName).toString();
							} else {
								value = changeToDto(getter.invoke(o1,null), setterParamTypes[i]);
							}
							
							if (value == null) { // null值不赋值
								continue;
							}
							
							setter.invoke(o2, new Object[] { value }); // 从entity取值赋予vo
						}
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		}

		return o2;
	}
	

}

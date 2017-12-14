package com.shanghai.changning.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class JsonUtil {
	
	/***
     * 获取 request 中 json 字符串的内容
     * 
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
        // POST
        } else {
            return getRequestPostStr(request);
        }
    }
    
    /**      
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
    
    /**      
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
    
    /**
     * 将json数组转换成java数组
     * @param jsonString
     * @return
     */
    public static String[] getStringArray4Json(String jsonString){
        
		 JSONArray jsonArray = JSONArray.fromObject(jsonString);
		 String[] stringArray = new String[jsonArray.size()];
		     for( int i = 0 ; i<stringArray.length;i++){
		            stringArray[i] = jsonArray.getString(i);
		}
		         return stringArray;
    }
    
    /**
     * 将json格式字符串转换成map对象
     * @param <T>
     * @param object
     * @return
     */
    public static <T> Map<String, T> toMap(String object) {
        Map<String, T> data = new HashMap<String, T>();
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(object);
        Iterator<?> ite = jsonObject.keys();
        // 遍历jsonObject数据,添加到Map对象
        while (ite.hasNext()) {
            String key = ite.next().toString();
            @SuppressWarnings("unchecked")
			T value = (T) jsonObject.get(key);
            data.put(key, value);
        }
        // 或者直接将 jsonObject赋值给Map
        // data = jsonObject;
        return data;
    }
    
    /** 
	 * 由字符串反序列化成实体类  针对的是一个实体，此实体中的属性不包括自定义的类型，如Teacher类型，或者List<Teacher>类型  
     * @param <T>
	 * @param source 传入json中的字符串 
	 * @param beanClass 实体类的类型 
	 * @return 实体类 
	 */  
	@SuppressWarnings("unchecked")
	public static <T> T getObjFromJsonArrStr(String source,Class<?> beanClass)  
	{  
	    JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(source);  
	    return  (T) JSONObject.toBean(jsonObject,beanClass);          
	}  
	
	/** 
	 * 由字符串反序列化成实体类  针对的是一个实体，此实体中的属性包括自定义的类型，如Teacher类型，或者List<Teacher>类型 
	 * @param <T>
	 * @param jsonArrStr 
	 * @param clazz 
	 * @param classMap 
	 * @return 
	 */  
	@SuppressWarnings("unchecked")
	public static <T> T getObjFromJsonArrStr(String jsonArrStr, Class<?> clazz, Map<?, ?> classMap)   
	{    
	    JSONObject jsonObj = JSONObject.fromObject(jsonArrStr);    
	               return (T) JSONObject.toBean(jsonObj, clazz, classMap);              
	}  
  
  
	/** 
	 * 将string转换成listBean 
	 * @param <T>
	 * @param jsonArrStr 需要反序列化的字符串 
	 * @param clazz 被反序列化之后的类 
	 * @return 实体list 
	 */  
	@SuppressWarnings("unchecked")
	public static <T> List<T> getListFromJsonArrStr(String jsonArrStr, Class<?> clazz) {    
	       JSONArray jsonArr = JSONArray.fromObject(jsonArrStr);    
	       List<T> list = (List<T>) new ArrayList<Object>();    
	       for (int i = 0; i < jsonArr.size(); i++)   
	       {    
	           list.add((T) JSONObject.toBean(jsonArr.getJSONObject(i), clazz));    
	       }    
	       return list;    
	   }   
  
	/** 
	 * 将string转换成listBean 属性中包含实体类等 如List<Student> 而Student中含有属性List<Teacher> 
	 * @param <T>
	 * @param jsonArrStr 需要反序列化的字符串 
	 * @param clazz 反序列化后的类 
	 * @param classMap 将属性中包含的如Teacher加入到一个Map中，格式如map.put("teacher",Teacher.class) 
	 * @return 反序列化后的字符串 
	 * 使用示例： 
	    Map classMap = new HashMap(); 
	    //必须要对Parent进行初始化 否则不识别 
	    Teacher p = new Teacher(); 
	    classMap.put("teacher", p.getClass()); 
	    List mlist = JSONTransfer.getListFromJsonArrStr(resultStr, Student.class, classMap); 
	 */  
	@SuppressWarnings("unchecked")
	public static <T> List<T> getListFromJsonArrStr(String jsonArrStr, Class<?> clazz, Map<?, ?> classMap)   
	{    
	      JSONArray jsonArr = JSONArray.fromObject(jsonArrStr);    
	      List<T> list = (List<T>) new ArrayList<Object>();    
	      for (int i = 0; i < jsonArr.size(); i++)   
	      {              
	          list.add((T) JSONObject.toBean(jsonArr.getJSONObject(i), clazz, classMap));    
	      }    
	      return list;    
	}  
      
	/** 
	 * 序列化操作，无论是单个的对象，还是list，抑或是list中的属性仍包含list，都可以直接序列化成String类型 
	 * @param obj 需要被序列化的对象 
	 * @return 序列化之后的字符串 
	 */  
	/*@SuppressWarnings("unchecked")  
	public static String getJsonArrStrFromList(Object obj)   
	{   
	    //返回結果  
	    String jsonStr = null;    
	    //判空  
	       if (obj == null) {    
	           return "{}";    
	       }    
	       //Json配置        
	       JsonConfig jsonCfg = new JsonConfig();    
	   
	       //注册日期处理器    
	       jsonCfg.registerJsonValueProcessor(java.util.Date.class,    
	               new JsonDateValueProcessor(SystemConstants.DateFormat));    
	         
	       //判断是否是list  
	       if (obj instanceof Collection || obj instanceof Object[]) {    
	           jsonStr = JSONArray.fromObject(obj, jsonCfg).toString();    
	       } else {    
	           jsonStr = JSONObject.fromObject(obj, jsonCfg).toString();    
	       }        
	       return jsonStr;   
	   }  */ 
    
}

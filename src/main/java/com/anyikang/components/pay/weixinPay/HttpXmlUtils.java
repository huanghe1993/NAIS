package com.anyikang.components.pay.weixinPay;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;


import com.anyikang.utils.StringUtil;




/**
 * 
 * @author tz
 *
 */
public class HttpXmlUtils {

	/**
	 * 解析返回的的数据
	 * 
	 * @param is
	 * @param charset
	 * @return
	 */
	public static String getContent(InputStream is, String charset) {
		String pageString = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			isr = new InputStreamReader(is, charset);
			br = new BufferedReader(isr);
			sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			pageString = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			sb = null;
		}
		return pageString;
	}

	/**
	 * 构造参数
	 * 
	 * @param xml
	 * @return
	 */
	public static String xmlInfo(Map map) {
		StringBuffer sb = new StringBuffer();
		Set es = map.entrySet();//�?有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        sb.append("<xml>");
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(StringUtil.isNotEmpty(v+"")) {
            	sb.append("<"+k+">");
            	sb.append(v);
            	sb.append("</"+k+">");
            }
        }
        sb.append("</xml>");
        System.out.println("Map参数准备二次xml拼接后的结果"+sb);

		return sb.toString();
	}

	

	/**
	 * post请求并得到返回结果
	 * 
	 * @param requestUrl  请求地址
	 * @param xmlParam    请求xml参数
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String xmlParam) {
		
		 try {  
             
             URL url = new URL(requestUrl);  
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
             
             conn.setDoOutput(true);  
             conn.setDoInput(true);  
             conn.setUseCaches(false);  
             // 设置请求方式（GET/POST）  
             conn.setRequestMethod("POST");  
             conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");  
             // 当outputStr不为null时向输出流写数据  
             if (null != xmlParam) {  
                 OutputStream outputStream = conn.getOutputStream();  
                 // 注意编码格式  
                 outputStream.write(xmlParam.getBytes("UTF-8"));  
                 outputStream.close();  
             }  
             // 从输入流读取返回内容  
             InputStream inputStream = conn.getInputStream();  
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
             String str = null;  
             StringBuffer buffer = new StringBuffer();  
             while ((str = bufferedReader.readLine()) != null) {  
                 buffer.append(str);  
             }  
             // 释放资源  
             bufferedReader.close();  
             inputStreamReader.close();  
             inputStream.close();  
             inputStream = null;  
             conn.disconnect();  
             return buffer.toString();  
         } catch (ConnectException ce) {  
             System.out.println("连接超时：{}"+ ce);  
         } catch (Exception e) {  
             System.out.println("https请求异常：{}"+ e);  
         }  
         return null;  
	}
	
	
	
	/** 
     * @author  tz
     * @date 2017-9-12 
     * @Description：将SortedMap转换成xml输出
     * @param parameters 
     *            请求参数 
     * @return 
     */  
    public static String getRequestXml(SortedMap<Object, Object> parameters) {  
        StringBuffer sb = new StringBuffer();  
        sb.append("<xml>");  
        Set es = parameters.entrySet();  
        Iterator it = es.iterator();  
        while (it.hasNext()) {  
            Map.Entry entry = (Map.Entry) it.next();  
            String k = (String) entry.getKey();  
            String v = (String) entry.getValue();  
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {  
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");  
            } else {  
                sb.append("<" + k + ">" + v + "</" + k + ">");  
            }  
        }  
        sb.append("</xml>");  
        return sb.toString();  
    }  
    
    
    /**
	 * 解析xml,返回第一级元素键值对。如果第�?级元素有子节点，则此节点的�?�是子节点的xml数据�?
	 * 将xml转换成Map
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map doXMLParse(String strxml) throws Exception {
		if(null == strxml || "".equals(strxml)) {
			return null;
		}
		
		Map m = new HashMap();
		InputStream in = String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Element e = (Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if(children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				v = getChildrenText(children);
			}
			
			m.put(k, v);
		}
		
		//关闭�?
		in.close();
		
		return m;
	}
	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}
		
		return sb.toString();
	}
  public static InputStream String2Inputstream(String str) {
		return new ByteArrayInputStream(str.getBytes());
	}

}

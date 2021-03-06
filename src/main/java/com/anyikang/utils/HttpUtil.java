package com.anyikang.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class HttpUtil {

    private static final String UTF_8 = HTTP.UTF_8;

    public static String post(String url , Map<String , String> params) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        if(params != null ){
            List<BasicNameValuePair> lparams = new LinkedList<BasicNameValuePair>();
            for (ConcurrentHashMap.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    lparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }else{
                    lparams.add(new BasicNameValuePair(entry.getKey(), ""));
                }
            }
            HttpEntity entiry = new UrlEncodedFormEntity(lparams, UTF_8);
            post.setEntity(entiry);
        }
        try {
            HttpResponse resonse = client.execute(post);
            return entityToString(resonse);
        } catch (Exception exception) {
            throw exception;
        } finally {
            post.abort();
            client.getConnectionManager().shutdown();
        }
    }
    
    /**
     * post请求，包含文件上传
     * @param url
     * @param params
     * @param fileParams(fileName,file)
     * @return
     * @throws Exception
     */
    public static String post(String url, Map<String, String> params, Map<String, Object> fileParams) throws Exception {  
    	CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);   
        MultipartEntityBuilder meBuilder = MultipartEntityBuilder.create(); 
        if(params != null ){
            for (ConcurrentHashMap.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue() != null) {
                    meBuilder.addPart(entry.getKey(), new StringBody(entry.getValue(), ContentType.TEXT_PLAIN));  
                }else{
                    meBuilder.addPart(entry.getKey(), new StringBody("", ContentType.TEXT_PLAIN));  
                }
            }
        }
        if(fileParams != null ){
        	FileBody fileBody = new FileBody((File) fileParams.get("file"));  
            meBuilder.addPart((String)fileParams.get("fileName"), fileBody);  
        }
        
        HttpEntity reqEntity = meBuilder.build();  
        post.setEntity(reqEntity);  
        
        try {
            HttpResponse resonse = client.execute(post);
            return entityToString(resonse);
        } catch (Exception exception) {
            throw exception;
        } finally {
            post.abort();
            client.getConnectionManager().shutdown();
        }
         
    }  

    public static String get(String url) throws Exception{
        CloseableHttpClient client = HttpClients.createDefault();

        HttpGet get = new HttpGet(url);
        try {
            HttpResponse resonse = client.execute(get);
            return entityToString(resonse);
        } catch (Exception exception) {
            throw exception;
        } finally {
            get.abort();
            client.getConnectionManager().shutdown();
        }
    }
    
    /**
     * 针对请求url地址中有特殊字符的方式
     * @param specificURL
     * @return
     * @throws Exception
     */
    public static String getSpecificURL(String specificURL) throws Exception{
    	URL url = new URL(specificURL);
		URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
    	
    	CloseableHttpClient client = HttpClients.createDefault();
    	
    	HttpGet get = new HttpGet(uri);
    	try {
    		HttpResponse resonse = client.execute(get);
    		return entityToString(resonse);
    	} catch (Exception exception) {
    		throw exception;
    	} finally {
    		get.abort();
    		client.getConnectionManager().shutdown();
    	}
    }

    public static String entityToString(HttpResponse resonse) throws Exception{
        HttpEntity entity = resonse.getEntity();
        if (entity != null) {
            String msg = null;
            try {
                msg = EntityUtils.toString(entity, UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int code = resonse.getStatusLine().getStatusCode();
            if (code == 200) {
                return msg;
            } else {
                String errerMsg = (msg == null ? null : msg);
                throw new Exception("http code:" + code +",error:"+ errerMsg);
            }
        }
        throw new Exception("http entity is null");
    }

    public static byte[] entityTobyte(HttpResponse resonse) throws Exception {
        HttpEntity entity = resonse.getEntity();
        if (entity != null) {
            byte[] buffer = null;
            try {
                buffer = EntityUtils.toByteArray(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int code = resonse.getStatusLine().getStatusCode();
            if (code == 200) {
                return buffer;
            } else {
                String errerMsg = (buffer == null ? null : new String(buffer, UTF_8));
                throw new Exception("http code:" + code +",error:"+ errerMsg);
            }
        }
        throw new Exception("http entity is null");
    }
}

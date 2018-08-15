package com.xidian.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;


/**
 * @author Zhang Chenghui
 * E-mail: 463170098@qq.com
 * @version 1.0 
 * 创建时间：2017年11月30日 下午4:59:56
 * 说明：
 */
public class HttpsUtil {

    public static String postHttpsRequest( final String address,final String rawParams)throws Exception {

        FutureTask<String> task = new FutureTask<String>(
                new Callable<String>() {
                    public String call() throws Exception {
                        String response;
                       
                        //方案1：添加CA证书至新任列表并进行验证
                        SSLSocketFactory sslSocketFactory = getSSL();
                       

                        //5. HttpsURLConnection将默认的SSLSocketFactory替换为刚刚创建的SSLContext对象
                        URL url = new URL(address);
                        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                        urlConnection.setSSLSocketFactory(sslSocketFactory);
                        HostnameVerifier hv = new HostnameVerifier() {
                            public boolean verify(String urlHostName, SSLSession session) {
                                System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                                return true;
                            }
                        };
                        urlConnection.setHostnameVerifier(hv);
                        
                        urlConnection.setRequestProperty("Referer",address);
                        urlConnection.setRequestProperty("Charset", "UTF-8");
                        urlConnection.setRequestProperty("Content-Type", "Application/json ");
                        urlConnection.setRequestProperty("Accept-Type","Application/json");
                        urlConnection.setReadTimeout(8000);
                        urlConnection.setConnectTimeout(8000);
                        urlConnection.setRequestMethod("POST");
                        urlConnection.setDoOutput(true);
                        urlConnection.setDoInput(true);
                        urlConnection.connect();
                        //urlConnection.setHostnameVerifier(v);

                        String data =rawParams;
                        System.out.println("data"+data);
                        
                        OutputStream out = urlConnection.getOutputStream();
                        out.write(data.getBytes());
                        out.flush();
                        out.close();


                        if (HttpsURLConnection.HTTP_OK == urlConnection.getResponseCode()) {
                            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                            StringBuffer sb = new StringBuffer();
                            String line;
                            while ((line = br.readLine()) != null) {
                                sb.append(line);
                            }
                            response = sb.toString();
//                            Log.d("maggie", "Https得到返回：" + response);
                           // System.out.println("response"+response);

                            
                                    
                                
                               
                            

                            return response;
                            }else {
                            	System.out.println("code:"+urlConnection.getResponseCode());
                            }
                        //方案1：需验证服务器证书（完成！）



                        return null;
                    }
                });
        new Thread(task).start();
        return task.get();
    }

    public static void getHttpsResponse( final String address) {
        new Thread(new Runnable() {
            public void run() {
                HttpsURLConnection conn = null;
                String jsonData = null;
                try {
                    SSLSocketFactory ssl = getSSL();
                    URL url = new URL(address);
                    
                    conn = (HttpsURLConnection) url.openConnection();
                    conn.setSSLSocketFactory(ssl);
                    HostnameVerifier hv = new HostnameVerifier() {
                        public boolean verify(String urlHostName, SSLSession session) {
                            System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
                            return true;
                        }
                    };
                    conn.setHostnameVerifier(hv);
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(8000);
                    conn.setReadTimeout(8000);
                    conn.setDoOutput(true);
                    conn.setDoInput(true);
                    conn.connect();

                    if (conn.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuffer sb = new StringBuffer();
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);
                        }
                        jsonData = sb.toString();
                        System.out.println(jsonData);

                       
                    }else{
                    	System.out.println("code:"+conn.getResponseCode());
                    }
                    

                } catch (Exception e) {
                    
                    }
                } 
            
        }).start();
    }
    



    private static SSLSocketFactory getSSL() {
        SSLSocketFactory sslSocketFactory = null;
        try {

            //1.将softRSAroot.cer放入Assets目录下，从Assets中读取流并生成X.509格式证书
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            FileInputStream caInput = new FileInputStream("ca-145.cer");//softRSAroot.cer为服务器证书的根证书
            Certificate ca = null;
            try {
                ca = cf.generateCertificate(caInput);
            }finally {
                caInput.close();
            }

            //2. 创建一个包含可信CA的keystore
            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);


            //3.用包含可信CA的KeyStore生成一个TrustManager
            // TrustManager是系统用于从服务器验证证书的工具
            // 可使用一个或多个CA创建keystore，使用该keystore创建的TrustManager仅信任这些CA
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);
            
         // 将自己的证书添加
                 
         	String kmfAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
         	KeyStore keyStore2 = KeyStore.getInstance("jks");
         	FileInputStream pfx = new FileInputStream("fidotest-admin.jks");
         	keyStore2.load(pfx, "1".toCharArray());
         	KeyManagerFactory kmf = KeyManagerFactory.getInstance(kmfAlgorithm);
         	kmf.init(keyStore2,"1".toCharArray());
                 
            //4. 创建并初始化一个使用TrustManager的SSLContext
            //SSLContext可提供一个SSLSocketFactory
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            sslSocketFactory = sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslSocketFactory;
    }
}
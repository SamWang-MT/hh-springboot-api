package com.conpany.project;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.http.webservice.SoapClient;

/**
 * //TODO
 *
 * @since jdk1.8
 */
public class TestWebService {
  
	
	/**
<soap:Envelope xmlns:soap="http://www.w3.org/2003/05/soap-envelope" xmlns:web="http://webxml.com.cn/">
   <soap:Header/>
   <soap:Body>
      <web:getSupportCurrencyString/>
   </soap:Body>
</soap:Envelope>
	 * 
	 * 
	 */
	
	  public static void main(String[] args) {
		// 新建客户端
		  SoapClient client = SoapClient.create("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx")
		      // 设置要请求的方法，此接口方法前缀为web，传入对应的命名空间
		      .setMethod("web:getSupportCity", "http://WebXml.com.cn/")
		      // 设置参数，此处自动添加方法的前缀：web
		      .setParam("byProvinceName", "江苏");

		      // 发送请求，参数true表示返回一个格式化后的XML内容
		      // 返回内容为XML字符串，可以配合XmlUtil解析这个响应
		  
		  String contentString = client.send(true);
		      Console.log(contentString);
		  
		      Document parseXml = XmlUtil.parseXml(contentString);
		      
		      NodeList noteList = parseXml.getElementsByTagName("string");
		    for (int i = 0; i < noteList.getLength(); i++) {
		    	Node item = noteList.item(i);
		    	System.out.println(item.getNodeValue());
			}
		  
//		  TestWebService.dynamicCall();//动态调用
//        Client.proxyCall();//代理工厂
    }
 
    /**
     * 调用方式一:动态调用webservice
     */
	/*
	 * public static void dynamicCall(){ //创建动态客户端 JaxWsDynamicClientFactory
	 * jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
	 * org.apache.cxf.endpoint.Client client =
	 * jaxWsDynamicClientFactory.createClient(
	 * "http://www.webxml.com.cn/WebServices/ExchangeRateWebService.asmx?wsdl"); try
	 * { //invoke("方法名",参数1,参数2,参数3....); Object[]
	 * object=client.invoke("getSupportCurrency","");
	 * System.out.println("服务器返回结果"+object[0]); }catch (Exception e){
	 * e.printStackTrace(); } }
	 */
 
    /**
     * 调用方式二:代理工厂方式,该方式需要拿到对方的接口地址
     */
//    public static void proxyCall(){
//        try{
//            //接口地址
//            String address="http://localhost:8080/services/hello?wsdl";
//            //代理工厂
//            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
//            //设置代理地址
//            jaxWsProxyFactoryBean.setAddress(address);
//            //设置接口类型
//            jaxWsProxyFactoryBean.setServiceClass(WebServiceHelloWorld.class);
//            //创建一个代理接口实现
//            WebServiceHelloWorld webServiceHelloWorld = (WebServiceHelloWorld)jaxWsProxyFactoryBean.create();
//            //调用代理接口方法并获取返回结果
//            String s = webServiceHelloWorld.sayHello("小红");
//            System.out.println("服务器返回结果 "+s);//打印返回结果
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


}
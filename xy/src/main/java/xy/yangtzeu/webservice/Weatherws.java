package xy.yangtzeu.webservice;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.dom4j.DocumentException;

/** 
 * 调用天气预报 
 */  
public class Weatherws {  
	
    public static void main(String[] args) throws DocumentException {  
        Weatherws client = new Weatherws();  
       String xml2 = client.weather("武汉");  
       String weather [] =xml2.split("</string><string>");
       for (int i = 0;i < weather.length-1;i++){
    	   System.out.println(i+"~~~~~"+weather[i]);
       }
   
    }  
    public String  weather(String city) {  
    	String xml = "";
        try {  
            ServiceClient sc = new ServiceClient();  
            Options opts = new Options();  
            // 确定目标服务地址  
            // location  
            opts.setTo(new EndpointReference(  
                    "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl"));  
            // 确定调用方法  
            // 对应soapAction  
            opts.setAction("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");  
            opts.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);  
            sc.setOptions(opts);  
            // 发送请求并并得到返回结果，注意参数生成方法的分析  
            OMElement res = sc.sendReceive(createPayLoad(city));  
            // 值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。  
            xml = res.toString();
            res.getFirstElement().getText();   
            System.out.println(xml);
        } catch (AxisFault e) {  
            e.printStackTrace();  
        }  
       return xml;
    }  
  
    public static OMElement createPayLoad(String city) {  
        OMFactory fac = OMAbstractFactory.getOMFactory();  
        // 指定命名空间  
        OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");  
        // 指定方法  
        OMElement method = fac.createOMElement("getWeather", omNs);  
        OMElement p1 = fac.createOMElement("theCityCode", omNs);  
        OMElement p2 = fac.createOMElement("userID", omNs);  
        method.addChild(p1);  
        method.addChild(p2);  
        p1.setText(city);  
        // 返回方法（实际上就是OMElement封装的xml字符串）  
        return method;  
    }  
}  
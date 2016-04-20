package xy.yangtzeu.webservice;

import java.io.File;
import java.util.List;

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


public class phone {
    public static void main(String[] args) throws DocumentException {  
    	phone client = new phone();  
       String xml2 = client.testDocument("18717164035");  
       
            System.out.println(xml2.substring(82,108));
   
    }  
    public String  testDocument(String tel) {  
    	String xml = "";
        try {  
            ServiceClient sc = new ServiceClient();  
            Options opts = new Options();  
            // 确定目标服务地址  
            // location  
            opts.setTo(new EndpointReference(  
                    "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl"));  
            // 确定调用方法  
            // 对应soapAction  
            opts.setAction("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");  
            opts.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);  
            sc.setOptions(opts);  
            // 发送请求并并得到返回结果，注意参数生成方法的分析  
            OMElement res = sc.sendReceive(createPayLoad(tel));  
            // 值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。  
            xml = res.toString();
            res.getFirstElement().getText();   
            System.out.println(xml);
        } catch (AxisFault e) {  
            e.printStackTrace();  
        }  
       return xml;
    }  
  
    public static OMElement createPayLoad(String tel) {  
        OMFactory fac = OMAbstractFactory.getOMFactory();  
        // 指定命名空间  
        OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");  
        // 指定方法  
        OMElement method = fac.createOMElement("getMobileCodeInfo", omNs);  
        OMElement p1 = fac.createOMElement("mobileCode", omNs);  
        OMElement p2 = fac.createOMElement("userID", omNs);  
        method.addChild(p1);  
        method.addChild(p2);  
        p1.setText(tel);  
        // 返回方法（实际上就是OMElement封装的xml字符串）  
        return method;  
    }  
}

package xy.yangtzeu.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class nameutil {
//����
public static String username(){
	String xing = "�ԣ�Ǯ�����ܣ��⣬֣�������ţ�ŷ����Ф�������������£���";
	String ming = "��������Խ�������죬�أ��������£�ʦ�������䣬�ܣ�����������";
	String[] x = xing .split("��");
	String[] m  = ming .split("��");
	return x[(int)(1+Math.random()*14)]+m[(int)(1+Math.random()*14)];
}
//��˾����
public static String compayname(){
	String xing = "��磬��԰����ɫ�����������������㣬��ǣ�Сʤ��̫�ͣ�������̩������ͣ���磬��̩�����";
	String adress = "�������人���Ͼ������ģ��������ӱ������ϣ���򣬾��ݣ����ţ�̫ԭ��������������ɽ������������������������գ�����";
	String compay = "ũҵ��˾��ũó���ţ�ũ�̺����磬���޹�˾����չ��˾�����ϼ��ţ�";
	String[] x = xing .split("��");
	String[] y = adress.split("��");
	String[] z  = compay.split("��");
	return y[(int)(1+Math.random()*18)]+x[(int)(1+Math.random()*14)]+z[(int)(1+Math.random()*5)];
}
//��ַ
public static String adress(){
	String adress = "�������人���Ͼ������ģ��������ӱ������ϣ���򣬾��ݣ����ţ�̫ԭ��������������ɽ������������������������գ����ţ�";
	String[] y = adress.split("��");
	return y[(int)(1+Math.random()*18)];
}	
//��Ϣ��Դ
public static String from(){
	String xing = "�й�ũҵ��������ũҵ��������ũҵ������ԭũҵ��С��Ұ������԰ũҵ��������ũҵ��������ũ�����������������ţ����ϱ�k���﹫˾��Ѷ������԰��Ѷ������ũó��Ѷ������ũ����Ѷ��������ˮ��Ѷ������ũó��Ϣ���ز�ũũ��Ϣ";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*15)];
}	
//��������
public static String commentcontent(){
	String xing = "666��ֵ��һ�������Ҿ�Ȼ�����Զԣ���¥�����ԣ��ҷ����ҷ��ˡ�����ͽ��200���ⲻ����ġ�����������,�����ˣ��Ҳ��š�������¥������������";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*9)];
}	
//������
public static String adtitle(){
	String xing = "���������������ͣ���ͬС�ɣ��������ֻ��һ���˵Ĺ�棬��ɫ��棬���������£�����ѷ�ڶȣ��ǺǺ�";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*8)];
}	

//��Ѷ����
public static String newscontent(){
	String xing = "Spring�����һ��ΪJavaӦ�ó���Ŀ����ṩ���ۺϡ��㷺�Ļ�����֧�ֵ�Javaƽ̨��Spring���������߽���˿����л����Ե����⣬ʹ�ÿ�����Ա����רע��Ӧ�ó���Ŀ�����Spring��ܱ������ǰ������ģʽ���Ĵ��죬��ʹ�����ǿ����ڿ��������а��ĵļ���Spring��ܣ����ص���Spring������ں�̨���й����ġ�"
	+"����EJB������Ƚϣ�IoC����������������������������һ��IoC���������޵��ڴ��CPU��Դ������½���Ӧ�ó���Ŀ����ͷ����ͱ��ʮ��������"
			+"Ҫ����һ����Spring������Ӧ�ó���ʮ�ּ򵥣���Ϊ������صĻ������붼�Ѿ������ڿ�����ˡ����Ӽ򵥵��ǣ�����JavaBean��ʽ��POJO�࣬���Ժܷ������������ע����д���������"
	+"Spring�ṩ��һ����ݵ��������ӿڣ�������С�͵ı������ﴦ�������ڵ�DB�Ļ����£��͸��ӵĹ�ͬ���ﴦ����������JTA�ĸ���DB��������";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*12)];
}	
//��Ѷ����
public static String newstitle(){
	String xing = "�����о���������߲ˣ�ת����ʳ����ȵ�ũҵ���ƣ�ũҵ���ߣ�ũó�ᣬũҵ������ٿ�����ҵ��е����";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*7)];
}	
//��Ʒ���
public static String productmessage(){
	String xing = "��";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*8)];
}	
//�ǳ�
public static String nickname(){
	String xing = "666��hau�����ߵģ��ɰ��ģ����ǣ����ϴϣ��Ǻǣ���������ʹ�ģ�";
	String ming = "�������ʺ磬ק�ˣ�#@~�գ�wuli~����ҡ���233�����ȣ����ã�ħ��ʥ��ʿ";
	String[] y = xing.split("��");
	String[] z = ming.split("��");
	return y[(int)(1+Math.random()*8)]+z[(int)(1+Math.random()*10)];
}	
//����ʱ��
public static String nowtime(){
	String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	return time;
}
//����ʱ��
public static String timesimple(String type){
	String time=new SimpleDateFormat(type).format(new Date());
	return time;
}
//
/**
 * ��ȡϵͳ��ˮ��
 * @param length   ָ����ˮ�ų���
 * @param toNumber ָ����ˮ���Ƿ�ȫ���������
 */
public static String getSysJournalNo(int length, boolean isNumber){
    //replaceAll()֮�󷵻ص���һ����ʮ��������ʽ��ɵ��ҳ���Ϊ32���ַ���
    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
    if(uuid.length() > length){
        uuid = uuid.substring(0, length);
    }else if(uuid.length() < length){
        for(int i=0; i<length-uuid.length(); i++){
            uuid = uuid + Math.round(Math.random()*9);
        }
    }
    if(isNumber){
        return uuid.replaceAll("a", "1").replaceAll("b", "2").replaceAll("c", "3").replaceAll("d", "4").replaceAll("e", "5").replaceAll("f", "6");
    }else{
        return uuid;
    }
}
public static String getSysJournalNo(){
    return getSysJournalNo(20, true);
}

	
//
public static String phonename(){
	String adress = "С�ף���Ϊ��ƻ�������ӣ���������ף����������룬���ˣ����մLG��ŵ���ǣ�";
	String[] y = adress.split("��");
	return y[(int)(1+Math.random()*11)];
}	

//
//��Ѷ����
public static String brand(){
	String xing = "һ�������磬ѩ������ѩ�������������Σ�������죬���������ᣬ����";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*10)];
}	


//sex
public static String sex(){
	String xing = "�У�Ů���У�Ů���У�Ů���У�Ů���У�Ů";
	String[] y = xing.split("��");
	return y[(int)(1+Math.random()*9)];
}	

//����ʱ��
//
public static String phone(){
	String xing = "152,234,356,542,975,724,624,812,021,424,623";
	String[] y = xing.split(",");
	return "13"+y[(int)(1+Math.random()*10)]+y[(int)(1+Math.random()*9)]+y[(int)(1+Math.random()*8)];
}	
//
public static String plcardtitle(){
	String xing = "java,ios,php,.net,c#";
	String xin = "����,����,��ά,";
	String[] x= xin.split(",");
	String[] y = xing.split(",");
	return "��Ƹ"+y[(int)(1+Math.random()*4)]+x[(int)(1+Math.random()*2)];
}	
//
public static String carcode(){
	String xing = "152,234,356,542,975,724,624,812,021,424,623";
	String xin = "��,��,��,��,��,��,��,��,��,��,";
	String xi = "A,B,C,D,G,F,N,M,S";
	String[] y = xing.split(",");
	String[] x = xin.split(",");
	String[] z = xi.split(",");
	return x[(int)(1+Math.random()*9)]+z[(int)(1+Math.random()*8)]+y[(int)(1+Math.random()*10)];
}	


//

public static void main(String[] args) {
	System.out.println(nameutil.username());
	System.out.println(nameutil.nowtime());
	System.out.println(nameutil.getSysJournalNo(5,true));
	System.out.println(nameutil.timesimple("yyyy��MM��dd��HHʱmm��ss��"));
   }
}


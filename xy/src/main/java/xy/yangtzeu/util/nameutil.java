package xy.yangtzeu.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class nameutil {
//姓名
public static String username(){
	String xing = "赵，钱，孙，李，周，吴，郑，王，张，欧阳，肖，东方，韩，陈，曾";
	String ming = "三，坤，越，奎，天，地，晓晓，勇，师，国，武，杰，军，明，云";
	String[] x = xing .split("，");
	String[] m  = ming .split("，");
	return x[(int)(1+Math.random()*14)]+m[(int)(1+Math.random()*14)];
}
//公司名称
public static String compayname(){
	String xing = "清风，田园，绿色，华辰，华北，兰香，丰城，小胜，太和，利宝，泰安，祥和，乡风，和泰，丰城";
	String adress = "北京，武汉，南京，宁夏，西宁，河北，河南，天津，荆州，天门，太原，保定，邯郸，山西，陕西，武昌，岳阳，安徽，厦门";
	String compay = "农业公司，农贸集团，农商合作社，有限公司，发展公司，联合集团，";
	String[] x = xing .split("，");
	String[] y = adress.split("，");
	String[] z  = compay.split("，");
	return y[(int)(1+Math.random()*18)]+x[(int)(1+Math.random()*14)]+z[(int)(1+Math.random()*5)];
}
//地址
public static String adress(){
	String adress = "北京，武汉，南京，宁夏，西宁，河北，河南，天津，荆州，天门，太原，保定，邯郸，山西，陕西，武昌，岳阳，安徽，厦门，";
	String[] y = adress.split("，");
	return y[(int)(1+Math.random()*18)];
}	
//信息来源
public static String from(){
	String xing = "中国农业网，华北农业网，湖北农业网，草原农业，小天野望，田园农业网，湖南农业网，北方农网，北京优利保新闻，海南保k生物公司资讯，湖北园资讯，华南农贸资讯，三井农产资讯，蓝天清水资讯，华彩农贸信息，地产农农信息";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*15)];
}	
//评论内容
public static String commentcontent(){
	String xing = "666，值得一看！，我竟然无言以对！，楼上真言，我服了我服了。，收徒吗？200，这不是真的。。。，无语,给跪了，我不信。。。，楼主厉害！！！";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*9)];
}	
//广告标题
public static String adtitle(){
	String xing = "绝妙物产，天地正和，大同小飞，旷世器物，只有一个人的广告，绿色广告，公益行天下，亚马逊第度，呵呵呵";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*8)];
}	

//资讯内容
public static String newscontent(){
	String xing = "Spring框架是一个为Java应用程序的开发提供了综合、广泛的基础性支持的Java平台，Spring帮助开发者解决了开发中基础性的问题，使得开发人员可以专注于应用程序的开发，Spring框架本身亦是按照设计模式精心打造，这使得我们可以在开发环境中安心的集成Spring框架，不必担心Spring是如何在后台进行工作的。"
	+"，与EJB容器相比较，IoC容器更加趋向于轻量级。，这样一来IoC容器在有限的内存和CPU资源的情况下进行应用程序的开发和发布就变得十分有利。"
			+"要测试一项用Spring开发的应用程序十分简单，因为测试相关的环境代码都已经囊括在框架中了。更加简单的是，利用JavaBean形式的POJO类，可以很方便的利用依赖注入来写入测试数据"
	+"Spring提供了一个便捷的事务管理接口，适用于小型的本地事物处理（比如在单DB的环境下）和复杂的共同事物处理（比如利用JTA的复杂DB环境）。";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*12)];
}	
//资讯标题
public static String newstitle(){
	String xing = "最新研究产物，大棚蔬菜，转基因食物，最热的农业趋势，农业政策，农贸会，农业基金会召开，工业机械化，";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*7)];
}	
//产品简介
public static String productmessage(){
	String xing = "，";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*8)];
}	
//昵称
public static String nickname(){
	String xing = "666，hau，暴走的，可爱的，我是，王聪聪，呵呵，嘻嘻，天使的，";
	String ming = "人生，彩虹，拽人，#@~空，wuli~，儒家。，233，都比，天堂，魔鬼，圣斗士";
	String[] y = xing.split("，");
	String[] z = ming.split("，");
	return y[(int)(1+Math.random()*8)]+z[(int)(1+Math.random()*10)];
}	
//现在时间
public static String nowtime(){
	String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	return time;
}
//现在时间
public static String timesimple(String type){
	String time=new SimpleDateFormat(type).format(new Date());
	return time;
}
//
/**
 * 获取系统流水号
 * @param length   指定流水号长度
 * @param toNumber 指定流水号是否全由数字组成
 */
public static String getSysJournalNo(int length, boolean isNumber){
    //replaceAll()之后返回的是一个由十六进制形式组成的且长度为32的字符串
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
	String adress = "小米，华为，苹果，锤子，坚果，红米，魅蓝，联想，中兴，多普达，LG，诺基亚，";
	String[] y = adress.split("，");
	return y[(int)(1+Math.random()*11)];
}	

//
//资讯标题
public static String brand(){
	String xing = "一汽，东风，雪铁龙，雪佛兰，宝马，本次，丰田，红旗，长安，长丰，广汽";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*10)];
}	


//sex
public static String sex(){
	String xing = "男，女，男，女，男，女，男，女，男，女";
	String[] y = xing.split("，");
	return y[(int)(1+Math.random()*9)];
}	

//现在时间
//
public static String phone(){
	String xing = "152,234,356,542,975,724,624,812,021,424,623";
	String[] y = xing.split(",");
	return "13"+y[(int)(1+Math.random()*10)]+y[(int)(1+Math.random()*9)]+y[(int)(1+Math.random()*8)];
}	
//
public static String plcardtitle(){
	String xing = "java,ios,php,.net,c#";
	String xin = "测试,开发,运维,";
	String[] x= xin.split(",");
	String[] y = xing.split(",");
	return "招聘"+y[(int)(1+Math.random()*4)]+x[(int)(1+Math.random()*2)];
}	
//
public static String carcode(){
	String xing = "152,234,356,542,975,724,624,812,021,424,623";
	String xin = "鄂,湘,京,晋,西,沪,渝,云,辽,黑,";
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
	System.out.println(nameutil.timesimple("yyyy年MM月dd日HH时mm分ss秒"));
   }
}


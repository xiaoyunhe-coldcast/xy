<%@ page language="java" contentType="image/jpeg" import="java.awt.*,java.awt.image.*,java.util.*,javax.imageio.*"
    pageEncoding="UTF-8"%>
<%!
	Color getRandColor(int fc,int bc) {
	//给定范围获得随机颜色
	Random random = new Random();
	if(fc>225) fc=225;
	if(bc>225) bc=225;
	int r = fc+random.nextInt(bc-fc);
	int g = fc+random.nextInt(bc-fc);
	int b = fc+random.nextInt(bc-fc);
	return new Color(r,g,b);
	}
%>
<%
	//设置页面不缓存
	response.setHeader("pragma", "No-cache");
	response.setHeader("Cache-Control", "No-cache");
	response.setDateHeader("Expires", 0);
	//在内存中创建图像
	int width=60, height=20;
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
	//获取图形上下文
	Graphics g = image.getGraphics();
	Random random = new Random();
	//设定背景色
	g.setColor(getRandColor(200,250));
	g.fillRect(0, 0, width, height);
	//设定字体
	g.setFont(new Font("Times New Roman",Font.PLAIN,18));
	//画边框
	g.setColor(getRandColor(160,200));
	for(int i=0;i<155;i++) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x1 = random.nextInt(12);
		int y1 = random.nextInt(12);
		g.drawLine(x, y, x+x1, y+y1);
	}
	//取随机产生的认证码（4位数字）
	String sRand="";
	for(int i=0;i<4;i++) {
		String rand = String.valueOf(random.nextInt(10));
		sRand += rand;
		//将认证码显示到图像中
		g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
		g.drawString(rand, 13*i+6, 16);
	}
	//将验证码存入session中
	session.setAttribute("rand", sRand);
	//图像生效
	g.dispose();
	//输出图像到页面
	ImageIO.write(image, "JPEG", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
	
%>
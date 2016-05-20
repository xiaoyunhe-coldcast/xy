<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>实用的图片切换</title>
<script type="text/javascript" src="/xy/js/jquery.min.js"></script>

<style type="text/css">
 body,ul,li { 
	 padding:0; 
	 margin:0
 }
 ul,li { 
 	list-style:none
 }
 .img-scroll {
	  position:relative; 
  }
 .img-scroll .prev,.img-scroll .next {
	  position:absolute; 
	  display:block; 
	  color:#FFF; 
	  text-align:center;
	  line-height:100px
  }
 .img-scroll .prev { 
	 left:200px;
	 top:380px;
	 cursor:pointer;
 }
 .img-scroll .next {
	  left:580px;
	   top:380px;
	  cursor:pointer;
  }
 .img-list { 
	 position:relative; 
	 width:920px;
	 height:400px;
	 margin :25px;
	 overflow:hidden
  }
 .img-list ul { 
	 width:99999px;
 }
 .img-list li {
		float:left; 
		display:inline;
	    width:920px;
		height:400px; 
		background-color:#BDBDDF;
	    text-align:center; 
	    line-height:400px;
      }
</style>
</head>
<body>
<div class="img-scroll">
    <span class="prev">上一张</span>
    <span class="next">下一张</span>
    <div class="img-list">
        <ul>
            <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo1.jpg"></li>
            <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo2.jpg"></li>
            <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo3.jpg"></li>
            <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo4.jpg"></li>
            <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo1.jpg"></li>
            <li><img style="width:920px;height:400px;;" src="/xy/img/logo/logo2.jpg"></li>
            <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo3.jpg"></li>
             <li><img style="width:920px;height:400px;" src="/xy/img/logo/logo4.jpg"></li>
        </ul>
    </div>
</div>
<script type="text/javascript">
 function DY_scroll(wraper,prev,next,img,speed,or)
 {
  var wraper = $(wraper);
  var prev = $(prev);
  var next = $(next);
  var img = $(img).find('ul');
  var w = img.find('li').outerWidth(true);
  var s = speed;
  next.click(function()
       {
        img.animate({'margin-left':-w},function()
                  {
                   img.find('li').eq(0).appendTo(img);
                   img.css({'margin-left':0});
                   });
        });
  prev.click(function()
       {
        img.find('li:last').prependTo(img);
        img.css({'margin-left':-w});
        img.animate({'margin-left':0});
        });
  if (or == true)
  {
   ad = setInterval(function() { next.click();},s*1000);
   wraper.hover(function(){clearInterval(ad);},function(){ad = setInterval(function() { next.click();},s*1000);});

  }
 }
 DY_scroll('.img-scroll','.prev','.next','.img-list',3,true);// true为自动播放，不加此参数或false就默认不自动
</script>
</body>
</html>
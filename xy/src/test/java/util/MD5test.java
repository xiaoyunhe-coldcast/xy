package util;
import org.junit.Test;

import xy.yangtzeu.util.MD5;


public class MD5test {
	MD5 md = new MD5();
	@Test
	public void test(){
		System.out.println(md.getMD5ofStr("123"));
	}
}

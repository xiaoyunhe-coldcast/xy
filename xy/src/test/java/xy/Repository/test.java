package xy.Repository;

import java.io.File;

import org.junit.Test;

import java.io.File;

public class test {
	@Test
	public void test1(){
		File file1 = new File("D:\\3.txt");
		File file2 = new File("D:\\2.txt");
		
		boolean b=file1.renameTo(file2);
		
		System.out.println(b);
	}
	
	@Test
	public void test2(){
		File file1 = new File("d://D/4.txt");
		File file2 = new File("d://D/1.txt");
		
		boolean b=file1.renameTo(file2);
		
		System.out.println(b);
	}
	
	@Test
	public void test3(){
		File file1 = new File("D:/helloWorld1.txt");
		File file2 = new File("D:/io/nihao.txt");
		
		boolean b=file1.renameTo(file2);
		System.out.println(b);
		
	}
}

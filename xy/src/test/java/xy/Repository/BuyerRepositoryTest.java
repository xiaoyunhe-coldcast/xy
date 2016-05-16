package xy.Repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xy.yangtzeu.model.Buyer;
import xy.yangtzeu.repository.BuyerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/spring.xml")
public class BuyerRepositoryTest {
	
	@Resource(name="buyerRepository")
	private BuyerRepository buy;
	
	@Test
	public void test(){
		Buyer buyer = new Buyer();
		buyer.setBuyername("123456");
		buyer.setRealname("njj");
		buyer.setBuyerpsw("123456");
		buyer.setEmail("172662@qq.com");
		buyer.setSex("男");
		buyer.setAddress("12");
		buyer.setTelephone("321");
		buyer.setBuyerpic("32");
		buyer.setMoney(22.0);
		buy.save(buyer);
	}
	
	@Test
	public void test1(){
		Buyer b = buy.queryByName("123456");
		System.out.println(b.getAddress());
	}
	
	//测试不通过 like的位置需要改变
	@Test
	public void test2(){
		List b = buy.getAll(1, 10, "1");
		for (int i = 0;i < b.size();i++){
			System.out.println(b.get(i).toString());
		}
	}
	
	@Test
	public void test3(){
		List b = buy.getAll(1,20);
		for (int i = 0;i < b.size();i++){
			System.out.println(b.get(i).toString()+i+"");
		}
	}
	
	@Test
	public void test4(){
		
	}
}

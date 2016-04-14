package xy.Repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import xy.yangtzeu.model.Orders;
import xy.yangtzeu.repository.OrdersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/spring.xml")
public class OrdersRepositoryTest {
	
	@Resource(name="ordersRepository")
	private OrdersRepository OR;
	
	@Test
	public void test1(){
		List<Orders> a = OR.queryBybuyerid(1);
		for (int i = 0;i < a.size();i++){
			System.out.println(a.get(i).getNum());
			System.out.println(a.get(i).getStatus());
			System.out.println(a.get(i).getBuyer().getAddress());
		}
	}
}

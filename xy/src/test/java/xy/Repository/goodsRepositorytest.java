package xy.Repository;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xy.yangtzeu.model.Goods;
import xy.yangtzeu.repository.GoodsRepository;
import xy.yangtzeu.util.ConvertJson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring/spring.xml")
public class goodsRepositorytest {
	
	@Resource(name="goodsRepository")
	private GoodsRepository GR;
	
	ConvertJson cj = new ConvertJson();
	
	@Test
	public  void test1(){
		
		List<Goods> goodslist = GR.getAll(1, 1,null);
		for (int i = 0;i < goodslist.size(); i++){
			System.out.println(goodslist.get(i).toString());
		}
		String data = cj.list2Json(goodslist);
		System.out.println(data);
		data = "{\"total\":"+GR.count()+" , \"rows\":"+data+"}";
	}
}

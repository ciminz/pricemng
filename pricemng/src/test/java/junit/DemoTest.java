package junit;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

public class DemoTest extends BaseJunit4Test{
	
	@Test
	@Transactional
	@Rollback(true)
	public void testDb() throws Exception {
		System.out.println("测试Spring整合Junit4进行单元测试");  
		
	}
}

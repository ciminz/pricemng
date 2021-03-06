package junit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.nngdjt.pricemng.base.DataBuilder;
import com.nngdjt.pricemng.base.PriceUtil;
import com.nngdjt.pricemng.base.Subway;
import com.nngdjt.pricemng.mapper.LineInfoMapper;
import com.nngdjt.pricemng.mapper.PriceInfoMapper;
import com.vane.base.LocalBeanFactory;

public class PriceCalTest extends BaseJunit4Test{
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCal() throws Exception {
		PriceInfoMapper priceInfoMapper = (PriceInfoMapper)LocalBeanFactory.get(PriceInfoMapper.class);
		priceInfoMapper.deleteByExample(null);
		DataBuilder dataBuilder = new DataBuilder();
		PriceUtil priceUtil = new PriceUtil();

		try {

			long t1 = System.currentTimeMillis();
		
			Subway sw = new Subway(dataBuilder, priceUtil);

			int b = dataBuilder.totalStaion;

		for (int i = 0; i < b; i++)
				for (int y = 0; y < b; y++) {
					sw = new Subway(new DataBuilder(), new PriceUtil());
					sw.calculate(dataBuilder.lines.get(i), dataBuilder.lines.get(y), priceInfoMapper);
				}
			long t2 = System.currentTimeMillis();
			System.out.println();
			System.out.println("耗时：" + (t2 - t1) + "ms");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		DataBuilder dataBuilder = new DataBuilder();
////		PriceUtil priceUtil = new PriceUtil();
//
//		FileWriter fw = null;
//
//		try {
//			fw = new FileWriter("d://1.txt");
//
//			long t1 = System.currentTimeMillis();
////			Subway sw = new Subway();
//
//			int b = dataBuilder.totalStaion;
//
//		for (int i = 0; i < b; i++)
//				for (int y = 0; y < b; y++) {
//					dataBuilder = new DataBuilder();
//					PriceUtil priceUtil = new PriceUtil();
////					sw = new Subway();
//					Subway sw = new Subway(dataBuilder,priceUtil);
//					sw.calculate(dataBuilder.lines.get(i), dataBuilder.lines.get(y), fw);
//					fw.append(
//							"-----------------------------------------------------------------------------------------------------------\r\n");
//				}
//
//			// sw.calculate(new Station("南职院站"), new Station("广西大学站"),fw);
//
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			long t2 = System.currentTimeMillis();
//			System.out.println();
//			System.out.println("耗时：" + (t2 - t1) + "ms");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (null != fw)
//				try {
//					fw.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
	}
}

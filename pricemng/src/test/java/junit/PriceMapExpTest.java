package junit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.nngdjt.pricemng.base.DataBuilder;
import com.nngdjt.pricemng.base.Station;
import com.nngdjt.pricemng.entity.PriceInfo;
import com.nngdjt.pricemng.entity.PriceInfoExample;
import com.nngdjt.pricemng.mapper.PriceInfoMapper;
import com.vane.base.LocalBeanFactory;

import ch.qos.logback.classic.Logger;

public class PriceMapExpTest extends BaseJunit4Test{
	
	@Test
	@Transactional
	@Rollback(false)
	public void testMapExp() throws Exception {
		PriceInfoMapper priceInfoMapper = (PriceInfoMapper)LocalBeanFactory.get(PriceInfoMapper.class);
		  //创建工作簿  
        HSSFWorkbook workBook = new HSSFWorkbook();  
        //创建工作表  工作表的名字叫helloWorld  
        HSSFSheet sheet = workBook.createSheet("票价矩阵");  
        
        DataBuilder dataBuilder = new DataBuilder();
        for(int i = 0; i < dataBuilder.lines.size(); i++) {
        	Station desStation = dataBuilder.lines.get(i);
        	List<PriceInfo> priceInfoList = new ArrayList<PriceInfo>();
        	for(int j = 0; j <= i; j++) {
        		Station oriStation =  dataBuilder.lines.get(j);
        		PriceInfoExample priceInfoExcample = new PriceInfoExample();
        		priceInfoExcample.createCriteria()
        		.andOriStationNoEqualTo(oriStation.getStationNo())
        		.andDesStationNoEqualTo(desStation.getStationNo());
        		List<PriceInfo> priceInfoTmpList = priceInfoMapper.selectByExample(priceInfoExcample);
        		if(priceInfoTmpList != null && priceInfoTmpList.size() != 0) {
        			System.out.println(priceInfoTmpList.get(0).getPrice());
        			priceInfoList.add(priceInfoTmpList.get(0));
        		}
        	}
        	
        	//创建行,第3行  
            HSSFRow row = sheet.createRow(i);
            
            HSSFCell cellStation = row.createCell(0, CellType.STRING);  
            cellStation.setCellValue(desStation.getName());  
            int index = 1;
            for(PriceInfo priceInfo : priceInfoList) {
            	//创建单元格，操作第三行第三列  
                HSSFCell cellPrice = row.createCell(index++, CellType.STRING);  
                cellPrice.setCellValue(priceInfo.getPrice());  
            }
        }
        
        //末尾行，设重点站
        HSSFRow row = sheet.createRow(dataBuilder.lines.size());
        int index = 1;
        for(Station station : dataBuilder.lines) {
        	//创建单元格，操作第三行第三列  
            HSSFCell cellPrice = row.createCell(index++, CellType.STRING);  
            cellPrice.setCellValue(station.getName());  
        }
         
        workBook.write(new File("f:\\测试.xls"));  
          
        workBook.close();//最后记得关闭工作簿  
	}
}

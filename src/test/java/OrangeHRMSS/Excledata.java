package OrangeHRMSS;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Cell;

public class Excledata {
	
 public void data() throws IOException {
	 
	 FileInputStream fes= new FileInputStream("Path");
	 
	 XSSFWorkbook wb=new XSSFWorkbook(fes);
	 
	 XSSFSheet sheet=wb.getSheet("TsetData");
	 
	 int RowCount= sheet.getPhysicalNumberOfRows();
	 
	  for(int i=1; i<RowCount; i++) {
		  XSSFRow row=sheet.getRow(i);
		  for(int j=0; j<row.getPhysicalNumberOfCells(); j++) {
			  XSSFCell cell = row.getCell(j);
			  System.out.println(cell.toString());
		  }
		  
		  
		  System.out.println();
	  }
	 wb.close();
	 fes.close();
	 
	 
 }
 
 
 
 
	
	

}

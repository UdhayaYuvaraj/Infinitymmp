package util;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtil {
	XSSFWorkbook excel;
	
	public ExcelUtil(String excelpath) 
	{
	try
	{
	File file=new File(excelpath);
	FileInputStream fis=new FileInputStream(file);
	excel=new XSSFWorkbook(fis);
	} 
	catch (Exception  e) 
	{
	    System.out.println("Unable to load Excel Sheet Please check"+e.getMessage());
		e.printStackTrace();
	}
	}
	
	public int getRowCount(int SheetNum)
	{
		return excel.getSheetAt(SheetNum).getLastRowNum()+1;
	}
	
	public int getRowCount(String SheetName)
	{
		return excel.getSheet(SheetName).getLastRowNum()+1;
	}
	
	
	public String getCelldata(int SheetNum,int row,int cell)
	{
		return excel.getSheetAt(SheetNum).getRow(row).getCell(cell).toString();
	}
	
	public String getCelldata(String SheetName,int row,int cell)
	{
		return excel.getSheet(SheetName).getRow(row).getCell(cell).toString();
	}
	
}
	

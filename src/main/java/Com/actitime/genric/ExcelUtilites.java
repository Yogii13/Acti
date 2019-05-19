package Com.actitime.genric;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelUtilites{
	
 String filepath;
 
public ExcelUtilites(String filepath)
{
	this.filepath=filepath;
}
public String readData(String sheet,int row,int cell) 
{
	String value=null;
	Workbook wb=null;
	
	try
	{
		File file=new File(filepath);
		FileInputStream fis=new FileInputStream(file);
		
		if (filepath.contains(".xlsx"))
		{
			wb=XSSFWorkbookFactory.create(fis);
		}
		else if(filepath.contains("xls"))
		{
			
			wb=HSSFWorkbookFactory.create(fis);
				
		}
		
		Cell cl=wb.getSheet(sheet).getRow(row).getCell(cell);
		
		switch (cl.getCellType())
		{
		case STRING:
			value=cl.getStringCellValue();
			
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cl)) 
			{
				SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
				value=sdf.format(cl.getDateCellValue());
			}
			else
			{
				long longvalue = (long)cl.getNumericCellValue();
				value=Long.toString(longvalue);
				
			}
			break;
		case BOOLEAN:
			boolean bl = cl.getBooleanCellValue();
			value=Boolean.toString(bl);
			break;

		default: System.out.println("cell formet is not matching");
			break;
		}
	}
	
	catch(IOException e)
	{
		
	}
	return value;
	
	
	
}
}

package ex;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * public class DataReader { public static Object[][] readExcel(String
 * filePath,String fileName,String sheetName) throws IOException{ //Create an
 * object of File class to open xlsx file File file = new File(filePath);
 * //Create an object of FileInputStream class to read excel file
 * FileInputStream inputStream = new FileInputStream(file); Workbook workbook =
 * null; //Find the file extension by splitting file name in substring and
 * getting only extension name String fileExtensionName =
 * fileName.substring(fileName.indexOf(".")); //Check condition if the file is
 * xlsx file if(fileExtensionName.equals(".xlsx")){ //If it is xlsx file then
 * create object of XSSFWorkbook class workbook = new XSSFWorkbook(inputStream);
 * } //Check condition if the file is xls file else
 * if(fileExtensionName.equals(".xls")){ //If it is xls file then create object
 * of HSSFWorkbook class workbook = new HSSFWorkbook(inputStream); } //Read
 * sheet inside the workbook by its name Sheet a = workbook.getSheet(sheetName);
 * //Find number of rows in excel file int rowCount =
 * a.getLastRowNum()-a.getFirstRowNum(); //Create a loop over all the rows of
 * excel file to read it for (int i = 0; i < rowCount+1; i++) { Row row =
 * a.getRow(i); //Create a loop to print cell values in a row for (int j = 0; j
 * < row.getLastCellNum(); j++) { //Print Excel data in console
 * System.out.print(row.getCell(j).getStringCellValue()+"|| "); }
 * System.out.println(); } return null; } //Main function is calling readExcel
 * function to read data from excel file public static void
 * main(String...strings) throws IOException{ //Prepare the path of excel file
 * String filePath =
 * System.getProperty("user.dir")+"\\src\\excelExportAndFileIO"; //Call read
 * file method of the class to read data
 * DataReader.readExcel(filePath,"data.xlsx","Sheet1"); } }
 */

public class DataReader {
	public static Object[][] readExcel(String pathToExcel, String sheetName) throws IOException
	{
	    FileInputStream fileInputStream= new FileInputStream(pathToExcel); 
	    HSSFWorkbook workbook = new HSSFWorkbook (fileInputStream); //get my workbook from xls (not working with xlsx)
	    HSSFSheet worksheet=workbook.getSheet(sheetName);// get workbook
	    DataFormatter formatter= new DataFormatter();
        HSSFRow row=worksheet.getRow(0);     //get first row  
        int RowNum = worksheet.getPhysicalNumberOfRows();// number of Rows
        int ColNum= row.getLastCellNum(); // number of Columns 
        Object Data[][]= new Object[RowNum-1][ColNum];          
            for(int i=0; i<RowNum-1; i++) 
            {  
                row= worksheet.getRow(i+1);                
                for (int j=0; j<ColNum; j++) 
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        HSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell); //Get cell value as string
                            Data[i][j]=value;                         
                        }
                    }
                }
            }
        workbook.close();
        return Data;
	}
}
package configProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataProvider
{
	 HashMap<String, String> excelHashMapValues = new HashMap<String, String>();

	
	public HashMap<String,String> extractExcelData(String testCaseID) throws FilloException, IOException
	{
	
		
		Fillo fillo=new Fillo();
		
		//Connection connection=fillo.getConnection(System.getProperty("user.dir")+"\\DataSheet\\TestData.xlsx");
		Connection connection=fillo.getConnection("C:\\Users\\raghull\\workspace\\pageObject\\DataSheet\\TestDatabase.xlsx");
		//String sheetname= ConfigObj.getProperty("TestDataSheet");
		String strQuery="Select * from UK where TestCaseID='" +testCaseID +"'";
		
		Recordset recordset=connection.executeQuery(strQuery);
		
		while(recordset.next())
		{
			ArrayList<String> ColCollection = recordset.getFieldNames();
			int Iter;
			int size = ColCollection.size();
			for (Iter=0 ; Iter<= (size-1) ; Iter++)
			{
				String ColName = ColCollection.get(Iter);
				System.out.println(ColName);
				String ColValue = recordset.getField(ColName);
				System.out.println(ColValue);
				//HashMap<String, String> excelHashMapValues = new HashMap <String, String>();
				excelHashMapValues.put(ColName, ColValue);				
			}
		}
		recordset.close();
		connection.close();
		
		return excelHashMapValues;
	}////
	
		
	public static void main(String args[]) throws Exception, Exception
	{
		DataProvider dp = new DataProvider();
		dp.extractExcelData("TCID_006");
	}
}
package reusables;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtilities {
	
	public static Recordset createRecordset() {
		
		try {
			Fillo fillo=new Fillo();
			Connection connection=fillo.getConnection("C:\\Users\\Dipin\\eclipse-workspace\\CucumberTestNG\\src\\test\\resources\\Test Data\\InputTestData.xlsx");
			String strQuery="Select * from TagNames";
			Recordset rs = connection.executeQuery(strQuery);
			rs.moveFirst();
			
//			 while(rs.next()){
//				  System.out.println(rs.getField("TagNames"));
//				 }
			 
			return rs;
		
		} catch (FilloException e) {
			e.printStackTrace();
			return null;
		}
	}

}

package reusables;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Filo_Select {

	public static void main(String[] args) throws FilloException {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection("C:\\Users\\Dipin\\eclipse-workspace\\CucumberTestNG\\src\\test\\resources\\Test Data\\InputTestData.xlsx");
		String strQuery = "Select * from TagNames";
		Recordset recordset = connection.executeQuery(strQuery);

		while (recordset.next()) {
			System.out.println(recordset.getField("Details"));
		}

		recordset.close();
		connection.close();
	}
	
	public static void test() {
		
	}

}

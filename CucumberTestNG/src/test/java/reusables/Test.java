package reusables;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

public class Test {

	public static void main(String[] args) {

		getAllTagNames();
	}

	public static String getAllTagNames() {

		List<String> list = new ArrayList<>();
		String str = "";

		try {
			Recordset rs = ExcelUtilities.createRecordset();

			for (int i = 1; i <= rs.getCount(); i++) {
				System.out.println(rs.getField("TagNames"));
				list.add(rs.getField("TagNames"));
				rs.moveNext();

			}
			
			
//			 while(rs.next()){
//				 list.add(rs.getField("TagNames"));
//					rs.moveNext();
//				 }
			 
			
			 
		} catch (FilloException e) {
//			e.printStackTrace();
		}
		System.out.println(list.size());
		 System.out.println(list);
		 
		str = String.join(",", list).replaceAll("[\\[\\]]", "");
		System.out.println("Str: "+str);
		return str;
	}

}

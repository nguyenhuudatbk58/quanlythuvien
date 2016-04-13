package Common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaculateDate {
	public static Long tru(Date a, Date b) {
		Long i = (a.getTime() - b.getTime()) / 86400000;
		System.out.println("i:      " + i);
		return i;
	}

	public static void main(String[] args) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date today = null;
		Date tomorrow = null;
		try {
			today = dateFormat.parse("13-04-2016");
			tomorrow = dateFormat.parse("11-4-2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Long i = (tomorrow.getTime() - (new Date()).getTime()) / 86400000;
		// System.out.println(tomorrow.getTime() - (new Date()).getTime());
		// System.out.println(i + " ngay");
		System.out.println(today.getTime());
		System.out.println((new Date()).getTime());

	}

}

package infinitymmp;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		Calendar calendar=Calendar.getInstance();
		//calendar.add(Calendar.DAY_OF_MONTH,5);
		calendar.add(Calendar.MONTH,5);
		
		//today date use gettime()
		Date d=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MMMM/YYYY");
		//System.out.println(sdf.format(d));
		String date =sdf.format(d);
		String datearr[]=date.split("/");
		System.out.println(datearr[0]);
		System.out.println(datearr[1]);
		System.out.println(datearr[2]);
		
	}

}

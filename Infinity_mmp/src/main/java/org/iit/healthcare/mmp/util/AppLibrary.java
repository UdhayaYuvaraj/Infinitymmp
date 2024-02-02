package org.iit.healthcare.mmp.util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppLibrary {

	protected int value;
	public static String getFutureDate(int noofDays)
	{
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,noofDays);
		
		//today date use gettime()
		Date d=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("d/MMMM/YYYY");
		//System.out.println(sdf.format(d));
		String date =sdf.format(d);
		String datearr[]=date.split("/");
		System.out.println(datearr[0]);
		System.out.println(datearr[1]);
		System.out.println(datearr[2]);
		return date;
	}
	
public static long getRandomNumber(long n)
{
	return (long)(Math.floor(Math.random()*n));
}

}

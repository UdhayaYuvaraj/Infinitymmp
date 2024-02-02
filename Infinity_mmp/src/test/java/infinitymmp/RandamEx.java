package infinitymmp;

import java.util.Random;

public class RandamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random rand=new Random();
		int i=rand.nextInt(100);
		System.out.println(i);
		String emailid="udhaya.asit";
		
		//uppercase 65 to 90
		char ch='A';
		int i1=ch;
		System.out.println(i1);
		
		//lowercase 97 to 122
		int i2=98;
		char ch1=(char) i2;
		System.out.println(ch1);
		
		//uppercase 65 to 90
		//lowerlimit+randInt(upperlimit-lowerlimit+1)
		
		int u=12345678+rand.nextInt(26);
		System.out.println("UpperCase:"+u);
		char uppercase=(char) u;
		
		//lowercase 97 to 122
		int l=97+rand.nextInt(122-97+1);
		System.out.println("LowerCase:"+l);
		char lowercase=(char)l;
		
		int a=65+rand.nextInt(26);
		char upper1=(char) a;
		System.out.println("UpperCase:"+upper1);
		
		
		
		System.out.println(emailid+uppercase+lowercase+i+"@gmail.com");
		
	}

}

package firstTry;

import java.util.Random;
import java.sql.Time;


public class Admin {

    /* generate random time*/
	final Random random = new Random();
	final int millisInDay = 24*60*60*1000; //24H
	Time time = new Time((long)random.nextInt(millisInDay));	 
	 
	
	public static void main(String[] args) {
		System.out.println(time2.toString());
		
		
	}
}

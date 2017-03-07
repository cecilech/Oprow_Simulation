package firstTry;

import java.util.Random;
import java.sql.Time;
import java.sql.Time;

public class Admin {

	private String name;
	private Time openingTime=new Time(0,0,0); // warning: initialize time at 1am.
	private Time closingTime=new Time(0,0,0);
	
	
	Admin(String name, long opening,long closure){
		this.name=name;
		openingTime.setTime(opening);
		closingTime.setTime(closure);
	}
	
	public String toString(){
		String a="Admin: "+ name + "\nOpening Time: "+openingTime+"\nClosing Time: "+closingTime;
		System.out.println(a);
		return a;
	}
	
	
	
    public static void main(String[] args) {
    	
    	Admin admin=new Admin("CAF",28800000,57600000); // 9h-17h
    	admin.toString();
    	
    	
    	/* generate random time*/
		/*final Random random = new Random();
		final int millisInDay = 24*60*60*1000; //24H
		Time time = new Time((long)random.nextInt(millisInDay));
		System.out.println(time.toString());*/
		
		
	}
}

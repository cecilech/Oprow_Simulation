package firstTry;

import java.util.*;
import java.util.Random;
import java.sql.Time;


public class User {

	private String id;
	private String need; 
	//private float clientPerf; 
	private Time arrivalTime = new Time(0,0,0); // when user arrives in admin
	private Time startQueueTime = new Time(0,0,0);
	private Time finishQueueTime = new Time(0,0,0);
	private Time leavingTime = new Time(0,0,0); // when user leaves admin
	

	/* generate random time*/
	/*final Random random = new Random();
	final int millisInDay = 24*60*60*1000;
	Time time = new Time((long)random.nextInt(millisInDay));*/
	
	
	User (String id, String need, long a, long b,long c,long d){
		this.id=id;
		this.need="";
		arrivalTime.setTime(a);
		startQueueTime.setTime(b);
		finishQueueTime.setTime(c);
		leavingTime.setTime(d);
	}
	
	@Override
	public String toString(){
		return "id: " + id + "\n"+ "need: " + need + "\n"+ "arrivalTime: " + arrivalTime.toString() +  "\n"+
					 "startQueueTime: " + startQueueTime.toString() + "\n"+
					 "finishQueueTime: " + finishQueueTime.toString() + "\n"+
					  "leavingTime: " + leavingTime.toString();
	}
	
	
	public static void main(String[] args) {
		User moi=new User("1234",null,0,0,0,0);
		System.out.println(moi.toString());
		
	}

	public static void HelloWorld(){
		System.out.println("HelloWorld");
	}
}

	

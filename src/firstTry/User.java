package firstTry;

import java.sql.Time;
import java.util.Random;


public class User {

	private String id;
	private String need; 
	//private float clientPerf; 
	private Time arrivalTime = new Time(0,0,0); // when user arrives at admin
	private Time startQueueTime = new Time(0,0,0);
	private Time finishQueueTime = new Time(0,0,0);
	private Time leavingTime = new Time(0,0,0); // when user leaves admin
	private String priority;
	private String numGuichet;
	
	User (String id, String need, long a, long b,long c,long d,String priority, String numGuichet){
		this.id=id;
		this.need="";
		arrivalTime.setTime(a);
		startQueueTime.setTime(b);
		finishQueueTime.setTime(c);
		leavingTime.setTime(d);
		priority=this.priority;
		numGuichet=this.numGuichet;
		
	}
	
	@Override
	public String toString(){
		String user =  "--------------------\n" +
	           "id: " + id + "\n"+ "need: " + need + "\n"+ 
	           "arrivalTime: " + arrivalTime.toString() +  "\n"+
			   "startQueueTime: " + startQueueTime.toString() + "\n"+
			   "finishQueueTime: " + finishQueueTime.toString() + "\n"+
			   "leavingTime: " + leavingTime.toString() + "\n" +
		       "priority: " + priority + "\n" +
			   "numGuichet: " + numGuichet +"\n--------------------";
		System.out.println(user);
		return user;
	}
	
	public Time getRandArrivingTime(Time beginning, Time end){
		final Random random = new Random();
		long timeInMs=(long)random.nextInt(((int)end.getTime()-(int)beginning.getTime()+1))+(int)beginning.getTime();
		Time arrivingTime = new Time(timeInMs);
		System.out.println("Arriving Time: "+arrivingTime);
		arrivalTime=arrivingTime;
	    return arrivalTime;
	}
	
	public String getRandService(){
		final Random random = new Random();
		String[] services={"Make passport","Make id card","Get allocations","Get birth certificate",
				"Get information","Get nationality papers","Make vital card"};
		int index=random.nextInt(services.length);
		need=services[index];
		return need;
	}


	public static void main(String[] args) {
		User moi=new User("1234",null,0,0,0,0,null,null);
		moi.getRandService();
		moi.toString();
	}

	

}

	

package firstTry;

import java.sql.Time;


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
		return "id: " + id + "\n"+ "need: " + need + "\n"+ 
	           "arrivalTime: " + arrivalTime.toString() +  "\n"+
			   "startQueueTime: " + startQueueTime.toString() + "\n"+
			   "finishQueueTime: " + finishQueueTime.toString() + "\n"+
			   "leavingTime: " + leavingTime.toString() + "\n" +
		       "priority: " + priority + "\n" +
			   "numGuichet" + numGuichet;
	}
	
	
	public static void main(String[] args) {
		User moi=new User("1234",null,0,0,0,0,null,null);
		System.out.println(moi.toString());
		
	}


}

	

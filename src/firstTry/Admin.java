package firstTry;

import java.util.Random;
import java.sql.Time;
import java.sql.Time;

public class Admin {

	private String name;
	private Time openingTime=new Time(0,0,0); // warning: initializes time at 1am.
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
	
	
	public double[][] getAffMatrix(){
	/* this fct generates a matrix giving a percentage for each hour of each day for caf paris 15*/
	/* to understand my idea:
	 *   from figures gathered on the CAF website we can find an average of people coming per day 
	 *   -->around 2400 for caf paris 15
	 *   with the percentages apply to that nb for each hour we can get random nb of people coming per hour per day
	 *   we don't care if the sum for each day is > 100% bc the nb of people coming has to fluctuate 
	 */
		
	
		
				
		final Random random = new Random();
				
		double weak=0.08; //weak affluence, perc. of total nb of people coming per day in pondered average
		double moderate=0.15; //moderate aff
		double strong=0.30; //strong aff
		double delta=0.1; 
		double w=0.0;
		double m=0.0;
		double s=0.0;
		double w=1.0;
		double m=2.0;
		double s=3.0;
		
		/*matrix based on a schedule from caf website giving affluence */
		double[][] aff =
		    {
		        { m, m, s, s, m, m, s, s } , // tab[day][hour] 
		        { w, w, m, m, m, m, w, w },    //as we take caf paris 15 as example, only 4 opening days
		        { w, w, w, w, w, w, m, m },   //monday tuesday thursday friday, from 9am to 5pm 
		        { m, m, m, m, m, m, s, s },
		    };
		
		/*BUG dans les if, passe que le premier*/
		for (int i=0;i<aff.length;i++){
			for (int j=0;j<aff[i].length;j++){
						
				if (aff[i][j]==w)
					aff[i][j]=(weak-weak*delta) + ((weak+weak*delta) - (weak-weak*delta)) * random.nextDouble();
				if (aff[i][j]==m)
				
				if (aff[i][j]== m)
					aff[i][j]=(moderate-moderate*delta) + ((moderate+moderate*delta) - (moderate-moderate*delta)) * random.nextDouble();
				
				if (aff[i][j]==s)
					aff[i][j]=(strong-strong*delta) + ((strong+strong*delta) - (strong-strong*delta)) * random.nextDouble();
				System.out.print(aff[i][j]+" ");
				
				//System.out.print(aff[i][j]+" ");
			}
			System.out.println();
			//System.out.println();
		}
		
		return aff;
	}	   
	
	public int getRandNbPeoplePerHour(double[][] affMatrix, String day, long hour){
		int averagePeople=2400; //average people per day based on caf's figures
		int nbPeople; //people coming on a given day and time
		
		String[] days={"monday","tuesday","thursday","friday"};
		long[] hours={28800000,32400000,36000000,39600000,43200000,46800000,50400000,54000000};
		int indexDay=-1;
		int indexHour=-1;
		
		for (int i=0;i<days.length;i++){
			if (days[i]==day)
				indexDay=i;
		}
		
		for (int i=0;i<hours.length;i++){
			if (hours[i]==hour)
				indexHour=i;
		}
		
		nbPeople=(int)(affMatrix[indexDay][indexHour]*averagePeople);
		
		//System.out.println(nbPeople);
		
		return nbPeople;
	}
	
	public int[] getPeopleComingPerHourPerDay(String day,double[][] affMatrix){
		int[] coming={0,0,0,0,0,0,0,0};
		long[] hours={28800000,32400000,36000000,39600000,43200000,46800000,50400000,54000000};
				
		for (int i=0;i<8;i++){
			coming[i]=getRandNbPeoplePerHour(affMatrix,day,hours[i]);
			System.out.print(coming[i]);
			System.out.print(" ");
		}
		
		System.out.print("\n");
		return coming;
	}
	
	
    public static void main(String[] args) {
    	
    	Admin admin=new Admin("CAF",28800000,57600000); // 9h-17h
    	Admin admin=new Admin("CAF Paris 15",28800000,57600000); // 9h-17h
    	admin.toString();
    	
    	
    	/* generate random time*/
		/*final Random random = new Random();
		final int millisInDay = 24*60*60*1000; //24H
		Time time = new Time((long)random.nextInt(millisInDay));
		System.out.println(time.toString());*/
		
		
    	admin.getAffMatrix();
   	
    	double[][] affMatrix=admin.getAffMatrix();
    	//admin.getRandNbPeoplePerHour(affMatrix, "tuesday", 46800000L);
    	admin.getPeopleComingPerHourPerDay("monday",affMatrix);
    	admin.getPeopleComingPerHourPerDay("tuesday",affMatrix);
    	admin.getPeopleComingPerHourPerDay("thursday",affMatrix);
    	admin.getPeopleComingPerHourPerDay("friday",affMatrix);
	}
}

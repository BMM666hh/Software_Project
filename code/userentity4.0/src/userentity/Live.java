package userentity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Live {		 
		private String LiveType;
		private String CoachName;
		private String Limit;  //Who can use this course-User_ability
		private String Goal;   //goal for this exercise-User_target
		private String StartTime;
		private String EndTime;
	
		 public Live( String liveType,String CoachName ,String Limit, String Goal, String startTime, String endTime){
			  setLiveType(liveType);
			  setCoachName(CoachName);
			  setLimit(Limit);
			  setGoal(Goal);
			  setStartTime(startTime);
			  setEndTime(endTime);
		 }
		 
		 public void setLiveType(String type) {
			 this.LiveType = type; 
		 }
		 public String getLiveType( ) {
			 return this.LiveType;
		 }
		 public void setCoachName(String name) {
			 this.CoachName = name; 
		 }
		 public String getCoachName( ) {
			 return this.CoachName;
		 }
		 
		 public void setLimit(String Limit) {
			 this.Limit = Limit;
		 }
		 public String getLimit() {
			 return this.Limit;
		 }
		 
		 public void setGoal(String goal) {
			 this.Goal=goal;
		 }
		 public String getGoal() {
			 return this.Goal;
		 }
		 public String getStartTime() {
			return StartTime;
		}
		public void setStartTime(String startTime) {
			StartTime = startTime;
		}
		public String getEndTime() {
			return EndTime;
		}
		public void setEndTime(String endTime) {
			EndTime = endTime;
		}
		
		 /*create a Live & write into txt information*/
		 public void AddLive(){
		  try {
			   FileWriter frLive =new FileWriter("./LiveInf.txt",true);
			   BufferedWriter buffLive = new BufferedWriter(frLive);
			   System.out.println("----------you have created a new Live!----------");
			   buffLive.write(this.LiveType + "-" + this.CoachName+"-" + this.Limit + "-" + this.Goal+"-" + this.StartTime + "-" + this.EndTime);
			   buffLive.newLine();
			   buffLive.close();
			   frLive.close();
			   
		  }catch(Exception e) {
			   System.out.println("Error create File!!!");
		  }
		 }
		
		 public String toString(){
		  return  "Its type is "+this.LiveType+"its coach is "+this.CoachName+ "please remenber" + this.Limit + " and its goal is: " + this.Goal;
		 }	 
}

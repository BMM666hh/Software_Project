package userentity;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
/*
 * this class record information about a video
 * and write information in to a .txt file
 */
public class Video{
	private String VideoName;
	private String CoachName;
	 private String VideoType;
	 private boolean VIPVideo;
	 private String Limit;  //Who can use this course-User_ability
	 private String Goal;   //goal for this exercise-User_target
	 private double VideoPrice;  //购买视频需要的价格
	 private String VideoPath;      //视频播放路径
 
	 public Video(String name ,String CoachName,String type ,boolean VIPVideo, String Limit, String Goal,double VideoPrice,String VideoPath){
		  setVideoName(name);
		  setVideoType(type);
		  setVIPVideo(VIPVideo);
		  setLimit(Limit);
		  setGoal(Goal);
		  setVideoPrice(VideoPrice);
		  setVideoPath(VideoPath);
	 }
	 

	private String getCoachName() {
		// TODO Auto-generated method stub
		return this.CoachName;
	}


	public void setVideoPrice(double videoPrice) {
		// TODO Auto-generated method stub
		 this.VideoPrice=videoPrice;
		
	}
	 public String getVideoName() {
		 return this.VideoName;
	 }
	 
	 public void setVideoType(String type) {
		 this.VideoType = type; 
	 }
	 public String getVideoType( ) {
		 return this.VideoType;
	 }
	 
	 public void setVIPVideo(boolean VIPVideo) {
		 this.VIPVideo = VIPVideo;
	 }
	 public boolean getVIPVideo() {
		 return this.VIPVideo;
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
	 
	 public double getVideoPrice() {
		 return this.VideoPrice;
	 }
	public void setVideoName(String name) {
		 this.VideoName=name;
	 }
	public void setVideoPath(String videoPath) {
		this.VideoPath=videoPath;
	}
	public String getVideoPath() {
		return this.VideoPath;
	}
	
	
	 
	 /*create a video & write into txt information*/
	 public void writeVideo(){
	  try {
		   FileWriter frVideo =new FileWriter("./videoInf.txt",true);
		   BufferedWriter buffVideo = new BufferedWriter(frVideo);
		   System.out.println("----------you have created a new video!----------");
		   buffVideo.write(this.VideoName + "-" +this.CoachName+"-"+ this.VideoType + "-"
				   			+ this.VIPVideo + "-" + this.Limit + "-" + this.Goal+"-"+this.VideoPrice+"-"+this.VideoPath);
		   buffVideo.newLine();
		   buffVideo.close();
		   frVideo.close();
		   
	  }catch(Exception e) {
		   System.out.println("Error create File!!!");
	  }
	 }
	 
	 
	 public String toString(){
	  return "this is "+this.VideoName+", its coach is "+this.CoachName+", its type is "+this.VideoType 
	    + "is a "+this.VIPVideo+" VIP" + "please remenber" + this.Limit + " and its goal is: " + this.Goal+" its price is: "+this.VideoPrice+" the videoPath "+this.VideoPath;
	 }
 
}
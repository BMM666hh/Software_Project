package userentity;

public class Coach extends Account {
	
	public Coach(String user_name, String Email, String passpword) {
		super(user_name, Email, passpword);
		this.setUserType();
		
		System.out.println("I am a coach hahahahahah!\n");
	}
	public void setUserType(){
		this.UserType="Coach";
	}
	/*
	 * this method is for coach to do live class with the user
	 */
	String teachLive(String liveType ,String Limit, String Goal, String startTime, String endTime){
		
		System.out.println("I am teaching a live class now\n");
		Live aLive = new Live(liveType,this.user_name,Limit,Goal,startTime,endTime); 
		aLive.AddLive();
		return "teach a class";
	}
	

	/*
	  * this method is for coach to upload new video to the video revorded txt file
	  */
	 String upload(String name, String type, boolean flag , String limit, String goal,double videoprice,String videoPath){
		 Video avideo = new Video(name, user_name,type, flag, limit,goal,videoprice,videoPath);
		 avideo.writeVideo();
		 return "up load video";
	 }
	
}
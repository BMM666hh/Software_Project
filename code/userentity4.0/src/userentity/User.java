package userentity;

import java.util.*;
import java.io.*;

public class User extends Account{
	private String schedule = "\0";
	private String liveschedule = "\0";
	
	/*user have a account*/
	private double balance;  //账户余额
	private double discount=1;   //打折情况
	private int VIPlevel=0;//
	private String target = null;//I want to 
	private String ability = null;// I'm old/pregent/normal
	
	public User(String user_name, String Email, String passpword, String target,String ability){
		super(user_name, Email, passpword);
		this.setUserType();
		this.setTarget(target);
		this.setAbility(ability);
		this.setVIPlevel();
	}
	
	public void setAbility(String ability) {
		// TODO Auto-generated method stub
		this.ability = ability;
		
	}
	public String getAbility() {
		return this.ability;
	}
	
	public void setTarget(String target) {
		// TODO Auto-generated method stub
		this.target = target;
	}
	public String getTarget() {
		return this.target;
	}
//呈现选择的课程
	public String getSchedule() {
		 try {
			 //System.out.println(this.user_name);
			 int i=0;
			 FileReader frUserCourse =new FileReader("./"+this.user_name+".txt");
			   
			   BufferedReader buffUserCourse = new BufferedReader(frUserCourse);
			   System.out.println("----------you have read your courses!----------");
			   //buffUserCourse.write(videoInf);
			   String readin="\0";
			   System.out.println("Video name   | Coach name|  VideoTYpe|  Goal|   Price|");
			   while((readin=buffUserCourse.readLine())!=null) {
					  String[] split_vip = readin.split("-");
					  if(!split_vip[0].equals("live"))
					  {
						  schedule += split_vip[0]+"-"+split_vip[1]+"-"+split_vip[2]+"-"+split_vip[5]+"-"+split_vip[6] +"\n";  //!!!!!!!!!!!!!记得打印
						  //System.out.println(split_vip[0]+"    "+split_vip[1]+"   "+split_vip[2]+"   "+split_vip[5]+"   "+split_vip[6]);
						  i++;
					  }
				 }
			   buffUserCourse.close();
			   frUserCourse.close();
		  }catch(Exception e) {
			   System.out.println("Poor people, you haven't buy any courses.");
		  }
		
		return schedule;
	}
	//public void setSchedule(String schedule) {
	//	this.schedule = schedule;
	//}
	public double getBalance() {
		int flag_of_notvip = 0;
		try {
			  FileReader fr = new FileReader("./account.txt");
			  BufferedReader buff = new BufferedReader(fr); 
			  String readin ;
			  while((readin=buff.readLine())!=null) {
				  String[] split_vip = readin.split("-");
				  if(split_vip[0].equals(this.user_name))
				  {
					  readin = split_vip[1];
					  this.balance = Double.parseDouble(readin);
					  //System.out.println("this is a test" + this.VIPlevel);
					  flag_of_notvip++ ;
				  }
			  }
			}catch(Exception e) {
				System.out.println("error user information (balance)!");
			}
		if(flag_of_notvip == 0) {
			System.out.println("you have deposit no money");
		}
		System.out.println("your balabce" + this.balance);
		return this.balance;
	}
	
	public void setUserType(){
		this.UserType="User";
	}
	/*this method is aiming at add new classes schedule to the user schedule*/
	
	
	void printSchedule() {
		System.out.println(schedule);
	}
	
	//this function is aim at read the vip level	
	public void setVIPlevel() {
		int flag_of_notvip = 0;
		try {
			  FileReader fr = new FileReader("./VIPlist.txt");
			  BufferedReader buff = new BufferedReader(fr); 
			  String readin ;
			  while((readin=buff.readLine())!=null) {
				  String[] split_vip = readin.split("-");
				  if(split_vip[0].equals(this.user_name))
				  {
					  readin = split_vip[1];
					  this.VIPlevel = Integer.parseInt(readin);
					  //System.out.println("this is a test" + this.VIPlevel);
				  }
				  else {
					  flag_of_notvip++ ;
				  }
			  }
			}catch(Exception e) {
				System.out.println("error user information!");
			}
		if(flag_of_notvip == 0) {
			System.out.println("you are not a vip yet");
			
		}
		System.out.println("this is the final result" + this.VIPlevel);
	}
	//vip purchase    e^(-month/20) 
	public void setDiscount() {
		this.setVIPlevel();
		int month=this.VIPlevel;
		this.discount = Math.exp(-month/20);
		//System.out.println("the distance is:"+discount);
	}	
	//purchase vip
	public void buyVIP(int mouth){
		
		System.out.print("Are you sure to purchase vip?");
		System.out.print("type how month(using number):");
		 @SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int input=in.nextInt();
		System.out.println("Please pay for: "+input*10);
		Scanner in2= new Scanner(System.in);
		String VIPVerify = in2.next();
		if(VIPVerify.equals("y")) {
			VIPlevel=input;
		}
	}
	
	//娣囶喗鏁奸弬鍥︽娑擄拷鐞涘苯鍞寸�癸拷
	
	public void Modifytxt(String VIPname,int VIPlevel){
		try {
			FileWriter frw = new FileWriter("./VIPlist.txt",true);
			BufferedWriter buffW = new BufferedWriter(frw);
			buffW.write(VIPname+"-"+VIPlevel);
			buffW.newLine();
			buffW.close();
			frw.close();
			}catch(Exception e) {
				System.out.println("error watch video information!");
			}
	
	}
	
	
	/*these methods are aiming at account money*/
	public void deposit(double amount){
		//写入用户文本
		balance = getBalance()+ amount;
		try {
			FileWriter fru = new FileWriter("./account.txt",true);
			BufferedWriter buffU = new BufferedWriter(fru);
			buffU.write(this.user_name+"-"+balance);
			buffU.newLine();
			buffU.close();
			fru.close();
			}catch(Exception e) {
				System.out.println("error watch video information!");
			}
		//balance = balance + amount;
		System.out.println("you are about to deposit" + amount +"$\n");
		System.out.println("before buy you now have" + balance +"$\n");
	}
	
	//buy courses
	public void purchase(String videoName) {
		setDiscount();
		String videoInf=VideoInfor(videoName);
		String[] split_video = videoInf.split("-");
		double amount=Double.parseDouble(split_video[6]);
		double amount_temp = amount*this.discount;
		double balance_temp = balance - amount_temp;
		
		System.out.print(amount_temp);
		if (balance_temp < 0) {
			 System.out.print("exit withdraw.");
		}else {
			System.out.print("Are you sure to purchase a "+amount+"$ class with discount "+this.discount+" off, your balabce will be"+ balance_temp );
			System.out.print("type y for yes, n for no:");
			 @SuppressWarnings("resource")
			Scanner in=new Scanner(System.in);
			 String input=in.next();
			if(split_video[0].equals(videoName)){
				input="n";
			}
			 if (input.equals("y")) {
				 try {
					   FileWriter frUserCourse =new FileWriter("./"+this.user_name+".txt",true);
					   BufferedWriter buffUserCourse = new BufferedWriter(frUserCourse);
					   System.out.println("----------you have created a new video!----------");
					   buffUserCourse.write(videoInf);
					   buffUserCourse.newLine();
					   buffUserCourse.close();
					   frUserCourse.close();
				  }catch(Exception e) {
					   System.out.println("Error create File!!!");
				  }
				System.out.print("\n Sussess! you are going to spend "+amount_temp+
						"$ from your account");
				balance = balance_temp;
				try {
					FileWriter fru = new FileWriter("./account.txt",true);
					BufferedWriter buffU = new BufferedWriter(fru);
					buffU.write(this.user_name+"-"+balance);
					buffU.newLine();
					buffU.close();
					fru.close();
				}catch(Exception e) {
					System.out.println("can't write balance in");
				}
			 }
			 else {
				 System.out.print("You have bought this course!");
			 }		
		}
	}
	//look at all courses
	void readVideoList(){
		if (VIPlevel == 0) {
		  try {
			    FileReader fr = new FileReader("./videoInf.txt");
			    BufferedReader buffR = new BufferedReader(fr); 
			    String video;
			    while((video = buffR.readLine())!=null) {
			    	String[] split_video = video.split("-");
			    	//System.out.println(split_video[3].equals(this.ability) + split_video[3] + this.ability);
			    	if(split_video[2].equals("false") && split_video[3].equals(this.ability)) {
			    		//System.out.println("enter if" + split_video[3].equals(this.ability));
			    		System.out.println(" 读用户可以看的所有视频\n"+split_video[0]+"    "+split_video[1]+"   "+split_video[2]+"   "+split_video[5]+"   "+split_video[6]);
			    }
		    }
		  }catch(Exception e) {
			  System.out.println("exception: error watch video information!");
		  }
		}else {
			try {
			    FileReader fr = new FileReader("./videoInf.txt");
			    BufferedReader buffR = new BufferedReader(fr); 
			    String video;
			    while((video = buffR.readLine())!=null) {
			    	String[] split_video = video.split("-");
			    	if(split_video[3].equals(this.ability)) {
			    			System.out.println(split_video[0] + " is a " + split_video[1]
			    			+ " ; It is VIP:" + split_video[2] + "type" + split_video[3] );
			    }
		    }
		  }catch(Exception e) {
			  System.out.println("exception: error watch video information!");
		  }
		}
	}
	
	//look up for course you want by using videoName
		 public String VideoInfor(String videoName) {
			 String inf=null;
			 try {
				    FileReader fr = new FileReader("./videoInf.txt");
				    BufferedReader buffR = new BufferedReader(fr); 
				    String video;
				    while((video = buffR.readLine())!=null) {
				    	String[] split_video = video.split("-");
				    	if(split_video[0].equals(videoName)) {
				    		System.out.println("name:"+split_video[0] + " type:" + split_video[1]
				    			+ " ; It is VIP:" + split_video[2] + " limit:" + split_video[3]+" goal:" + split_video[4]+" price:"+split_video[5] );
				    		inf=video;
				    }
			    }
			  }catch(Exception e) {
				  System.out.println("exception: error watch video information!");
				  inf="0";    //不存在视频？？
			  }
			 return inf;
		 }
		 
	//choose live course
		 public void chooseLive(String coachname, String day , String time){
			 if(this.VIPlevel==0) {
				 System.out.println("You cann't join live!");
			 }
			 else {
				  System.out.println("youncan choose");
				  try {
					   FileWriter frUserCourse =new FileWriter("./"+this.user_name+".txt",true);
					   BufferedWriter buffUserCourse = new BufferedWriter(frUserCourse);
					   System.out.println("----------you have created a new video!----------");
					   buffUserCourse.newLine();
					   buffUserCourse.write("live" +"-"+ coachname +"-"+ day +"-"+ time);
					   buffUserCourse.close();
					   frUserCourse.close();
				  }catch(Exception e) {
					   System.out.println("Error create File!!!");
				  }
			 }
		 }
		 
		 public String checkIdelLive() {
			 try {
				 //System.out.println(this.user_name);
				 FileReader frUserLive =new FileReader("./LiveInf.txt");
				   
				   BufferedReader buffUserLive = new BufferedReader(frUserLive);
				   System.out.println("----------you have read your courses!----------");
				   String readin="\0";
				   int i=0;
				   while((readin=buffUserLive.readLine())!=null) {
						  String[] split_live = readin.split("-");
						 if(split_live[0].equals("live"))
						  {
							 liveschedule+=readin + ";";      // 打印！！！！！！！！
							 System.out.println(split_live[0]+"    "+split_live[1]+"   "+split_live[2]+"   "+split_live[3]);
						  }
					 }
				   buffUserLive.close();
				   frUserLive.close();
			  }catch(Exception e) {
				   System.out.println("Poor people, you haven't buy any courses.");
			  }
			
			return liveschedule;
		}
		 
		 public String printlive() {
			 try {
				 //System.out.println(this.user_name);
				 FileReader frUserCourse =new FileReader("./"+this.user_name+".txt");
				   
				   BufferedReader buffUserCourse = new BufferedReader(frUserCourse);
				   System.out.println("----------you have read your courses!----------");
				   String readin="\0";
				   int i=0;
				   while((readin=buffUserCourse.readLine())!=null) {
						  String[] split_live = readin.split("-");
						 if(split_live[0].equals("live"))
						  {
							 liveschedule+=readin + ";";      // 打印！！！！！！！！
							 System.out.println(split_live[0]+"    "+split_live[1]+"   "+split_live[2]+"   "+split_live[3]);
						  }
					 }
				   buffUserCourse.close();
				   frUserCourse.close();
			  }catch(Exception e) {
				   System.out.println("Poor people, you haven't buy any courses.");
			  }
			
			return liveschedule;
		}
		 
	public String toString() {
		return this.user_name + "-" + this.Email + "-" + this.password + "-" + this.UserType + "-" + this.target + "-" + this.ability;
	}
	
}

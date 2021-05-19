
package userentity;

import java.io.*;

abstract class Account {
	
	protected String user_name;
	protected String Email;
	protected String password;
	protected String UserType;
	
	
	public Account() {}
	
	public Account(String user_name, String Email, String password) {
		this.user_name = user_name;
		this.Email = Email;
		this.password = password;
	}
	
	/*this method is aiming at testing the validation of our email*/
	boolean test_Mail() {
		String email = this.Email;
		boolean flag = false;
		System.out.print("  "+email);
		if(email.contains("@")&&email.contains(".")) {
			System.out.print("for '.' is "+email.lastIndexOf(".")+"    for '@' is"+email.lastIndexOf("@"));
			if(email.lastIndexOf(".")>email.lastIndexOf("@")+2) {
				System.out.println("correct email");
				flag = true;
			}
			else {
				System.out.println("wrong email");
				flag = false;
			}
		}
		else {
			System.out.println("error for if");
		}
		return flag;
	}
	
	boolean test_Password() {
		String password = this.password;
		boolean flag = false;
		//System.out.print("  "+password);
		if(!password.contains("-")) {
				flag = true;
			}
	    else {
				System.out.println("wrong password! No '-' ");
				flag = false;
			}
		return flag;
	}

	void readVideoList(){
		try {
		  FileReader fr = new FileReader("./videoInf.txt");
		  BufferedReader buffR = new BufferedReader(fr); 
		  String video;
		  //System.out.println(video);
		  while((video=buffR.readLine())!=null) {
			  //System.out.println(video);
			  String[] split_video = video.split("-");
			  if(split_video[2].equals("false"))
			  {
			      System.out.println(split_video[0]+" is a "+split_video[1]+" ; It is VIP:"+split_video[2]);
			  }
			  else {
				  System.out.println("This video is vip, you have no money, please deposit!");
			  }
		  }
		}catch(Exception e) {
			System.out.println("error watch video information!");
		}
	 }
	
		 /*这个函数应该能将用户信息写入文档*/
		 void writeID(){
		    try {
		     FileWriter fr = new FileWriter("./Theuser.txt",true);
		     BufferedWriter buf = new BufferedWriter(fr);
		     //fr.open()
		    // System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		    //System.out.println(this.user_name+ this.Email + this.password+this.UserType);
		     buf.write(this.toString());
		     buf.newLine();
		     buf.close();
		     fr.close();
		    }
		    catch(Exception e) {
		     System.out.println("error!!!");
		    }
		 }
		 public String toString() {
			 return this.user_name + "-" + this.Email + "-" + this.password + "-"+this.UserType;
		 }
	
}

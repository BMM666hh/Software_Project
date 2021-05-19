package userentity;

import java.io.BufferedReader;
import java.io.FileReader;

public class Manager extends Account{
	public Manager(String user_name, String Email, String passpword) {
		super(user_name, Email, passpword);
		this.setUserType();
		
		System.out.println("I am a manager hahahahahah!");
	}
	public void setUserType(){
		this.UserType="Manager";
	}
	
	void readInfo(String CheckName) {
		try {
			  FileReader fr = new FileReader("./Theuser.txt");
			  BufferedReader buffR = new BufferedReader(fr); 
			  String userInfor;
			  //System.out.println(video);
			  while((userInfor=buffR.readLine())!=null) {
				  //System.out.println(video);
				  String[] split_user = userInfor.split("-");
				  if(split_user[0].equals(CheckName))
				  {
				      System.out.println("Name: "+split_user[0]+"\nEmail: "+split_user[1]+"\npassword: "+split_user[2]);
				  }
				  else {
					  System.out.println("It doesn't exits!");
				  }
			  }
			}catch(Exception e) {
				System.out.println("error user information!");
			}
	}
		
}

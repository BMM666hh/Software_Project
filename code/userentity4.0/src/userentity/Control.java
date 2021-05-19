package userentity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Control {
	//private boolean isCreate;
	protected Account new_regist;
	
	public Control() {
	}
	
	public String signUp (String newUsername,String newUserMail,String newPassword,String newUserType, String target, String ability){
		boolean ctrl_flag= test_ControlMail(newUserMail)== false||test_ControlPassword(newPassword)== false||newUserMail == null || newUserType == null ||newUsername==null;
		if(ctrl_flag) {
			System.out.println("Wrong information");
			if(test_ControlMail(newUserMail)== false) {
				return "0" + "Wrong e-mail.";
			}
			else if(test_ControlPassword(newPassword)== false) {
				return "0" + "Wrong password.";
			}
			else{
				return "0" + "Missing key information. ";
			}
		}
		else {
			System.out.print("enteer if");
			if(newUserType.equals("User")) {
				new_regist = new User(newUsername,newUserMail ,newPassword,target,ability);
				System.out.println(new_regist.Email+"----"+new_regist.password+"-------"+ new_regist.user_name);	
			}
			else if(newUserType.equals("Manager")){
				new_regist = new Manager(newUserMail ,newUserType ,newUsername );
				System.out.println("Manager");
			}
			else {
				new_regist = new Coach(newUserMail ,newUserType ,newUsername );
				System.out.println("Coach");
			}
		
			//System.out.println("----"+new_regist.test_Mail());
			new_regist.writeID();
			return "1" + "Wellcome to london gym" ;
		}
	}
	
	
	public boolean test_ControlMail(String email) {
		boolean flag = false;
		if(email.contains("@")&&email.contains(".")) {
			if(email.lastIndexOf(".")>email.lastIndexOf("@")+2) {
				//System.out.println("correct email");
				flag = true;
			}
			else {
				//System.out.println("wrong email");
				flag = false;
			}
		}
		else {
			System.out.println("error for if");
		}
		return flag;
	}
	
	public boolean test_ControlPassword(String testPassword){
		String password = testPassword;
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
	
	
	//check user exsitence
	String signIn(String CheckName,String CheckPassword,String CheckUserType) {
		String ctrl_flag = "/0";
		try {
			  FileReader fr = new FileReader("./Theuser.txt");
			  BufferedReader buffR = new BufferedReader(fr); 
			  String userInfor;
			  boolean flag=false;
			  while((userInfor=buffR.readLine())!=null) {
				  String[] split_user = userInfor.split("-");
				  if(split_user[0].equals(CheckName))
				  {
					  flag=true;
					  if(split_user[2].equals(CheckPassword)&&split_user[3].contentEquals(CheckUserType)) {
						  
						  System.out.println("Name: "+ split_user[0]+"\nEmail: "+ split_user[1]+"\npassword: "+ split_user[2]);
						  if(CheckUserType.equals("User")) {
								new_regist = new User(split_user[0], split_user[1], split_user[2], split_user[4], split_user[5]);
								System.out.println(new_regist.Email+"----"+new_regist.password+"-------"+ new_regist.user_name);	
							}
							else if(CheckUserType.equals("Manager")){
								new_regist = new Manager(split_user[0], split_user[1], split_user[2]);
								System.out.println("Manager");
							}
							else {
								new_regist = new Coach(split_user[0], split_user[1], split_user[2]);
								System.out.println("Coach");
							}
					  }
					  else {
						  System.out.println("error password or type!");
					  }
					  break;
				  }
			  }
			  if(!flag) {
				  System.out.println("you are not yet a user, please signup");
				  ctrl_flag = "0" + "do not exist";
			  }else {
				  ctrl_flag = "1" + "correct";
			  }
			}
		catch(Exception e) {
				System.out.println("exception");
			}
		return ctrl_flag ; 
	}
	
///////////
	public static void main(String args[]) {
		Control CTRL = new Control();
		CTRL.signUp("zzq","zzq@qq.com","1-2345","User","lose weight","old");
		//CTRL.signIn("ddd","123456","User");
		//CTRL.signIn("Manager1","111111","Manager");
		//CTRL.signIn("zzq","123456","User");
		//CTRL.signIn("zzq","12345","Use");
		//CTRL.signIn("bzm","12345","User");
		System.out.println("////////////////////////////////////");
		//System.out.println(CTRL.new_regist.toString());
		
		
		
		
	}
}
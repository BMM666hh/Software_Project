package userentity;

import java.io.IOException;

public class test {
	  public static void main(String[] args) throws IOException {
		  
		User m =new User("ddd","xxx@bupt.edu","123456","gogogo", "pregnancy");	
		m.chooseLive("coachname","weekend","10dian");
		System.out.println("______________________________________Scheldu____________________________________");
		System.out.println(m.getSchedule());
		System.out.println("______________________________________Live____________________________________");
		System.out.println(m.getlive());
		
		//m.writeID();
		//m.deposit(55);
		//m.getBalance();
		
		//m.purchase("20210506_yoga02");
		//System.out.println("\n------------------------------print schedule");
		//m.getSchedule();
		//m.getBalance();
		
		
		//m.Modifytxt("ddd", 76);
		//m.Modifytxt("aaa", 7);
		//m.setVIPlevel();
		//m.readVideoList();
		//User m2 =new User("zhouziqi","xxx@bupt.edu","123456","gogogo", "pregnancy");
		//m2.setVIPlevel();
		//m2.readVideoList();
		  //Coach acoach=new Coach("bCoach","1123@qq.com","111111");
		  //acoach.teachLive("yoga","old","running","2021/5/1/12","2021/5/1/13");
		  //acoach.writeID();
		  
		 //Manager a=new Manager("Manager1","1123@qq.com","111111");
		  //acoach.teachLive("yoga","old","running","2021/5/1/12","2021/5/1/13");
		 // a.writeID();
		  
		 //User m =new User("ddd","xxx@bupt.edu","123456","gogogo", "pregnancy");	
		//m.writeID();
	  }
}

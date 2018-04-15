import java.util.*;
public class RegisteredUser extends Users{
int userid;
String password;

public RegisteredUser(String name, String contact_no,String email,int userid,String password) {
	super(name, contact_no, email);
	this.userid = userid;
	this.password=password;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}
public void menu() {
	while(true) {
		int flag=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("Choose from the following options: ");
	System.out.println("1. Call");
	System.out.println("2. Email");
	System.out.println("3. Live Chat");
	System.out.println("4. Video Call");
	System.out.println("5. Forums");
	System.out.println("6. Feedback");
	System.out.println("7. Documentation");
	System.out.println("8. Report Bug");
	System.out.println("9. Request Technician");
	System.out.println("10. Check Account History");
	System.out.println("11. Log Out");
	int option=sc.nextInt();
	sc.nextLine();
	switch(option) {
	case 1: CallAndEmail ob=new CallAndEmail();
			Service s2=ob.call(this.userid);
			if(s2!=null) {
			System.out.println("Was your issue solved(solved/pending)");
			String result=sc.nextLine();
			s2.status=result;
			s2.view();
			}
			break;
	case 2: CallAndEmail ob1=new CallAndEmail();
			ob1.email(this.userid);
			break;
	
	case 3: Chat lc=new Chat();
			Service s=lc.liveChat(this.userid);
			if(s!=null) {
			System.out.println("Was your issue solved(solved/pending)");
			String res=sc.nextLine();
			s.status=res;
			s.view();
			}
			break;
	case 4: Chat lc1=new Chat();
			Service s1=lc1.videoCall(this.userid);
			if(s1!=null) {
			System.out.println("Was your issue solved(solved/pending)");
			String res=sc.nextLine();
			s1.status=res;
			s1.view();
			}
			break;
	case 5: Forums f=new Forums();
			System.out.println("Enter product category: ");
			String pro=sc.nextLine();
			while(true) {
			System.out.println("What do you want to do: ");
			System.out.println("1. Post Query");
			System.out.println("2. Read Post");
			System.out.println("3. Answer Query");
			System.out.println("4. Quit this Forum");
			int te=sc.nextInt();
			sc.nextLine();
			if(te==1) {
				System.out.println("Enter query: ");
				String query = sc.nextLine();
				f.postQuery(pro, query);
				System.out.println("Your query has been posted");
				//System.out.println("Post ID: "+f.forumPostID);
			}
			else if(te==2) {
				f.readForums(pro);
			}
			else if(te==3) {
				System.out.println("Enter forum post ID to answer: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("Submit your answer: ");
				String answer = sc.nextLine();
				f.answerQuery(id, answer);
				System.out.println("Your answer has been submitted");
			}
			else if(te==4) {
				break;
			}
			else {
				System.out.println("Wrong input");
			}
			}
			break;
	case 6:Feedback fd=new Feedback();
			String feedback;
			System.out.println("Enter your feedback: ");
			feedback=sc.nextLine();
			fd.write(feedback);
			DataStore.feed.add(fd);
			break;
	case 7: Documentation doc=new Documentation(0, "0", "0");
			System.out.println("Specify product category: ");
			String category = sc.nextLine();
			doc.read(category);
			break;
	case 8: ReportBug rb=new ReportBug();
			rb.reportBug();
			DataStore.RB.add(rb);
	case 9: System.out.println("Specify Product Category");
			String product=sc.nextLine();
			Technician tech=new Technician(0,"0","0","0",true);
			tech.requestTechnician(this.userid,product);
			break;
	case 10: AccountHistory ac=new AccountHistory();
			ac.generateAccountHistory(this.userid);
			break;
	case 11: flag=1;
			break;
	default: System.out.println("Enter Correct choice");
	}
	if(flag==1) {
		break;
	}
	
}
	
}
}

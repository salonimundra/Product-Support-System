import java.util.*;
public class Users {
String name;
String contact_no;
String email_address;

public String getName() {
	return name;
}
public Users(String name, String contact_no, String email_address) {
	this.name = name;
	this.contact_no = contact_no;
	this.email_address = email_address;
}
public void setName(String name) {
	this.name = name;
}
public String getContact_no() {
	return contact_no;
}
public void setContact_no(String contact_no) {
	this.contact_no = contact_no;
}
public String getEmail_address() {
	return email_address;
}
public void setEmail_address(String email_address) {
	this.email_address = email_address;
}
public static boolean authenticate(int userID,String password){

	for (int x=0; x<DataStore.Reguser.size(); x++) {
		//1System.out.println(DataStore.Reguser.get(x).userid+" "+DataStore.Reguser.get(x).password);
		if(DataStore.Reguser.get(x).userid==userID && DataStore.Reguser.get(x).password.equals(password)) {
			DataStore.Reguser.get(x).menu();
			return true;
		}
	    
	}

	return false;
}
public static void main(String args[]) {
	//Filling up data
	RegisteredUser r1=new RegisteredUser("Ravi Patel","9898234567","ravipatel@gmail.com",123,"ravi");
	RegisteredUser r2=new RegisteredUser("Sneha Patel","9898982467","snehapatel@gmail.com",124,"sneha");
	RegisteredUser r3=new RegisteredUser("Bharat Agarwal","8992345111","bharatagarwal@gmail.com",125,"bharat");
	//DataStore d=new DataStore();
	DataStore.Reguser.add(r1);
	DataStore.Reguser.add(r2);
	DataStore.Reguser.add(r3);
	
	SupportProvider s1=new SupportProvider(111,"Shreya Kothari",true);
	SupportProvider s2=new SupportProvider(112,"Rahul Tiwari",false);
	SupportProvider s3=new SupportProvider(113,"Shanaya Goswami",true);
	
	DataStore.SP.add(s1);
	DataStore.SP.add(s2);
	DataStore.SP.add(s3);
	Technician t1 = new Technician(101, "Smit Shah", "Laptop", "9867196859", true);
	Technician t2 = new Technician(102, "Sahil Kumar", "Air Conditioner", "9751869684", true);
	Technician t3 = new Technician(103, "Riya Somani", "Telivision", "9594616859", true);
	Technician t4 = new Technician(104, "Sameera Soni", "Refrigerator", "9346475259", true);
	Technician t5 = new Technician(105, "Praful Patel", "Washing Machine", "9991234999", true);
	DataStore.tech.add(t1);
	DataStore.tech.add(t2);
	DataStore.tech.add(t3);
	DataStore.tech.add(t4);
	DataStore.tech.add(t5);
	
	SupportManager sm1=new SupportManager(111,"Mehul Patel");
	SupportManager sm2=new SupportManager(112,"Shanaya Sharma");
	DataStore.SM.add(sm1);
	DataStore.SM.add(sm2);
	Documentation d1 = new Documentation(1, "Laptop", "Laptop Documentation 1");
	Documentation d2 = new Documentation(2, "Laptop", "Laptop Documentation 2");
	Documentation d3 = new Documentation(3, "Washing Machine", "Washing Machine Documentation 1");
	Documentation d4 = new Documentation(4, "Refrigerator", "Refrigerator Documentation");
	Documentation d5 = new Documentation(5, "AC", "AC Documentation 1");
	Documentation d6 = new Documentation(6, "Washing Machine", "Washing Machine Documentation 2");
	Documentation d7 = new Documentation(7, "AC", "AC Documentation 2");
	Documentation d8 = new Documentation(8, "Washing Machine", "Washing Machine Documentation 3");
	
	DataStore.doc.add(d1);
	DataStore.doc.add(d2);
	DataStore.doc.add(d3);
	DataStore.doc.add(d4);
	DataStore.doc.add(d5);
	DataStore.doc.add(d6);
	DataStore.doc.add(d7);
	DataStore.doc.add(d8);
	
	while(true) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Select your category: ");
	System.out.println("1. Registered User");
	System.out.println("2. Guest User");
	System.out.println("3. Support Manager");
	System.out.println("4. Support Provider");
	System.out.println("Press 5 to exit the system");
	int t=sc.nextInt();
	sc.nextLine();
	if(t==1) {
	System.out.println("Enter user ID : ");
	int userID=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter password: ");
	String password=sc.nextLine();
	boolean result= authenticate(userID,password);
	if(result==true) {
		
	}
	else {
		System.out.println("Wrong userID or password");
		System.out.println("Press 1 to try again and 2 to exit");
		int test=sc.nextInt();
		if(test==2) {
			break;
		}
		else {
			continue;
		}
	}
	}
	else if(t==2){
		UnregisteredUser u=new UnregisteredUser("0","0","0");
		u.menu();
	}
	else if(t==3) {
		System.out.println("Enter your Employee ID: ");
		int id=sc.nextInt();
		sc.nextLine();
		//System.out.println("Enter your Employee ID: ");
		for(int i=0;i<DataStore.SM.size();i++) {
			if(DataStore.SM.get(i).id==id) {
				DataStore.SM.get(i).menu();
				break;
			}
		}
	}
	else if(t==4) {
		System.out.println("Enter your Employee ID: ");
		int id=sc.nextInt();
		sc.nextLine();
		//System.out.println("Enter your Employee ID: ");
		for(int i=0;i<DataStore.SP.size();i++) {
			if(DataStore.SP.get(i).id==id) {
				DataStore.SP.get(i).menu();
				break;
			}
		}
	}
	else {
		break;
	}
	}
	System.out.println("Thank you for using our portal");
}

}

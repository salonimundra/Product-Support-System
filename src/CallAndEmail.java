import java.util.*;
public class CallAndEmail {
String serviceType;

public String getServiceType() {
	return serviceType;
}

public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}
public Service call(int userID) {
	System.out.println("Call placed to support provider");
	SupportProvider dummy=new SupportProvider(0,"0",false);
	SupportProvider s=dummy.acceptServiceRequest();
	
	if(s!=null) {
		Service se=new Service();
		se.generateServiceId();
		se.userID=userID;
		se.providerID=s.id;
		//s.status=false;
		se.serviceType="call";
		DataStore.ser.add(se);
		//se.view();
		return se;
	}
	else {
		System.out.println("All support providers are currently busy");
		return null;
	}
}
public Service call() {
	System.out.println("Call placed to support provider");
	SupportProvider dummy=new SupportProvider(0,"0",false);
	SupportProvider s=dummy.acceptServiceRequest();
	
	if(s!=null) {
		Service se=new Service();
		se.generateServiceId();
		se.userID=0;
		se.providerID=s.id;
		//s.status=false;
		se.serviceType="call";
		DataStore.ser.add(se);
		//se.view();
		return se;
		
	}
	else {
		System.out.println("All support providers are currently busy");
		return null;
	}
}
public void email(int userID) {
	System.out.println("Write the body of email: ");
	Scanner sc=new Scanner(System.in);
	String em=sc.nextLine();
	System.out.println("Email sent");
	Service se=new Service();
	se.generateServiceId();
	se.userID=userID;
	se.providerID=0;
	//s.status=false;
	se.serviceType="email";
	DataStore.ser.add(se);
	//se.view();
}
public void email() {
	System.out.println("Write the body of email: ");
	Scanner sc=new Scanner(System.in);
	String em=sc.nextLine();
	System.out.println("Email sent");
	Service se=new Service();
	se.generateServiceId();
	se.userID=0;
	se.providerID=0;
	//s.status=false;
	se.serviceType="email";
	DataStore.ser.add(se);
	//se.view();
}
}


public class Service {
	static int count=1;
int serviceID;
int providerID;
int userID;
String serviceType;
String status;
public void view() {
	System.out.println("user ID: "+userID);
	System.out.println("service ID: "+serviceID);
	System.out.println("provider ID: "+providerID);
	System.out.println("service type: "+serviceType);
	System.out.println("Status: "+status);
}
public void update(String type) {
status=type;
}
public void generateServiceId() {
this.serviceID=count;
count++;
}
}


public class Technician {
int techID;
String name;
String productCategory;
String contactNo;
boolean availabilityStatus;
public Technician(int techID, String name, String productCategory, String contactNo, boolean availabilityStatus) {
	super();
	this.techID = techID;
	this.name = name;
	this.productCategory = productCategory;
	this.contactNo = contactNo;
	this.availabilityStatus = availabilityStatus;
}
public boolean checkAvailability(int userID,String product) {
	for (int x=0; x<DataStore.tech.size(); x++) {
		//1System.out.println(DataStore.Reguser.get(x).userid+" "+DataStore.Reguser.get(x).password);
		if(DataStore.tech.get(x).productCategory.equals(product) && DataStore.tech.get(x).availabilityStatus==true) {
			
			assignTechnician(DataStore.tech.get(x),userID);
			return true;
		}
	}
	return false;
}
public void assignTechnician(Technician t,int userID) {
	Service se=new Service();
	se.generateServiceId();
	se.userID=userID;
	se.providerID=t.techID;
	//s.status=false;
	t.availabilityStatus=false;
	se.serviceType="requested technician";
	se.status="pending";
	DataStore.ser.add(se);
	//se.view();
	System.out.println("Service id: "+se.serviceID);
	System.out.println("Technician Name: "+t.name);
	System.out.println("Technician contact number: "+t.contactNo);
}
	
public void requestTechnician(int userID,String product) {
	if(checkAvailability(userID,product)) {
		
	}
	else {
		System.out.println("No technicians available");
	}
}

}


public class Chat {
String serviceType;

public String getServiceType() {
	return serviceType;
}

public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}
public Service liveChat(int userID) {
	
	ClientGui client = new ClientGui();
	return start(userID,"livechat");
	
}
public Service videoCall(int userID) {
	return start(userID,"videocall");
}
public Service start(int userID,String type) {
	SupportProvider dummy=new SupportProvider(0,"0",false);
	SupportProvider s=dummy.acceptServiceRequest();
	
	if(s!=null) {
		Service se=new Service();
		se.generateServiceId();
		se.userID=userID;
		se.providerID=s.id;
		//se.status="solved";
		se.serviceType=type;
		if(type.equals("livechat")) {
		ClientGui client = new ClientGui();
		}
		DataStore.ser.add(se);
		//se.view();
		return se;
	}
	else {
		System.out.println("All support providers are currently busy");
		return null;
	}
}
public void end() {
	//s.status=true;
}
}

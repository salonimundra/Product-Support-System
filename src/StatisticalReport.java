import java.sql.Timestamp;

public class StatisticalReport {
static int count=1;
int reportID;
Timestamp timestamp;
public void generateReport() {
	reportID=count;
	count++;
	timestamp = new Timestamp(System.currentTimeMillis());;
	System.out.println("----------------------------------------------------");
	System.out.println("Report ID: "+reportID);
	System.out.println("Timestamp: "+timestamp );
	System.out.println("Number of Services generated: "+DataStore.ser.size());
	int noOfcalls=0,noOfemails=0,noOfLiveChats=0,noOfVideoCalls=0,noOfTechReq=0;
	for(int i=0;i<DataStore.ser.size();i++) {
		if(DataStore.ser.get(i).serviceType.equals("call")) {
			noOfcalls++;
		}
		else if(DataStore.ser.get(i).serviceType.equals("email")) {
			noOfemails++;
		}
		else if(DataStore.ser.get(i).serviceType.equals("livechat")) {
			noOfLiveChats++;
		}
		else if(DataStore.ser.get(i).serviceType.equals("videocall")) {
			noOfVideoCalls++;
		}
		else if(DataStore.ser.get(i).serviceType.equals("requested technician")) {
			noOfTechReq++;
		}
	}
	System.out.println("Total number of calls: "+noOfcalls);
	System.out.println("Total number of emails: "+noOfemails);
	System.out.println("Total number of live chats: "+noOfLiveChats);
	System.out.println("Total number of video calls: "+noOfVideoCalls);
	System.out.println("Total number of requests for technician: "+noOfTechReq);
	System.out.println("----------------------------------------------------");
}
}

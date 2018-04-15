import java.util.Scanner;

public class SupportProvider extends SupportTeam{
boolean status;

public SupportProvider(int id, String name,boolean status) {
	super(id, name);
	this.status=status;
	// TODO Auto-generated constructor stub
}
public SupportProvider acceptServiceRequest() {
	SupportProvider s=null;
	for (int x=0; x<DataStore.SP.size(); x++) {
		//1System.out.println(DataStore.Reguser.get(x).userid+" "+DataStore.Reguser.get(x).password);
		if(DataStore.SP.get(x).status) {
			return DataStore.SP.get(x);
			
		}
}
	return s;
}
public void menu() {
	while(true) {
		int flag=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose from the following options: ");
		System.out.println("1. Update Forums");
		System.out.println("2. Update Documentation");
		System.out.println("3. Read Bug Reports");
		System.out.println("4. Update Bug Status");
		System.out.println("5. Update Sevice Status");
		System.out.println("6. Read All Feedbacks");
		System.out.println("7. Update Technician Status");
		System.out.println("8. Log Out");
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		case 1: Forums f=new Forums();
				f.update();
				break;
		case 2: Documentation d=new Documentation();
				d.update();
				break;
		case 3: for(int i=0;i<DataStore.RB.size();i++) {
				DataStore.RB.get(i).read();
		}
				break;
		case 4: System.out.println("Enter bug ID: ");
				int id=sc.nextInt();
				sc.nextLine();
				int re=0;
				for(int i=0;i<DataStore.RB.size();i++) {
					if(DataStore.RB.get(i).bID==id) {
						DataStore.RB.get(i).updateBugStatus();
						re=1;
						break;
					}
			}
				if(re==0) {
					System.out.println("Wrong Bug ID");
				}
				break;
		case 5: System.out.println("Enter service ID: ");
				int id1=sc.nextInt();
				sc.nextLine();
				int fe=0;
				for(int i=0;i<DataStore.ser.size();i++) {
					if(DataStore.ser.get(i).serviceID==id1) {
						DataStore.ser.get(i).view();
						System.out.println("Solved or Unsolved");
						String y=sc.nextLine();
						DataStore.ser.get(i).update(y);
						fe=1;
						break;
					}
				}
				if(fe==0) {
					System.out.println("Wrong service ID");
				}
				break;
		case 6: for(int i=0;i<DataStore.feed.size();i++) {
				System.out.println("---------------------------------------------");
				System.out.println("Feedback ID: "+DataStore.feed.get(i).getFeedbackID());
				System.out.println("Feedback: "+DataStore.feed.get(i).getFeedback());
				System.out.println("---------------------------------------------");
				}
				break;
		case 7: System.out.println("Enter Technician ID: ");
				int idl=sc.nextInt();
				sc.nextLine();
				int fla=0;
				for(int i=0;i<DataStore.tech.size();i++) {
					if(DataStore.tech.get(i).techID==idl) {
						
						DataStore.tech.get(i).availabilityStatus=true;
						System.out.println("Techician "+idl+" available now");
						fla=1;
						break;
					}
			}
				if(fla==0) {
					System.out.println("Wrong technician ID");
				}
				break;
		case 8: flag=1;
				break;
		default: System.out.println("Wrong Input");
		}
		if(flag==1)
			break;
	}
}
}

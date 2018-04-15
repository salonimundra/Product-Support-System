import java.util.*;
public class UnregisteredUser extends Users{

	public UnregisteredUser(String name, String contact_no, String email_address) {
		super(name, contact_no, email_address);
		// TODO Auto-generated constructor stub
	}
	public void menu() {
		System.out.println("Choose from the following options: ");
		System.out.println("1. Call");
		System.out.println("2. Email");
		System.out.println("3. Forums");
		System.out.println("4. Feedback");
		System.out.println("5. Documentation");
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		sc.nextLine();
		switch(option) {
		case 1: CallAndEmail ob=new CallAndEmail();
				Service s2=ob.call();
				if(s2!=null) {
				System.out.println("Was your issue solved(solved/pending)");
				String result=sc.nextLine();
				s2.status=result;
				//s2.view();
				System.out.println("service ID: "+s2.serviceID);
				System.out.println("provider ID: "+s2.providerID);
				System.out.println("service type: "+s2.serviceType);
				System.out.println("Status: "+s2.status);
				}
				break;
		case 2: CallAndEmail ob1=new CallAndEmail();
				ob1.email();
				break;
		
		
		case 3: Forums f=new Forums();
				System.out.println("Enter product category: ");
				String pro=sc.nextLine();
				f.readForums(pro);
				break;
		case 4:Feedback fd=new Feedback();
				String feedback;
				System.out.println("Enter your feedback: ");
				feedback=sc.nextLine();
				fd.write(feedback);
				DataStore.feed.add(fd);
				break;
		case 5: Documentation doc = new Documentation(0, "0", "0");
				System.out.println("Specify product category: ");
				String category = sc.nextLine();
				doc.read(category);
				break;
		case 8: ReportBug rb=new ReportBug();
				rb.reportBug();
				DataStore.RB.add(rb);
		default: System.out.println("Enter Correct choice");
		}
		
	}

}

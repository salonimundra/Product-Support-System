import java.util.*;
public class ReportBug {
static int count=1;
int bID;
String bugDetails;
String status;
String producType;
public void reportBug() {
	System.out.println("Enter product category: ");
	Scanner sc= new Scanner(System.in);
	this.producType=sc.nextLine();
	System.out.println("Enter bug details: ");
	this.bugDetails=sc.nextLine();
	this.status="unsolved";
	this.bID=this.count;
	count++;
	read();
}
public void updateBugStatus() {
	read();
	System.out.println("Enter solved to resolve the bug else enter unsolved: ");
	Scanner sc= new Scanner(System.in);
	String temp;
	temp=sc.nextLine();
	if(temp.equals("solved")) {
	System.out.println("Bug Solved");
	this.status="solved";
	}
	}
public void read() {
	System.out.println("-----------------------------------------------");
	System.out.println("The details of Bug Report are: ");
	System.out.println("Bug ID "+this.bID);
	System.out.println("Bug Details:  "+this.bugDetails);
	System.out.println("Status: "+this.status);
	System.out.println("-----------------------------------------------");
}
}

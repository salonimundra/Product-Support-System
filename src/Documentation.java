import java.util.*;
public class Documentation {
int documentID;
String product_category;
String document_details;

Documentation(int documentID, String product_category, String document_details){
	this.documentID = documentID;
	this.product_category = product_category;
	this.document_details = document_details;
}

Documentation(){
	
}

public void read(String category) {
	for(int i=0; i<DataStore.doc.size(); i++) {
		if(DataStore.doc.get(i).product_category.equals(category)) {
			System.out.println("Document ID: "+DataStore.doc.get(i).documentID);
			System.out.println("* "+DataStore.doc.get(i).document_details);
		}
	}
}
public void update() {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter document ID to be updated: ");
	int documentID=sc.nextInt();
	sc.nextLine();
	System.out.println("Enter the new details: ");
	String document_details=sc.nextLine();
	for(int i=0; i<DataStore.doc.size(); i++) {
		if(DataStore.doc.get(i).documentID==documentID) {
			DataStore.doc.get(i).document_details=document_details;
		}
	}
}
}
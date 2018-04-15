import java.util.*;

public class Forums {
static int counter=0;
int forumPostID;
String product_category;
String query;
HashMap<String, ArrayList<String>> forumPost = new HashMap<String, ArrayList<String>>();

Forums(String product_category, String query){
	counter++;
	this.forumPostID = counter;
	this.product_category = product_category;
	this.query = query;
	ArrayList<String> a=new ArrayList<String>();
	this.forumPost.put(query,a);
}

Forums(){
	
}

public void readForums(String category) {
	for(int i=0; i<DataStore.forums.size(); i++) {
		if(DataStore.forums.get(i).product_category.equals(category)) {
			//System.out.println("1 "+ DataStore.forums.get(i).forumPost);
			for (Map.Entry<String, ArrayList<String>> entry : DataStore.forums.get(i).forumPost.entrySet()) {
			    String key = entry.getKey();
			    System.out.println("1. "+key);
			    ArrayList<String> value = entry.getValue();
			    for(String aString : value){
			        System.out.println("  * "+aString);
			    }
			}

		}
	}
}

public void postQuery(String product_category, String query) {
	Forums f = new Forums(product_category, query);
	DataStore.forums.add(f);
	System.out.println("Forum Post ID: "+f.forumPostID);
}

public void answerQuery(int forumPostID, String answer) {
	for(int i=0; i<DataStore.forums.size(); i++) {
		if(DataStore.forums.get(i).forumPostID==forumPostID) {
			String key = DataStore.forums.get(i).query;
			//System.out.println(key);
			DataStore.forums.get(i).forumPost.get(key).add(answer);
		}
	}
}
public void update() {
	System.out.println("What do you want to do? ");
	System.out.println("1. Delete Forum Thread");
	System.out.println("2. Delete an Answer");
	System.out.println("3. Answer a query");
	Scanner sc = new Scanner(System.in);
	int option = sc.nextInt();
	sc.nextLine();
	if(option == 1) {
		System.out.println("Enter forum post ID to be deleted: ");
		int id = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<DataStore.forums.size(); i++) {
			if(DataStore.forums.get(i).forumPostID==id) {
				DataStore.forums.get(i).forumPost.remove(DataStore.forums.get(i).query);
			}
		}
	}
	
	else if(option==2) {
		System.out.println("Enter forum post ID to be updated: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter answer to be deleted: ");
		String answer = sc.nextLine();
		
		for(int i=0; i<DataStore.forums.size(); i++) {
			if(DataStore.forums.get(i).forumPostID==id) {
				for(int j=0; j<DataStore.forums.get(i).forumPost.get(DataStore.forums.get(i).query).size(); j++) {
					if(DataStore.forums.get(i).forumPost.get(DataStore.forums.get(i).query).get(j).equals(answer)) {
						DataStore.forums.get(i).forumPost.get(DataStore.forums.get(i).query).remove(j);
					}
				}
			}
		}
	}
	else if(option==3) {
		System.out.println("Enter forum post ID to answer: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Submit your answer: ");
		String answer = sc.nextLine();
		answerQuery(id, answer);
		System.out.println("Your answer has been submitted");
	}
	
}
public int getForumPostID() {
	return forumPostID;
}
public void setForumPostID(int forumPostID) {
	this.forumPostID = forumPostID;
}

}
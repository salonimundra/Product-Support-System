
public class AccountHistory {
public void generateAccountHistory(int userID) {
	for (int x=0; x<DataStore.ser.size(); x++) {
		//1System.out.println(DataStore.Reguser.get(x).userid+" "+DataStore.Reguser.get(x).password);
		if(DataStore.ser.get(x).userID==userID) {
		DataStore.ser.get(x).view();
		System.out.println();
		}
		}
	}
}


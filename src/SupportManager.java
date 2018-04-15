
public class SupportManager extends SupportTeam{

	public SupportManager(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	public void menu() {
		StatisticalReport s=new StatisticalReport();
		s.generateReport();
	}

}

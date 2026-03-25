package test_909;



public class ManagerService implements UserService {

	@Override
	public void save(String name) {
	
		System.out.print("save name manger"+name);
	}

	@Override
	public void update(String name) {
		
		System.out.print("update name manger"+name);
	}
	

}

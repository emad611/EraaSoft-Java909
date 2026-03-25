package test_909;

import org.springframework.stereotype.Component;

@Component
public class PersonService implements UserService{

	@Override
	public void save(String name) {
		
		System.out.print("save name person: " + name);
	}

	@Override
	public void update(String name) {
		
		System.out.print("update name person: " + name);
	}

}

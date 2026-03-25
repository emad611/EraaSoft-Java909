package test2_909;

import org.springframework.stereotype.Component;

@Component
public class PersonService implements UserService {

	@Override
	public void save(String name) {
		
	System.out.print("person save name: "+name);	
	}
	

}

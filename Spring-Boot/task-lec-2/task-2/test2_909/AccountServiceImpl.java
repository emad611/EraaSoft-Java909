package test2_909;

import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService{

	private UserService service;
	
	public AccountServiceImpl(UserService service) {
		this.service=service;
	}

	@Override
	public void getSavePerson() {
		service.save("emad");
		
	}
	

}

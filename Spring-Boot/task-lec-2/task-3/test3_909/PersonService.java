package test3_909;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PersonService  implements UserService{

	@Override
	public void save(String name) {
		System.out.print("save person name "+name);
		
	}
	@PostConstruct
	public void start() {
		System.out.print("start service....");
	}
	@PreDestroy
	public void end() {
		System.out.print("end service....");
	}
	

}

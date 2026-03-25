package test_909;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        PersonService personService =
//                applicationContext.getBean("personService", PersonService.class);
//
//        ManagerService managerService =
//                applicationContext.getBean("managerService", ManagerService.class);
//
//        personService.save(" emad");
//        personService.update(" ahmed");
//
//        managerService.save(" sara");
//        managerService.update(" hend");
//
//        applicationContext.close();
    	
    	try (AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(User.class)) {
			PersonService personService=
					annotationConfigApplicationContext.getBean(PersonService.class);
			
			personService.save("Ahmed");
			personService.update("Ahmed");
		} catch (BeansException e) {
			
			e.printStackTrace();
		}
    	
    	

    }
}
package test3_909;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext2.xml");
//        
//        PersonService personService=
//        		applicationContext.getBean("personService",PersonService.class);
//        
//        personService.save("emad");
//        
//        
//        personService.end();
//        
//        applicationContext.close();
//       
    	AnnotationConfigApplicationContext annotationConfigApplicationContext
    	=new AnnotationConfigApplicationContext(User.class);
    	
    	PersonService personService=
    			annotationConfigApplicationContext.getBean(PersonService.class);
    	

    	personService.save("emad");
    	
    	System.out.print(" ");
    	
    	personService.end();
    	
    annotationConfigApplicationContext.close();
    }
}
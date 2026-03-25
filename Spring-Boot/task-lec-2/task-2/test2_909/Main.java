package test2_909;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("applicationContext1.xml");
//        
//        AccountServiceImpl accountServiceImpl=
//        		applicationContext.getBean("accountServiceImpl",AccountServiceImpl.class);
//
//        accountServiceImpl.getSavePerson();
//       
//    	
//applicationContext.close();    
    	
    	AnnotationConfigApplicationContext annotationConfigApplicationContext=
    			new AnnotationConfigApplicationContext(User.class);
    	
    	AccountServiceImpl accountServiceImpl=
    			annotationConfigApplicationContext.getBean(AccountServiceImpl.class);
    	
    	accountServiceImpl.getSavePerson();
    	

    }
}
package za.co.dropzone.sessionbeans;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorld
 */
@Stateless
public class HelloWorld implements HelloWorldLocal {

    /**
     * Default constructor. 
     */
    public HelloWorld() {
    	
    }
    
    public String SayHello(String name) {
    	return "Hello " + name;   
    }    

}

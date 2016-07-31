package za.co.dropzone.sessionbeans;

import javax.ejb.Local;

@Local
public interface HelloWorldLocal {
	
	public String SayHello(String name);

}

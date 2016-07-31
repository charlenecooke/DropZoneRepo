package za.co.dropzone.thriftservlets;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import za.co.dropzone.sessionbeans.HelloWorldLocal;

public class JavaAppTestEJB {

	public static void main(String[] args) {
		 
//		@EJB(lookup="java:global/DropZoneEar/DropZoneEJB/HelloWorld") ;
		try {
			
			Context context = EJBContainer.createEJBContainer().getContext();
			HelloWorldLocal ejb = (HelloWorldLocal)context.lookup("java:global/DropZoneEar/DropZoneEJB/HelloWorld");
			String msg = ejb.SayHello("Hello Charlene, your servlet call to EJB works");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HelloWorldLocal helloWorldBean;		

	}

}

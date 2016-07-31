package za.co.dropzone.thriftservlets;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import za.co.dropzone.sessionbeans.HelloWorldLocal;

public class TestServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		@EJB(lookup="java:global/DropZoneEar/DropZoneEJB/HelloWorld") ; This is how we want to do it, with injection
		try {
			
//			startProfileService();
			
			InitialContext ic = new InitialContext();

			HelloWorldLocal ejb = (HelloWorldLocal) ic.lookup("java:global/DropZoneEar/DropZoneEJB/HelloWorld");

			String msg = ejb.SayHello("Hello Charlene, your servlet call to EJB works");
			req.setAttribute("msg",msg );
			
			req.getRequestDispatcher("/result.jsp").forward(req,resp);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

//	private void startProfileService() {
//        try
//        {
//            ProfileServer handler = new ProfileServer();
//            ProfileService.Processor processor = new ProfileService.Processor(handler);
//            TServerTransport serverTransport = new TServerSocket(9091);
//            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
//            
//            System.out.println("Starting the profile server...");
//            server.serve();
//            System.out.println("Profile server ready to serve...");
//        }
//        catch (Exception x)
//        {
//        	System.out.println(x.getStackTrace());
//        }
//        System.out.println("done.");
//		
//	}
}
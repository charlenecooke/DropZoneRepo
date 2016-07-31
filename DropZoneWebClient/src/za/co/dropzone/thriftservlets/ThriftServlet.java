package za.co.dropzone.thriftservlets;
import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import za.co.dropzone.dto.ProfileDTO;
import za.co.dropzone.services.impl.ProfileServer;
import za.co.dropzone.sessionbeans.HelloWorldLocal;
import za.co.dropzone.sessionbeans.ProfileLocal;
import za.co.dropzone.thriftservices.ProfileService;

public class ThriftServlet extends HttpServlet{
	
//	public ThriftServlet(TProcessor processor, TProtocolFactory protocolFactory) {
//		super(processor, protocolFactory);
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		@EJB(lookup="java:global/DropZoneEar/DropZoneEJB/HelloWorld") ; This is how we want to do it, with injection
		try {
			
			startProfileService();
//			EJBPersistenceTestFromServlet();
			
			InitialContext ic = new InitialContext();

			HelloWorldLocal ejb = (HelloWorldLocal) ic.lookup("java:global/DropZoneEar/DropZoneEJB/HelloWorld");

			String msg = ejb.SayHello("Hello Charlene, your servlet call to EJB works");
			req.setAttribute("msg",msg );
			
			req.getRequestDispatcher("/result.jsp").forward(req,resp);
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
//		catch (TException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
		
	}

	private void EJBPersistenceTestFromServlet() {
		try {
			
			InitialContext ic = new InitialContext();

			ProfileLocal ejb = (ProfileLocal) ic.lookup("java:global/DropZoneEar/DropZoneEJB/ProfileStatelessSessionBean");
			
			ProfileDTO dto = new ProfileDTO();
			dto.setCompanyNumber("companyNumber");
			dto.setLongDescription("longDescription");
			dto.setName("name");
			
			ejb.insertProfile(dto);
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}


	private void startProfileService() {
        try
        {
            ProfileServer handler = new ProfileServer();
            ProfileService.Processor processor = new ProfileService.Processor(handler);
            TServerTransport serverTransport = new TServerSocket(9091);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
//            
            System.out.println("Starting the profile server...");
            server.serve();
            System.out.println("Profile server ready to serve...");
        }
        catch (Exception x)
        {
        	System.out.println(x.getStackTrace());
        }
//        System.out.println("done.");
//		
	}
}
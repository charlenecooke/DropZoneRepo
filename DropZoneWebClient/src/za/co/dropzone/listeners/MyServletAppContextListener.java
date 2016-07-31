package za.co.dropzone.listeners;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import za.co.dropzone.services.impl.ProfileServer;
import za.co.dropzone.thriftservices.ProfileService;

public class MyServletAppContextListener implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

        //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");	
		startProfileService();
		
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
	
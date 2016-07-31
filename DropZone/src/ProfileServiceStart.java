import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.rfaisal.math.MathService;
import org.rfaisal.math.ProfileService;


public class ProfileServiceStart {

    public static void main(String[] args)
    {
        try
        {
            ProfileServer handler = new ProfileServer();
            ProfileService.Processor processor = new ProfileService.Processor(handler);
            TServerTransport serverTransport = new TServerSocket(9091);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
            
            System.out.println("Starting the profile server...");
            server.serve();
            System.out.println("Profile server ready to serve...");
        }
        catch (Exception x)
        {
        	System.out.println(x.getStackTrace());
        }
        System.out.println("done.");
    }
    
}

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.rfaisal.math.MathService;


public class MathServiceStart {

    public static void main(String[] args)
    {
        try
        {
            MathServer handler = new MathServer();
            MathService.Processor processor = new MathService.Processor(handler);
            TServerTransport serverTransport = new TServerSocket(9090);
            TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
            
            System.out.println("Starting the math server...");
            server.serve();
        }
        catch (Exception x)
        {
        	System.out.println(x.getStackTrace());
        }
        System.out.println("done.");
    }
    
}

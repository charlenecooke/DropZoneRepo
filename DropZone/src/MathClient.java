import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.rfaisal.math.MathService;


public class MathClient {
	   public static void main(String[] args) throws TException{
			 TTransport transport = new TSocket("localhost", 9090);
			 transport.open();
			 TProtocol protocol = new  TBinaryProtocol(transport);
			 MathService.Client client = new MathService.Client(protocol);
			 
			 System.out.println(client.add(10, 20));
			 System.out.println(client.sub(10, 20));
			 System.out.println(client.mul(10, 20));
			 System.out.println(client.div(10, 20));
		
	   }
}

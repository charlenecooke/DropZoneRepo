import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.rfaisal.math.ProfileService;


public class ProfileClient {
	   public static void main(String[] args) throws TException{
			 TTransport transport = new TSocket("localhost", 9090);
			 transport.open();
			 TProtocol protocol = new  TBinaryProtocol(transport);
			 ProfileService.Client client = new ProfileService.Client(protocol);
			 
			 System.out.println(client.createProfile(
					 "organisationName", 
					 "shortDescription", 
					 "longDescription", 
					 "npoNumber", 
					 "companyNumber", 
					 "trustNumber", 
					 "vatNumber", 
					 1));
			 
		
	   }
}

/*
 * Created on 07-Sep-2004
 * @author bandara
 */
package rmi;

//import java.rmi.Naming;
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
import java.rmi.*;
import common.MessageInfo;

/**
 * @author bandara
 *
 */
public class RMIClient {

	public static void main(String[] args) {

		RMIServerI iRMIServer = null;

		// Check arguments for Server host and number of messages
		if (args.length < 2)
		{
			System.out.println("Needs 2 arguments: ServerHostName/IPAddress, TotalMessageCount");
			System.exit(-1);
		}

		String urlServer = new String("rmi://" + args[0] + "/RMIServer"); 				//pass number of messages to be sent from terminal
		int numMessages = Integer.parseInt(args[1]);
	
		try{
		// TO-DO: Initialise Security Manager
			if(System.getSecurityManager() == null) 						//If there is no security manager, this method returns null
			{
				System.setSecurityManager(new RMISecurityManager()); 
			}
		// TO-DO: Bind to RMIServer

		iRMIServer = (RMIServerI) Naming.lookup(urlServer);

		// TO-DO: Attempt to send messages the specified number of times

		for (int i = 1; i <= numMessages; i++)
		{
			MessageInfo myMessage = new MessageInfo(numMessages, i);                                //creates new message object with the number of messages and the index of the specific message

			iRMIServer.receiveMessage(myMessage);                                                   //receivemessage method with the rmiserver object
		}

		} //
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
}









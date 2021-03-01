package function;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import function.Client;
import function.Method;

public class RemoteMethod extends UnicastRemoteObject implements rmi.Method {

    public RemoteMethod() throws RemoteException {
    }

    @Override
    public boolean checkName(String userName) throws RemoteException {
        for (Client client : Method.getClients()) {
            String name = client.getUserName();
            if (name.equalsIgnoreCase(userName)) {
                return false;
            }
        }
        return true;
    }

}

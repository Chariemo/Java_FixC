package rmiCal.server;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * RMI Server
 * Created by Charley on 2017/7/2.
 */
public class CalServer {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {

            LocateRegistry.createRegistry(6789);
            CalculateServiceImpl cal = new CalculateServiceImpl();
            Context namingContext = new InitialContext();
            namingContext.rebind( "rmi://localhost:6789/calculate", cal);

            System.out.println("cal server ready");

        } catch (RemoteException re) {
            System.out.println("Exception in CalculateServiceImpl .main: " + re);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Remote Exception!");
        }
    }
}




package rmiCal.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Charley on 2017/7/2.
 */

public interface CalculateService extends Remote {

    public double add(double a,double b) throws RemoteException;

    public double sub(double a, double b) throws RemoteException;

    public double mul(double a, double b) throws  RemoteException;

    public double div(double a, double b) throws RemoteException;

    public double fac(double a) throws RemoteException;

    public double pow(double a, double b) throws  RemoteException;
}

package rmiCal.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Calculater
 * Created by Charley on 2017/7/2.
 */
public class CalculateServiceImpl extends UnicastRemoteObject implements CalculateService{

    protected CalculateServiceImpl() throws RemoteException {
        super();
    }

    public double add(double a, double b) throws RemoteException {
        return a+b;
    }

    public double sub(double a, double b) throws RemoteException {
        return a - b;
    }

    public double mul(double a, double b) throws RemoteException {

        return a * b;
    }

    public double div(double a, double b) throws RemoteException {

        return a / b;
    }

    public double fac(double a) throws RemoteException {

        double result = a;
        for (double i = a - 1; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    public double pow(double a, double b) throws RemoteException {

        double result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }


}



package calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements CalculatorInterface {

    public Calculator() throws RemoteException {
        super();
    }

    @Override
    public  double adunare(double x, double y) throws RemoteException {
        return x + y;
    }

    @Override
    public  double scadere(double x, double y) throws RemoteException {
        return x - y;
    }

    @Override
    public  double inmultire(double x, double y) throws RemoteException {
        return x * y;
    }

    @Override
    public  double impartire(double x, double y) throws RemoteException {
        if (y == 0) {
            throw new IllegalArgumentException("Nu se poate imparti la 0!");
            
        }
        return x / y;
    }

    @Override
    public  double patrat(double x) throws RemoteException {
        return Math.pow(x, 2);
    }

    @Override
    public  double radical(double x) throws RemoteException {
        if (x < 0) {
            throw new IllegalArgumentException("Nu se poate extrage radical din numere negative");
        }
        return Math.sqrt(x);
    }

    @Override
    public  double factorial(double x) throws RemoteException {
        if (x < 0) {
            throw new IllegalArgumentException("Nu se poate afla factorial din numere negative");
        }
        if (x == 0) {
            return 1;
        }
        return x * factorial(x - 1);
    }

    @Override
public  double combinatii1(double n, double k) throws RemoteException {
    if (k < 0 || k > n) {
        throw new IllegalArgumentException("Valori incorecte pentru combinatii");
    }
    if (k == 0 || k == n) {
        return 1;
    }
    double combinatie1 = combinatii1(n - 1, k);
    double combinatie2 = combinatii1(n - 1, k - 1);
    return combinatie1 + combinatie2;
}


    @Override
public  double combinatii2(double n, double k) throws RemoteException {
    if (k < 0 || k > n) {
        throw new IllegalArgumentException("Valori incorecte pentru combinatii");
    }
    if (k == 0 || k == n) {
        return 1;
    }
    double numerator = n * combinatii2(n - 1, k - 1);
    double denominator = k;
    return numerator / denominator;
}

}

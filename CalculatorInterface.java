/* CalculatorInterface.java contine:  definitinia interfetei Stub la Client si Skeleton la Server
 * Aplicatia client-server Java foloseste apelul metodelor la distanţă RMI(Remote  Method  Invocation). 
 * Aplicaţia RMI permite clienţilor să apeleze de la un server urmatoarele: 
 * Patru metode corespunzătoare celor operaţii aritmetice (add, sub, mul, div).
 * @author EUGEN ZAHARESCU
 *
 *Adaugat 5 functii de Robert Rarinca
*/

package calculator;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInterface extends Remote {
    public double adunare(double x, double y) throws RemoteException;
    public double scadere(double x, double y) throws RemoteException;
    public double inmultire(double x, double y) throws RemoteException;
    public double impartire(double x, double y) throws RemoteException;
    public double patrat(double x) throws RemoteException;
    public double radical(double x) throws RemoteException;
    public double factorial(double x) throws RemoteException;
    public double combinatii1(double n, double k) throws RemoteException;
    public double combinatii2(double n, double k) throws RemoteException;

}
/* CalculatorServer.java contine:  definitinia clasei main calculatorServer. Run File = Shift+F6
 * Aplicatia client-server Java foloseste apelul metodelor la distanţă RMI(Remote  Method  Invocation). 
 * Aplicaţia RMI permite clienţilor să apeleze de la un server urmatoarele: 
 * Patru metode corespunzătoare celor operaţii aritmetice (add, sub, mul, div).
 * @author EUGEN ZAHARESCU
 */
package calculator;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.NotBoundException;

public class CalculatorServer {
    public static void main(String[] args) throws RemoteException,NotBoundException
    {
        try
        {//SE CREAZA REGISTRUL "RMI" ACCESIBIL PE PORTUL 1090 ("//localhost:1090/...)
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1090);
            r.rebind("Calculator", new Calculator());//SE INREGISTREAZA OBIECTUL ACCESIBIL LA DISTANTA "Calculator" IN rmiregistry
            System.out.println("OBIECTUL 'calculator' A FOST INREGISTRAT IN rmiregistry SI ESTE ACCESIBIL LA DISTANTA!\n"+"SERVERUL RULEAZA...");
        }
        catch(RemoteException e)
                {
                    System.out.println(e);
                }
    }
}
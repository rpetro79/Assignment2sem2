package ConsumerClient;

import ServerSide.ServerInterface;
import Utilities.Burger;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Scanner;

public class ConsumerClient implements Remote {
    ServerInterface server;
    public ConsumerClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        server = (ServerInterface) reg.lookup("burgerServer");
    }


    public Burger getBurger() throws RemoteException {
        return server.eatBurger();
    }


    public static void main(String[] args) throws RemoteException, NotBoundException {
        System.out.println("Client id: ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        ConsumerClient c = new ConsumerClient();
        Random r = new Random();
        int time;
        Burger burger;

        while(true)
        {
            burger = c.getBurger();
            System.out.println(id + " ate burger " + burger.getName());
            time = r.nextInt(2000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

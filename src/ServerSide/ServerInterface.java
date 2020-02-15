package ServerSide;

import Utilities.Burger;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {
    public Burger eatBurger() throws RemoteException;
    public void burgerPrepared(Burger burger) throws RemoteException;
}

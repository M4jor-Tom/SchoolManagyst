package LogicTier;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import MainPackage.Promotion;
import MainPackage.Studient;

public interface LogicInterface extends Remote
{
	public Promotion getPromotion(String acronym) throws RemoteException;
	public Promotion getPromotion(int index) throws RemoteException;
	
	public void addPromotion(Promotion promotion) throws RemoteException;

	public ArrayList<Promotion> getPromotions() throws RemoteException;
	
	public void addToPromotion(int promotionIndex, Studient toAdd) throws RemoteException;
}
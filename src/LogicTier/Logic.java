package LogicTier;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import DataTier.DataInterface;
import MainPackage.Promotion;
import MainPackage.Studient;

public class Logic extends UnicastRemoteObject implements LogicInterface
{
	private static final long serialVersionUID = 3539898641029169426L;
	private DataInterface _dataInterface;
	
	public Logic(DataInterface dataInterface) throws RemoteException
	{
		setDataInterface(dataInterface);
		setPromotions(new ArrayList<>());
	}
	
	public Promotion getPromotion(String acronym)
	{
		for(int i = 0; i < getPromotions().size(); i++)
			if(getPromotions().get(i).getAcronym() == acronym)
				return getPromotions().get(i);
		
		return new Promotion();
	}

	public Promotion getPromotion(int index)
	{
		return getPromotions().get(index);
	}
	
	public void addPromotion(Promotion promotion)
	{
		getPromotions().add(promotion);
	}
	
	public ArrayList<Promotion> getPromotions()
	{
		return getDataInterface().getPromotions();
	}
	
	public void setPromotions(ArrayList<Promotion> promotions)
	{
		getDataInterface().setPromotions(promotions);
	}

	public void addToPromotion(int promotionIndex, Studient toAdd)
	{
		getPromotions().get(promotionIndex).addStudient(toAdd);
	}

	public DataInterface getDataInterface()
	{
		return _dataInterface;
	}

	public void setDataInterface(DataInterface dataInterface)
	{
		_dataInterface = dataInterface;
	}
}
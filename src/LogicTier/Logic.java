package LogicTier;
import java.util.ArrayList;

import DataTier.DataInterface;
import MainPackage.Promotion;
import MainPackage.Studient;

public class Logic implements LogicInterface
{
	private DataInterface _dataInterface;
	private ArrayList<Promotion> _promotions;
	
	public Logic(DataInterface dataInterface)
	{
		setDataInterface(dataInterface);
		setPromotions(new ArrayList<>());
	}
	
	public Promotion getPromotion(String acronym)
	{
		for(int i = 0; i < _promotions.size(); i++)
			if(_promotions.get(i).getAcronym() == acronym)
				return _promotions.get(i);
		
		return new Promotion();
	}

	public Promotion getPromotion(int index)
	{
		return _promotions.get(index);
	}
	
	public void addPromotion(Promotion promotion)
	{
		_promotions.add(promotion);
	}
	
	public ArrayList<Promotion> getPromotions()
	{
		return _promotions;
	}
	
	public void setPromotions(ArrayList<Promotion> promotions)
	{
		_promotions = promotions;
	}

	public void addToPromotion(int promotionIndex, Studient toAdd)
	{
		_promotions.get(promotionIndex).addStudient(toAdd);
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
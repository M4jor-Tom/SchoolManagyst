package LogicTier;
import java.util.ArrayList;

import DataTier.DataInterface;
import MainPackage.Promotion;

public class Logic implements LogicInterface
{
	private DataInterface _dataInterface;
	private ArrayList<Promotion> _promotions;
	
	public Logic(DataInterface dataInterface)
	{
		_dataInterface = dataInterface;
	}
	
	public Promotion getPromotion(String acronym)
	{
		for(int i = 0; i < _promotions.size(); i++)
			if(_promotions.get(i).getAcronym() == acronym)
				return _promotions.get(i);
		
		return new Promotion();
	}
}
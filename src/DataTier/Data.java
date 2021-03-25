package DataTier;

import java.util.ArrayList;

import MainPackage.Promotion;
import MainPackage.Studient;

public class Data implements DataInterface
{
	ArrayList<Promotion> _promotions;
	ArrayList<Studient> _studients;
	
	public Data(PromotionDataAccessObject promotionDao)
	{
		setPromotions(new ArrayList<>());
		setStudients(new ArrayList<>());
	}
	
	public ArrayList<Promotion> getPromotions()
	{
		return _promotions;
	}
	
	public void setPromotions(ArrayList<Promotion> promotions)
	{
		_promotions = promotions;
	}
	
	public ArrayList<Studient> getStudients()
	{
		return _studients;
	}
	
	public void setStudients(ArrayList<Studient> studients)
	{
		_studients = studients;
	}
}
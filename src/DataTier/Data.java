package DataTier;

import java.util.ArrayList;

import MainPackage.Promotion;
import MainPackage.Studient;

public class Data implements DataInterface
{
	PromotionDataAccessObject _promotionDao;
	
	public Data(PromotionDataAccessObject promotionDao)
	{
		setPromotionDao(promotionDao);
	}

	public void addPromotion(Promotion promotion)
	{
		getPromotionDao().create(promotion);
	}

	public void addToPromotion(long promotionId, Studient toAdd)
	{
		getPromotionDao().getStudientDao().create(toAdd, promotionId);
	}
	
	public ArrayList<Promotion> getPromotions()
	{
		return getPromotionDao().selectAll();
	}
	
	public void setPromotions(ArrayList<Promotion> promotions)
	{
		getPromotionDao().truncate();
		for(Promotion promotion: promotions)
			getPromotionDao().create(promotion);
	}
	
	public ArrayList<Studient> getStudients()
	{
		return getPromotionDao().getStudientDao().selectAll();
	}
	
	private PromotionDataAccessObject getPromotionDao()
	{
		return _promotionDao;
	}
	
	private void setPromotionDao(PromotionDataAccessObject promotionDao)
	{
		_promotionDao = promotionDao;
	}
}
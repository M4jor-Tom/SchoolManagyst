package DataTier;

import java.util.ArrayList;

import MainPackage.Promotion;
import MainPackage.Studient;

public interface DataInterface
{
	ArrayList<Promotion> getPromotions();
	void setPromotions(ArrayList<Promotion> promotions);
	public void addPromotion(Promotion promotion);
	public void addToPromotion(long promotionId, Studient toAdd);
}
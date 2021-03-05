package LogicTier;

import java.util.ArrayList;

import MainPackage.Promotion;
import MainPackage.Studient;

public interface LogicInterface
{
	public Promotion getPromotion(String acronym);
	public Promotion getPromotion(int index);
	
	public void addPromotion(Promotion promotion);

	public ArrayList<Promotion> getPromotions();
	
	public void addToPromotion(int promotionIndex, Studient toAdd);
}
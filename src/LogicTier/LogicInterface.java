package LogicTier;

import MainPackage.Promotion;

public interface LogicInterface
{
	public Promotion getPromotion(String acronym);
	
	public void addPromotion(Promotion promotion);
}
package DataTier;

import java.util.ArrayList;

import MainPackage.Promotion;

public interface DataInterface
{
	ArrayList<Promotion> getPromotions();
	void setPromotions(ArrayList<Promotion> promotions);
}
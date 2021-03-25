package MainPackage;

//3-Tier Implementation
import PresentationTier.*;
import LogicTier.*;
import DataTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		StudientDataAccessObject studientDao = new StudientDataAccessObject();
		PromotionDataAccessObject promotionDao = new PromotionDataAccessObject(studientDao);
		
		DataInterface data = new Data(promotionDao);
		
		LogicInterface logic = new Logic(data);
		Presentation presentation = new Presentation(logic);
		
		presentation.menu();
	}
}
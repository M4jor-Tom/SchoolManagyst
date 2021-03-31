package MainPackage;

//3-Tier Implementation
import java.rmi.registry.*;
import PresentationTier.*;
import LogicTier.*;

import java.rmi.Naming;

import DataTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		StudientDataAccessObject studientDao = new StudientDataAccessObject();
		PromotionDataAccessObject promotionDao = new PromotionDataAccessObject(studientDao);
		
		DataInterface data = new Data(promotionDao);
		
		try
		{
			LocateRegistry.createRegistry(1099);
			LogicInterface logic = new Logic(data);

			Naming.rebind("rmi://localhost/1099/logic", logic);
			
			Presentation presentation = new Presentation(logic);
			
			presentation.menu();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
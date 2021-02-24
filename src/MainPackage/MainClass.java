package MainPackage;

//3-Tier Implementation
import PresentationTier.*;
import LogicTier.*;
import DataTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		DataInterface data = new Data();
		LogicInterface logic = new Logic(data);
		Presentation presentation = new Presentation(logic);
		
		presentation.menu();
	}
}
package LogicTier;
import DataTier.DataInterface;

public class Logic implements LogicInterface
{
	private DataInterface _dataInterface;
	
	public Logic(DataInterface dataInterface)
	{
		_dataInterface = dataInterface;
	}
}
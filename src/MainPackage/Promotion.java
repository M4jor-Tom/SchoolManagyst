package MainPackage;

import java.util.ArrayList;

public class Promotion
{
	private String
		_entitled,
		_acronym;
	private ArrayList<Studient> _studients;
	
	public Promotion(String entitled, String acronym)
	{
		_entitled = entitled;
		_acronym = acronym;
		_studients = new ArrayList<>();
	}

	public Promotion()
	{
		_entitled = "";
		_acronym = "";
		_studients = new ArrayList<>();
	}
	
	public void addStudient(Studient studient)
	{
		_studients.add(studient);
	}
	
	public String getAcronym()
	{
		return _acronym;
	}
	
	public String toString()
	{
		String _toString = "Promotion::\n{\n\tentitled = " + _entitled + "\n\tacronym = " + _acronym + "\n";
		for(int i = 0; i < _studients.size(); i++)
			_toString += _studients.get(i);
		
		return _toString;
	}
}
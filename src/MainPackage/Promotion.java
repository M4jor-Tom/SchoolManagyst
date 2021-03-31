package MainPackage;

import java.util.ArrayList;

public class Promotion
{
	private long _id;
	private String
		_entitled,
		_acronym;
	private ArrayList<Studient> _studients;

	
	public Promotion(String entitled, String acronym, ArrayList<Studient> studients)
	{
		setEntitled(entitled);
		setAcronym(acronym);
		setStudients(new ArrayList<>());
		setStudients(studients);
	}
	
	public Promotion(String entitled, String acronym)
	{
		setEntitled(entitled);
		setAcronym(acronym);
		setStudients(new ArrayList<>());
	}

	public Promotion()
	{
		setEntitled("");
		setAcronym("");
		setStudients(new ArrayList<>());
	}
	
	public void addStudient(Studient studient)
	{
		_studients.add(studient);
	}
	
	public String toString()
	{
		String _toString = "Promotion::\n{\n\tentitled = " + getEntitled() + "\n\tacronym = " + getAcronym();
		for(int i = 0; i < _studients.size(); i++)
			_toString += "\n\t" + getStudients().get(i);
		
		return _toString + "\n}";
	}

	public boolean isNull()
	{
		return _entitled == "" && _acronym == "";
	}

	public long getId()
	{
		return _id;
	}

	public void setId(long id)
	{
		_id = id;
	}

	public String getEntitled()
	{
		return _entitled;
	}
	
	public void setEntitled(String entitled)
	{
		_entitled = entitled;
	}
	
	public String getAcronym()
	{
		return _acronym;
	}
	
	public void setAcronym(String acronym)
	{
		_acronym = acronym;
	}
	
	public ArrayList<Studient> getStudients()
	{
		return _studients;
	}
	
	public void setStudients(ArrayList<Studient> studients)
	{
		_studients = studients;
	}
}
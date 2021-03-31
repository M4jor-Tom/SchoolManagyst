package MainPackage;

public class Studient
{
	private long _id;
	private String
		_firstName,
		_lastName;
	
	public Studient(String firstName, String lastName)
	{
		setFirstName(firstName);
		setLastName(lastName);
	}
	
	public Studient()
	{
		setFirstName("");
		setLastName("");
	}

	public String toString()
	{
		return "Studient::{firstName = " + getFirstName() + ",lastName = " + getLastName() + "}";
	}
	
	public long getId()
	{
		return _id;
	}

	public void setId(long id)
	{
		_id = id;
	}

	public String getFirstName()
	{
		return _firstName;
	}
	
	public void setFirstName(String firstName)
	{
		_firstName = firstName;
	}
	
	public String getLastName()
	{
		return _lastName;
	}
	
	public void setLastName(String lastName)
	{
		_lastName = lastName;
	}
}
package MainPackage;

public class Studient
{
	private String
		_firstName,
		_lastName;
	
	public Studient(String firstName, String lastName)
	{
		_firstName = firstName;
		_lastName = lastName;
	}
	
	public String toString()
	{
		return "Studient::{firstName = " + _firstName + ",lastName = " + _lastName + "}";
	}
}
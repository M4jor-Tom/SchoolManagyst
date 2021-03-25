package DataTier;

import java.sql.*;
import java.util.ArrayList;

import MainPackage.Studient;

public class StudientDataAccessObject extends DataAccessObject<Studient>
{
	public StudientDataAccessObject()
	{
		super();
		
	}
	
	public void create(Studient studient, long promotionId)
	{
		
	}
	
	@Override
	public void delete(Studient object)
	{
		
		
	}

	@Override
	public void update(Studient object)
	{
		
		
	}

	@Override
	public Studient select(Long id)
	{
		Studient studient = null;
		try
		{
			//Preparing SELECT MySQL Statement
			PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM studients WHERE studientId = ?");
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//Reading only result
			if(resultSet.next())
				studient = new Studient(resultSet.getString("studientFirstName"), resultSet.getString("studientLastName"));
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return studient;
	}

	@Override
	public ArrayList<Studient> selectAll()
	{
		ArrayList<Studient> studients = null;
		
		Statement statement;
		try
		{
			statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM studients");
			if(resultSet.first())
			{
				studients = new ArrayList<>();
				do
				{
					studients.add(new Studient(resultSet.getString("studientFirstName"), resultSet.getString("studientLastName")));
				}while(resultSet.next());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return studients;
	}

	public ArrayList<Studient> selectAll(long promotionId)
	{
		ArrayList<Studient> studients = null;
		
		PreparedStatement preparedStatement;
		try
		{
			preparedStatement = getConnection().prepareStatement("SELECT * FROM studients WHERE studientPromotionId = ?");
			preparedStatement.setLong(1, promotionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.first())
			{
				studients = new ArrayList<>();
				do
				{
					studients.add(new Studient(resultSet.getString("studientFirstName"), resultSet.getString("studientLastName")));
				}while(resultSet.next());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return studients;
	}
}
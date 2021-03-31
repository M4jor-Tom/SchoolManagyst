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
		try
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement(
				"INSERT INTO studients (studientPromotionId, studientFirstName, studientLastName) VALUES (?, ?, ?)"
			);
			
			preparedStatement.setLong(1, promotionId);
			preparedStatement.setString(2, studient.getFirstName());
			preparedStatement.setString(3, studient.getLastName());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void truncate()
	{
		try
		{
			Statement statement = getConnection().createStatement();
			statement.executeUpdate("DELETE FROM studients WHERE 1");//TRUNCATE TABLE studients");
			statement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(Studient object)
	{
		try
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM studients WHERE studientId = ?");
			preparedStatement.setLong(1, object.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Studient object)
	{
		try
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement(
				"UPDATE studients SET studientFirstName = ?, studientLastName = ? WHERE studientId = ?"
			);
			preparedStatement.setString(1, object.getFirstName());
			preparedStatement.setString(2, object.getLastName());
			preparedStatement.setLong(3, object.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
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
			preparedStatement.close();
			
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
		
		try
		{
			Statement statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM studients");
			statement.close();
			studients = new ArrayList<>();
			while(resultSet.next())
			{
				studients.add(new Studient(resultSet.getString("studientFirstName"), resultSet.getString("studientLastName")));
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
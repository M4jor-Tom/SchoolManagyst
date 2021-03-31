package DataTier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MainPackage.Promotion;

public class PromotionDataAccessObject extends DataAccessObject<Promotion>
{
	StudientDataAccessObject _studientDao;
	
	public PromotionDataAccessObject(StudientDataAccessObject studientDao)
	{
		super();
		setStudientDao(studientDao);
	}

	public void create(Promotion promotion)
	{
		try
		{	
			PreparedStatement preparedStatement = getConnection().prepareStatement(
				"INSERT INTO promotions (promotionEntitled, promotionAcronym) VALUES (?, ?)"
			);
			
			preparedStatement.setString(1, promotion.getEntitled());
			preparedStatement.setString(2, promotion.getAcronym());
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
			
			getStudientDao().truncate();
			statement.executeUpdate("DELETE FROM promotions WHERE 1");//TRUNCATE TABLE promotions");
			
			statement.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(Promotion object)
	{
		try
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM promotions WHERE promotionId = ?");
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
	public void update(Promotion object)
	{
		try
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement(
				"UPDATE promotions SET promotionEntitled = ?, promotionAcronym = ? WHERE promotionId = ?"
			);
			preparedStatement.setString(1, object.getEntitled());
			preparedStatement.setString(2, object.getAcronym());
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
	public Promotion select(Long id)
	{
		Promotion promotion = null;
		try
		{
			PreparedStatement preparedStatement = getConnection().prepareStatement(
				"SELECT * FROM promotions WHERE promotionId = ?"
			);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
			
			//Reading only result
			if(resultSet.next())
				promotion = new Promotion(
					resultSet.getString("promotionEntitled"),
					resultSet.getString("promotionAcronym"),
					getStudientDao().selectAll(resultSet.getLong("promotionId"))
				);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return promotion;
	}

	@Override
	public ArrayList<Promotion> selectAll()
	{
		ArrayList<Promotion> promotions = null;
		
		Statement statement;
		try
		{
			statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM promotions");
			if(resultSet.first())
			{
				promotions = new ArrayList<>();
				do
				{
					promotions.add(new Promotion(
							resultSet.getString("promotionEntitled"),
							resultSet.getString("promotionAcronym"),
							getStudientDao().selectAll(resultSet.getLong("promotionId"))
						));
				}while(resultSet.next());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return promotions;
	}
	
	public StudientDataAccessObject getStudientDao()
	{
		return _studientDao;
	}

	public void setStudientDao(StudientDataAccessObject studientDao)
	{
		_studientDao = studientDao;
	}
}
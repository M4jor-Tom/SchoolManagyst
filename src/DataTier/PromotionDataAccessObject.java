package DataTier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import MainPackage.Promotion;
import MainPackage.Studient;

public class PromotionDataAccessObject extends DataAccessObject<Promotion>
{
	StudientDataAccessObject _studientDao;
	
	public PromotionDataAccessObject(StudientDataAccessObject studientDao)
	{
		super();
		setStudientDao(studientDao);
	}

	public void create(Promotion promotion) {
		try
		{	
			PreparedStatement preparedStatement = getConnection().prepareStatement(
				"INSERT INTO promotion (promotionEntitled, promotionAcronym) VALUES (?, ?)"
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
	public void delete(Promotion object)
	{
		
		
	}

	@Override
	public void update(Promotion object)
	{
		
		
	}

	@Override
	public Promotion select(Long id)
	{
		
		return null;
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
package DataTier;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import MainPackage.Promotion;

public class PromotionDataAccessObject extends DataAccessObject<Promotion>
{	
	public PromotionDataAccessObject(StudientDataAccessObject studientDao)
	{
		super();
		
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
		
		return null;
	}
}
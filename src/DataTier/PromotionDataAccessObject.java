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
			PreparedStatement prepare = getConnection().prepareStatement(
				"INSERT INTO promotion (promotionEntitled, promotionAcronym) VALUES (?, ?)"
			);
			
			prepare.setString(1, promotion.getEntitled());
			prepare.setString(2, promotion.getAcronym());
			prepare.executeUpdate();
			prepare.close();
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
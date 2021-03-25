package DataTier;

import java.sql.Connection;
import java.util.ArrayList;

abstract public class DataAccessObject<SqlEntity>
{
	private Connection _connection;
	
	public DataAccessObject()
	{
		setConnection(MysqlConnector.getInstance());
	}
	
	public Connection getConnection()
	{
		return _connection;
	}

	public void setConnection(Connection connection)
	{
		_connection = connection;
	}

	abstract public void delete(SqlEntity object);
	abstract public void update(SqlEntity object);
	abstract public SqlEntity select(Long id);
	abstract public ArrayList<SqlEntity> selectAll();
}
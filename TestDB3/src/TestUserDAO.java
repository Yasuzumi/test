import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUserDAO {


	String name = "";
	String password = "";
public void delete(String name){
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();


	String sql = "delete from test_table where user_name=?";
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		int i=ps.executeUpdate();
		if (i>0) {
			System.out.println(i + "件消去されました");
		}

	}
		catch (SQLException e) {
			e.printStackTrace();
		}

	try {
		con.close();
	}catch (SQLException e){
		e.printStackTrace();
	}

}
}

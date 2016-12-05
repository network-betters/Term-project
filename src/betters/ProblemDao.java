package betters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProblemDao {
	private String topic;

	public ProblemDao(String topic) {
		this.topic = topic;
	}

	public Problem get() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();

		PreparedStatement ps = c.prepareStatement("select * from problem where topic = ?");
		ps.setString(1, topic);

		ResultSet rs = ps.executeQuery();
		rs.next();

		Problem p = new Problem();
		p.setAnswer(rs.getString("answer"));
		p.setProblem(rs.getString("problem"));
		p.setSub_topic(rs.getString("sub_topic"));

		rs.close();
		ps.close();
		c.close();

		return p;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/betters", "root", "12345");

		return c;
	}
}

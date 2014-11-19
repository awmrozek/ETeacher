import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTeacher {
	private Statement st;

	private String question;
	
	private String answer;
	
	DbTeacher() {
		try {
			Connection c = DriverManager.getConnection(
					"jdbc:mysql://sql5.freemysqlhosting.net/sql555625", 
					"sql555625",
					"iC6*sT5!");
			st = c.createStatement();
		} catch (Exception e) {
			System.err.println("Connection error!");
			System.exit(2);
		}
		System.out.println("Connected!");
	}
	
	public void nextQuestion () {
		String sql = "SELECT pytanie, odpowiedz FROM pytajnik ORDER BY RAND() LIMIT 1;";
		try {
			ResultSet rs = st.executeQuery(sql);
			rs.next();
		
			question = rs.getString(1);
			answer = rs.getString(2);
		} catch (Exception e) {
			System.err.println ("Unable to get a question. The query was: " + sql);
			System.exit(2);
		}
		
		
	}
	
	public String getQuestion () {
		return question;
	}
	
	public String getAnswer () {
		return answer;
	}
}

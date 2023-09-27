package sdc;
import java.sql.*;
import java.net.InetAddress;

public class database_setup{
	Connection con;
	Statement st;
	String ip = "localhost:3306";

	//Location of database
	String url = "jdbc:mysql://"+ ip +"/SpringDaleCollege";

    public database_setup(String username, String pass) throws SQLException,ClassNotFoundException {

			//Fetching driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Connecting to database
			con = DriverManager.getConnection(url,username,pass);

			//At many places PreparedStatements are used instead of statements to prevent SQL injection.
			st = con.createStatement();

			//Using SpringDaleCollege database
			st.execute("use SpringDaleCollege");

			
// Resource function
	// Creating table student if it does not exist
		st.execute("create table IF NOT EXISTS studentDetails(\r\n"
				+ "	uid	CHAR(8) Primary key,\r\n"
				+ "    name VARCHAR(50) NOT NULL,\r\n"
				+ "    class INT NOT NULL,\r\n"
				+ "    section VARCHAR(1) NOT NULL,\r\n"
	         + "    type INT NOT NULL,\r\n"
				+ "    constraint branch_code_check check (uid like \"%KR%\" OR  uid like \"%IN%\" OR uid like \"%GM%\"),\r\n"
				+ "    constraint primary_key_length check (LENGTH(uid) = 8),\r\n"
				+ "    constraint name_length_check check (length(name) > 0)\r\n"
				+ ");");
		 
    }
	}



//Resource function
	//Creating table student if it does not exist
	// 	st.execute("create table IF NOT EXISTS studentDetails(\r\n"
	// 			+ "	uid	CHAR(8) Primary key,\r\n"
	// 			+ "    name VARCHAR(50) NOT NULL,\r\n"
	// 			+ "    class INT NOT NULL,\r\n"
	// 			+ "    section VARCHAR(1) NOT NULL,\r\n"
	//          + "    type INT NOT NULL,\r\n"
	// 			+ "    constraint branch_code_check check (uid like \"%KR%\" OR  uid like \"%IN%\" OR uid like \"%GM%\"),\r\n"
	// 			+ "    constraint primary_key_length check (LENGTH(uid) = 8),\r\n"
	// 			+ "    constraint name_length_check check (length(name) > 0)\r\n"
	// 			+ ");");
		 
    // }

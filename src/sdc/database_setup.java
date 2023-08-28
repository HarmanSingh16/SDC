package sdc;
import java.sql.*;

public class database_setup{
	Connection con;
	Statement st;
    database_setup() throws Exception{

		//Fetching driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Location of database
		String url = "jdbc:mysql://localhost:3306/SpringDaleCollege";

		//Credentials for database
		String username = "root";
		String pass = "hs@160201";
		
		//Connecting to database
		con = DriverManager.getConnection(url,username,pass);
		st = con.createStatement();

		//Using SpringDaleCollege database
		st.execute("use SpringDaleCollege");

		//Creating table student if it does not exist
		st.execute("create table IF NOT EXISTS studentDetails(\r\n"
				+ "	uid	CHAR(8) Primary key,\r\n"
				+ "    name VARCHAR(50) NOT NULL,\r\n"
				+ "    class INT NOT NULL,\r\n"
				+ "    section VARCHAR(1) NOT NULL,\r\n"
				+ "    constraint branch_code_check check (uid like \"%KR%\" OR  uid like \"%IN%\" OR uid like \"%GM%\"),\r\n"
				+ "    constraint primary_key_length check (LENGTH(uid) = 8),\r\n"
				+ "    constraint name_length_check check (length(name) > 0)\r\n"
				+ ");");
		 
    }
}
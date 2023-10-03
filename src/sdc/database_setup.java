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
				+ "	uid CHAR(8) Primary Key,\r\n"
				+ "    name VARCHAR(50) not null,\r\n"
				+ "    class INT not null,\r\n"
				+ "    section char(1) not null,\r\n"
				+ "    type int not null,\r\n"
				+ "    constraint branch_code_check check(uid like \"%kr%\" or uid like \"%in%\" or uid like \"gm%\"),\r\n"
				+ "    constraint primary_key_length check (LENGTH(uid) = 8),\r\n"
				+ "    constraint name_length_check check (length(name) > 0),\r\n"
				+ "    constraint class_check check(class > 0 AND class <13)\r\n"
				+ ");");
		 
    }
}


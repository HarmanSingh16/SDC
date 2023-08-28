package sdc;

import java.sql.*;
import sdc.resource.*;

public class mySql {

	//Connection and statement object for SQL
	database_setup db;
	//Establising connection in constructor
	mySql(database_setup databaseREF) throws Exception{
		db = databaseREF;
	}
	
	//Empty main function
	public static void main(String[] args) throws Exception{
	}


	//...............................SQL FUNCTIONS BEGIN........................................//
	
	//To insert student details into student table
	void insertStudentDetails(String uid,String name,int std,String section) throws SQLException{
		
		uid = uid.toUpperCase();
		name = resourceFunctions.capitalize(name);
		db.st.execute("insert into studentDetails VALUES(\""+ uid + "\",\"" + name + "\"," + std + ",\"" + section + "\");");
		db.st.close();
	}
	//...............................SQL FUNCTIONS END........................................//
}



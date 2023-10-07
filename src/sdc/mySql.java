package sdc;

import java.sql.*;
import sdc.resource.*;

public class mySql {

	//Connection and statement object for SQL
	database_setup db;
	//Establising connection in constructor
	public mySql(database_setup databaseREF) throws Exception{
		db = databaseREF;
	}
	
	//Empty main function
	public static void main(String[] args) throws Exception{

	}


	//...............................SQL FUNCTIONS BEGIN........................................//

	//TYPE CODE:
	/*
	 * 0 - administrator
	 * 1 - student
	 * 2 - teacher
	 */


	//Student registration
	public void createNewStudent(String uid,String name,int std,String section,Date dob, String f_name, String m_name, String phn_num, String password) throws SQLException{
		
		uid = uid.toLowerCase();
		name = resourceFunctions.capitalize(name);

			PreparedStatement insertDetails = db.con.prepareStatement("insert into studentDetails VALUES(?,?,?,?,?,?,?,?,?);");
			//inserting data into studentDetails table
			insertDetails.setString(1, uid);
			insertDetails.setString(2,name);
			insertDetails.setInt(3,std);
			insertDetails.setString(4,section);
			insertDetails.setDate(5, dob);
			insertDetails.setString(6, f_name);
			insertDetails.setString(7,m_name);
			insertDetails.setString(8,phn_num);
			insertDetails.setInt(9,1);
			insertDetails.execute();

			//Creating the student user
			PreparedStatement createUser = db.con.prepareStatement("CREATE USER IF NOT EXISTS ?@'%' IDENTIFIED BY ?");
			createUser.setString(1, uid);
			createUser.setString(2,password);
			createUser.execute();

			//Granting permissions to student
			PreparedStatement setPermissions = db.con.prepareStatement("GRANT SELECT ON studentDetails TO ?@'%' ");
			setPermissions.setString(1,uid);
			setPermissions.execute();
		
	}

	//Teacher registration
	public void createNewTeacher(String uid, String name, String classes,String classTeacherOf, String subjects,String password)throws SQLException{
		uid = uid.toLowerCase();

			//Inserting data into teacherDetails table
			PreparedStatement insertTeacherDetails = db.con.prepareStatement("insert into teacherDetails VALUES(?,?,[?],[?],[?],?)");
			insertTeacherDetails.setString(1,uid);
			insertTeacherDetails.setString(2,name);
			insertTeacherDetails.setString(3,classes);
			insertTeacherDetails.setString(4,classTeacherOf);
			insertTeacherDetails.setString(5,subjects);
			insertTeacherDetails.setInt(6,2);
			insertTeacherDetails.execute();

			//Creating teacher user
			PreparedStatement createUser = db.con.prepareStatement("CREATE USER IF NOT EXISTS ?@'%'  IDENTIFIED BY ?");
			createUser.setString(1,uid);
			createUser.setString(2,password);
			createUser.execute();

			//Granting permission to teacher
			PreparedStatement setPermissions = db.con.prepareStatement("GRANT ALL ON *.* TO ?@'%' WITH GRANT OPTION");
			setPermissions.setString(1,uid);
			setPermissions.execute();

		}
		// catch(Exception e){
		// 	//Deleting the user
		// 	System.out.println(e.getMessage());
		// 	PreparedStatement deleteUser = db.con.prepareStatement("DELETE FROM teacherDetails WHERE uid = ?");
		// 	deleteUser.setString(1,uid);
		// 	deleteUser.execute();

		// 	// db.st.execute("FLUSH PRIVELGES");
		// }

	//function to read student details form database
	public ResultSet getUserDetails(String uid, int type) throws Exception,SQLException{
		ResultSet userDetails = null;
		PreparedStatement getDetails = null;

			switch(type){
				case 0:
					getDetails = db.con.prepareStatement("select * from administratorDetails where uid = ?");
				break;
				case 1: 
					getDetails = db.con.prepareStatement("select * from studentDetails where uid = ?");
				break;
				case 2: 
					getDetails = db.con.prepareStatement("select * from teacherDetails where uid = ?");
				break;
				default:
					throw new Exception("1542");
			}


				getDetails.setString(1,uid);
				userDetails = getDetails.executeQuery();
		//To access from studentDetails use studentDetails.getString("label name");
		return userDetails;
	}


		//test main function
	public static void main(String uid){
		
	}

	//Closing database connection
	void closeConnection(){
		try{
			System.out.println("Connection Closed");
			db.con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	//...............................SQL FUNCTIONS END........................................//
}



package sdc;
import java.sql.ResultSet;
import java.sql.SQLException;

import sdc.screens.*;

public class client  {
    
    public static database_setup db;
    public static mySql mySql;
    public static String username = "";
    public static String password = "";
    public static int type = -1;
    public static  loginPage login; 
    public static ResultSet result;
    //Screens


    public static void main(String[] args) {
        try{
            //Trying to connect to database
            login = new loginPage();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    //To retry connecting to database in case of error
    public static void connectToDB() throws Exception,SQLException,ClassNotFoundException{
        //Connecting to database
        db = null;
        db = new database_setup(username,password);

        mySql = new mySql(db);
        result = mySql.getUserDetails(username,type);

        if(result.next()){
            System.out.println(result.getString(1));
        }
        else{
            throw new SQLException("User not found","1555",1555);
        }
    }

    public static void frame(){
            //Interface
        //Establising control
        try {

            if(result !=null){
                if(type == 0){}
                else if(type == 1){}
                else if(type == 2)
                    new teacherInterface();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in client.java -> connectToDb()");
        }
    }
}
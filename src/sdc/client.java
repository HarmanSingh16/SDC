package sdc;
import java.sql.SQLException;

import sdc.screens.*;

public class client {
    
    public static database_setup db;
    public static mySql mySql;
    public static String username = "";
    public static String password = "";
    public static  loginPage login; 
    public static intrfc scr;
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
    public static void connectToDB() throws SQLException,ClassNotFoundException{
        //Connecting to database
        db = null;
        db = new database_setup(username,password);

        //Establising control
        try {
            mySql = new mySql(db);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void frame(){
            //Interface
            try{
                scr = new intrfc(mySql);
                scr.createFrame();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
    }

    public static void diposeIntrfc(){
        scr.dispose();
    }
}
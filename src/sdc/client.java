package sdc;

public class client {

    public static void main(String[] args) {


        database_setup db;
        try{
            //Trying to connect to database
            db =  new database_setup();
            mySql sql = new mySql(db);

            //Interface
            intrfc scr = new intrfc(sql);
            scr.createFrame();
        }
        catch(Exception e){
            //Handle exception related to database connectivity here
        }
    }
}

package sdc.resource;
import java.sql.DriverManager;

import sdc.database_setup;

public class errorMessage{

    public static String getMessage(int n){

        String error = "";
        switch(n){
            case 3819:
                error = "Incorrect / Incomplete detail format !";
            break;
            case 1406:
                error = "UID Exceeds limit !";
            break;
            case 1062:
                error = "Duplicate Entry !";
            break;
            case 1045:
                error = "Incorrect UID or Password !";
            break;
            case 1142:
                error= "Access denied !";
            break;
            case 0:
                error = "Connection failed. Do you want to retry ?";
            break;
            case 1542:
                error = "Incorrect type !";
            break;
            case 1555:
                error = "User not found !";
            break;
            case 1146:
                error = "User type not found !";
            break;
            case 1044:
                error = "Access Denied to database !";
            break;
            default:
                error = "Unhandled Exception !";
        }
        return error;
    }
}

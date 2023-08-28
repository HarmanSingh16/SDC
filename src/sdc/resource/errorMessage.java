package sdc.resource;

public class errorMessage{

    public static String getMessage(int n){

        String error = "";
        switch(n){
            case 3819:
                error = "Incorrect/Incomplete detail format";
            break;
            case 1406:
                error = "UID Exceeds limit";
            break;
            case 1062:
                error = "Duplicate Entry";
            break;
            default:
                error = "Unhandled Exception";
        }
        return error;
    }
}

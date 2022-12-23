package my_exceptions;

public class NoVehiculeException extends RuntimeException{
    public NoVehiculeException(){
        super();
    }
    public NoVehiculeException(String message){
        super(message);
    }
}

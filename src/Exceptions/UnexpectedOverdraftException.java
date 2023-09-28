package Exceptions;

public class UnexpectedOverdraftException extends Exception{
    public UnexpectedOverdraftException(String uniqueID){
        super("Transaction failed, caused unexpected overdraft in origin account: " + uniqueID);
    }
}

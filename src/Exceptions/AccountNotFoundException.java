package Exceptions;

public class AccountNotFoundException extends Exception{

    public AccountNotFoundException() {
        super("Could not find account");
    }

}

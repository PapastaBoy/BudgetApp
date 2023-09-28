import Exceptions.InvalidAmountException;
import Exceptions.UnexpectedOverdraftException;

import java.util.Random;

/**
 * The standard Account class is used to control each account in the app.
 * Account stores an account number that is randomly generated using {@link Random}
 * and ascii conversion to generate a unique and secure ID.
 * Also stores the balance in the account currently and all transactions made before committing
 * them to a csv file for later use/retrieval
 * @see java.util.Random
 */
public class Account {

    // Unique identifier per account
    private final String uniqueIdentity;
    // Balance stored in account
    int accNum;
    int sortcode;
    double accountBal;
    double overdraft = 0;

    /**
     * Constructor
     *
     * @implNote This constructor is used to initialise all accounts
     * with an initialBal and uniqueIdentity. Account number is generated
     * randomly and is unique to each account.
     * <br><br>
     * A secondary version of the constructor exists for if an account has
     * been made and the account has a pre-arranged overdraft
     */
    public Account(double initialBal, int accNum, int sortcode) {

        accountBal = initialBal;
        uniqueIdentity = accIdentityGen();
    }
    
    public Account(double initialBal, int accNum, int sortcode, double allowedOverdraft) {

        accountBal = initialBal;
        uniqueIdentity = accIdentityGen();
        overdraft = allowedOverdraft;
    }

    /**
     * Used to fetch the account number from the account
     * @return String
     */
    public String getUniqueIdentity() {
        return uniqueIdentity;
    }

    /**
     * Adds the given value to the accountBal.
     * Throws {@link InvalidAmountException} if the value given is not greater than zero
     * @param amount
     * @throws InvalidAmountException
     */
    public void addBal(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0.00");
        }
        accountBal += amount;
    }

    /**
     * Removes the amount given from the current account balance <br>
     * Throws {@link UnexpectedOverdraftException} if the value given greater than the accountBalance
     * @param amount
     * @throws UnexpectedOverdraftException
     */
    public void remBal(double amount) throws UnexpectedOverdraftException {
        if (amount <= 0) {
            try {
                throw new InvalidAmountException("Amount must be greater than 0.00");
            } catch (InvalidAmountException e) {
                throw new RuntimeException(e);
            }
        }
        if (amount > accountBal) throw new UnexpectedOverdraftException(uniqueIdentity);
        accountBal -= amount;
    }

    /**
     * uses {@link Random} to generate ascii values to be sent
     * to a stringBuilder to generate a unique and secure account
     * number.
     * @return String
     */
    @org.jetbrains.annotations.NotNull
    public String accIdentityGen() {
        // Create random seed
        Random random = new Random();

        // Bind the random number to be within the valid characters
        int num = random.nextInt(48, 122);
        while (num >= 58 && num <= 64 || num >= 91 && num <= 96)
            num = random.nextInt(48, 122);

        // Create a string by casting the number generated to a char value, and string buld it to an empty string to generate an accnum
        StringBuilder stringBuilder = new StringBuilder(Character.toString((char) num));
        for (int i = 0; i < 23; i++) {
            num = random.nextInt(48, 122);
            while (num >= 58 && num <= 64 || num >= 91 && num <= 96)
                num = random.nextInt(48, 122);
            stringBuilder.append((char) num);
        }

        return stringBuilder.toString();
    }
}

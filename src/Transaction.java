import Exceptions.AccountNotFoundException;
import Exceptions.InvalidAmountException;
import Exceptions.UnexpectedOverdraftException;

/**
 * The standard Transaction class is used to take record of a single transactions details,
 * this includes transaction origin account, transaction amount, transaction receiver,
 * transaction reference, and a {@link TransactionType} enum.
 * @see TransactionType
 * @see Account
 */
public class Transaction {
    Account origin;
    double amount;
    Account receiver;
    String reference;
    TransactionType t;
    boolean failed = false;

    /**
     * Constructor
     *
     * @implNote This constructor is used to initialise a transaction
     * with an account origin, amount, account reciever, reference, and {@link TransactionType}
     */
    public Transaction(Account origin, double amount, Account receiver, @org.jetbrains.annotations.NotNull String reference, TransactionType type) throws UnexpectedOverdraftException, InvalidAmountException {
        this.origin = origin;
        this.amount = amount;
        this.receiver = receiver;
        this.reference = reference.substring(0, Math.min(20, reference.length()));
        this.t = type;

        updateAccounts();
    }

    private void updateAccounts() throws UnexpectedOverdraftException, InvalidAmountException {
        if (origin.accountBal < amount) {
            failed = true;
            throw new UnexpectedOverdraftException(origin.getUniqueIdentity());
        }
        origin.remBal(amount);
        receiver.addBal(amount);

        System.out.println("successfully created transaction between account " + origin.getUniqueIdentity() +
                " and account " + receiver.getUniqueIdentity() + " for reference " + reference + " of type " + t.toString());
    }
}

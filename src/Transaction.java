/**
 * The standard Transaction class is used to take record of a single transactions details,
 * this includes transaction origin account, transaction amount, transaction receiver,
 * transaction reference, and a {@link TransactionType} enum.
 * @see TransactionType
 * @see Account
 */
public class Transaction {
    Account origin;
    int amount;
    Account receiver;
    String reference;
    TransactionType t;

    /**
     * Constructor
     *
     * @implNote This constructor is used to initialise a transaction
     * with an account origin, amount, account reciever, reference, and {@link TransactionType}
     */
    public Transaction(Account origin, int amount, Account receiver, @org.jetbrains.annotations.NotNull String reference, TransactionType type) {
        this.origin = origin;
        this.amount = amount;
        this.receiver = receiver;
        this.reference = reference.substring(0, Math.min(20, reference.length()));
        this.t = type;
    }
}

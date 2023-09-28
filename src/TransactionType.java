/**
 * An enumerator that will be used to determine the type of transaction recorded
 * @implNote <strong>RETAIL</strong> - Refers to transactions performed with shops
 *   <br>    <strong>FOOD</strong> - Refers to transactions performed with restaurants or takeouts
 *   <br>    <strong>BILLS</strong> - Refers to regularly occurring transactions for living in a home
 *   <br>    <strong>TRANSFER</strong> - Refers to a transaction with another human account
 *   <br>    <strong>SUBSCRIPTION</strong> - Refers to regularly occurring transactions for a service
 *   <br>    <strong>CREDIT</strong> - Refers to transactions made to pay off credit cards/loans
 */

public enum TransactionType {
    RETAIL,
    FOOD,
    BILLS,
    TRANSFER,
    SUBSCRIPTION,
    CREDIT
}

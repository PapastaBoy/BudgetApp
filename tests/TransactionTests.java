import Exceptions.AccountNotFoundException;
import Exceptions.InvalidAmountException;
import Exceptions.UnexpectedOverdraftException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TransactionTests {
    ArrayList<Account> accounts = new ArrayList<>(Arrays.asList(
            new Account(1000, 12341234, 889988),
            new Account(2000, 11223344, 889988),
            new Account(10000, 98769876, 889988),
            new Account(-100, 87654321, 889988,  -1000)
    ));

    @Test
    public void createTransactionTest() {
        // Test for exception when trying to enter unexpected overdraft
        Exception exception = Assert.assertThrows(UnexpectedOverdraftException.class, () -> {
            Transaction t = new Transaction(accounts.get(0), 1001, accounts.get(1), "test", TransactionType.TRANSFER);
            // Test that transaction failed
            Assert.assertTrue(t.failed);
            // Test that account balances were unaffected
            Assert.assertEquals(1000, accounts.get(0).accountBal, 0.001);
            Assert.assertEquals(2000, accounts.get(1).accountBal, 0.001);
        });


        // Test that exception message was received correctly
        Assert.assertTrue(exception.getMessage().contains("Transaction failed, caused unexpected overdraft"));

        Transaction t;

        try {
            t = new Transaction(accounts.get(0), 1000, accounts.get(1), "test", TransactionType.TRANSFER);
        } catch (UnexpectedOverdraftException | InvalidAmountException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(0, accounts.get(0).accountBal, 0.001);
        Assert.assertEquals(3000, accounts.get(1).accountBal, 0.001);
        Assert.assertFalse(t.failed);


    }

}

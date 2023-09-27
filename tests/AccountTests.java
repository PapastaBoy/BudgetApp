import Exceptions.InvalidAmountException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AccountTests {

    @Test
    public void testAccount() {
        Account test = new Account(1000);

        Assert.assertEquals(1000, test.accountBal, 0.01);
        Assert.assertFalse(test.getAccountNum().isBlank());
    }

    @Test
    public void testAddBal() {
        Account test = new Account(1000);
        Exception exception = Assert.assertThrows(InvalidAmountException.class, () -> {
            test.addBal(-1);
        });

        String expectedMessage = "Amount must be greater than 0.00";

        Assert.assertTrue(exception.getMessage().contains(expectedMessage));
    }
}

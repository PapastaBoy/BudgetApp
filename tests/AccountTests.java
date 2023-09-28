import Exceptions.InvalidAmountException;
import org.junit.Assert;
import org.junit.Test;

public class AccountTests {

    @Test
    public void testAccount() {
        Account test = new Account(1000, 12341234, 889988);

        Assert.assertEquals(1000, test.accountBal, 0.01);
        Assert.assertFalse(test.getUniqueIdentity().isBlank());
    }

    @Test
    public void testAddBal() {
        Account test = new Account(1000, 12341234, 889988);
        Exception exception = Assert.assertThrows(InvalidAmountException.class, () -> {
            test.addBal(-1);
        });

        String expectedMessage = "Amount must be greater than 0.00";

        Assert.assertTrue(exception.getMessage().contains(expectedMessage));
    }
}

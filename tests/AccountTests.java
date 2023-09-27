import org.junit.Assert;
import org.junit.Test;

public class AccountTests {

    @Test
    public void testAccount() {
        Account test = new Account(1000);

        Assert.assertEquals(1000, test.accountBal, 0.01);
        Assert.assertFalse(test.getAccountNum().isBlank());

    }
}

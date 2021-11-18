package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bank.models.LoginDetails;
import com.bank.models.TransferDetails;
import com.bank.models.UserDetails;
import com.bank.services.ExecutionService;
import com.bank.services.TransferDetailsDAOImpl;
import com.bank.services.UserOperationDAOImpl;

public class LoginExecutionTest {
	static ExecutionService  exeuService = null;
	static LoginDetails loginDetails = null;
	
	@BeforeClass
    public static void initCalculator() {
        exeuService = new ExecutionService();
        loginDetails = new LoginDetails();
        loginDetails.setUserID(1);
        loginDetails.setPassword("admin");
    }
 
    @Before
    public void beforeEachTest() {
        System.out.println("This is executed before each Test");
    }
 
   
    @Test
    public void testUserLogin() {
    	assertEquals(true,exeuService.validUser(loginDetails));
    }
    
    @Test
    public void testUserCreation() {
    	UserOperationDAOImpl userImpl = new UserOperationDAOImpl();
		UserDetails userDetails = new UserDetails();
		userDetails.setUserID(106);
		userDetails.setRouterNumber(32000065);
		userDetails.setFirstName("veera");
		userDetails.setLastName("veera");
		userDetails.setAddress("76-11 47th Ave Elmhurst NY 11373");
		userDetails.setDateOfBirth(new Date("01/11/2000"));
		userDetails.setContact(9293345560l);
		userDetails.setEmail("admin@gmail.com");
		userDetails.setAccountType("Admin");
		userDetails.setAccountNumber(System.currentTimeMillis());
		//userDetails.setAccountNumber(0);
		userDetails.setProofOfID("Telephone Bill");
		userDetails.setEmergencyContact(9295330001l);
		userDetails.setPassword("veera");
		userDetails.setUserType("Admin");
		userDetails.setStatus("Active");
				
		assertEquals(true, userImpl.save(userDetails));
    }
    
    public void testDepositTransaction() {
    	TransferDetails transferdetails = new TransferDetails();
		transferdetails.setTransactionRefID(3);
		transferdetails.setRouterNumber(32000065);
		transferdetails.setFromAccount(0);
		transferdetails.setToAccount(0);
		transferdetails.setAmount(4000);
		transferdetails.setTransferType("deposit");
		transferdetails.setUserId(1);
		TransferDetailsDAOImpl tdImpl = new TransferDetailsDAOImpl();
		assertEquals(true, tdImpl.save(transferdetails));

    }
	 
	    
}

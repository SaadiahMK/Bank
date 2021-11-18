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
		userDetails.setUserID(2026);
		userDetails.setRouterNumber(453297450);
		userDetails.setFirstName("Cynthia");
		userDetails.setLastName("William");
		userDetails.setAddress("83-23 45th Ave East Elmhurst NY 11373");
		userDetails.setDateOfBirth(new Date("03/11/2003"));
		userDetails.setContact(9290002233l);
		userDetails.setEmail("cynthia44@gmail.com");
		userDetails.setAccountType("Client");
		userDetails.setAccountNumber(System.currentTimeMillis());
		//userDetails.setAccountNumber(0);
		userDetails.setProofOfID("Passpost");
		userDetails.setEmergencyContact(9290224444l);
		userDetails.setPassword("Rest01");
		userDetails.setUserType("Client");
		userDetails.setStatus("Active");
				
		assertEquals(true, userImpl.save(userDetails));
    }
    
    public void testDepositTransaction() {
    	TransferDetails transferdetails = new TransferDetails();
		transferdetails.setTransactionRefID(111);
		transferdetails.setRouterNumber(453297450);
		transferdetails.setFromAccount(1637258522639l);
		transferdetails.setToAccount(1637258897971l);
		transferdetails.setAmount(400);
		transferdetails.setTransferType("transfer");
		transferdetails.setUserId(2233);
		TransferDetailsDAOImpl tdImpl = new TransferDetailsDAOImpl();
		assertEquals(true, tdImpl.save(transferdetails));

    }
	 
	    
}

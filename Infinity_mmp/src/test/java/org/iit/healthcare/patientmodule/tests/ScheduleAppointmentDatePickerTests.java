package org.iit.healthcare.patientmodule.tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.HashMap;
import org.iit.healthcare.mmp.pages.Homepage;
import org.iit.healthcare.mmp.pages.ScheduleAppoinmentPage;
import org.iit.healthcare.mmp.util.BaseClass;
import org.iit.healthcare.mmp.util.MMPLib;
import org.testng.asserts.SoftAssert;




public class ScheduleAppointmentDatePickerTests extends BaseClass{

	
	//JSON : java script object notation
		@Parameters({"username","password"})
		@Test
		public void scheduleAppointmentTest(String username,String password)
		{
		 
			
		    MMPLib mmpLib = new MMPLib(driver);
		    mmpLib.launchBrowser(mmpProp.getProperty("patienturl"));
		    Homepage hPage = mmpLib.loginValidUser(username, password);
		    String actual = hPage.getPatientName(mmpProp.getProperty("patientusername"));
			String expected=mmpProp.getProperty("patientusername");
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actual,expected);
			
			ScheduleAppoinmentPage sPage = new ScheduleAppoinmentPage(driver);
			HashMap<String,String> expectedHMap = sPage.bookAppoinment(40);
			HashMap<String,String> actualHMap = hPage.fetchPatientData();
			System.out.println(expectedHMap);
			System.out.println(actualHMap);
			
			sa.assertEquals(actualHMap,expectedHMap);
			
			sa.assertAll();
		}
		 
		 
		 
	}
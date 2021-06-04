package test;

import com.HospitalManage.service.ShiftService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShiftServiceTest {

    private ShiftService shiftService;

    @Before
    public void initialization(){
        shiftService = new ShiftService();
    }

    @Test
    public void testGetDetails(){
        String testRes = shiftService.getNurseShiftDetailsByShiftCode("s1_1");
        Assert.assertTrue(testRes.length()>0);
    }
}

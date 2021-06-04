package test;

import com.HospitalManage.service.WardService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WardTest {

    private WardService wardService;
    @Before
    public void initialization(){
        wardService = new WardService();
    }

    @Test
    public void testGetMap(){
        Assert.assertTrue(wardService.getPatientMap().size()>0);
    }
}

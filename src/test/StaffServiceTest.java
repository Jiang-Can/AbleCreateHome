package test;

import com.HospitalManage.bean.staff.Job;
import com.HospitalManage.bean.staff.Staff;
import com.HospitalManage.service.StaffService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StaffServiceTest {

    private StaffService staffService;

    @Before
    public void initialization(){
        staffService = new StaffService();
    }

    @Test
    public void testGetStaffById(){
        Staff staff = staffService.getStaffById(1);
        assertTrue(staff.getId() == 1);
    }

}

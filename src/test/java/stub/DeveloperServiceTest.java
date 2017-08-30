package stub;

import com.testlab.demo.stub.DeveloperResponse;
import com.testlab.demo.stub.DeveloperService;
import com.testlab.demo.stub.DeveloperServiceImpl;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeveloperServiceTest {
    private DeveloperService developerService;
    @Test
    public void whenConnectionRefusedDeveloperIsNotSaved() {
          developerService = new DeveloperServiceImpl(new ConnectionRefusedDAOStub());

//        developerService = mock(DeveloperService.class);
//        DeveloperResponse refusedConnectionResp = new DeveloperResponse(
//                "Connection refused(DESCRIPTION=(TMP=)(VSNNUM=153093632)(ERR=12514)(ERROR_STACK=(ERROR=(CODE=12514)(EMFI=4))))",
//                null);
//        when(developerService.create(any(String.class),any(String.class))).thenReturn(refusedConnectionResp);

        String sprintTeam = "Ironhide";
        String aaronLi = "Aaron Li";
        DeveloperResponse resp = developerService.create(aaronLi, sprintTeam);
        assertFalse(resp.isSuccess());
    }
}

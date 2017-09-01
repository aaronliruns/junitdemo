package dummy;

import com.testlab.demo.dummy.Assessment;
import com.testlab.demo.dummy.DevLead;
import com.testlab.demo.dummy.Developer;
import com.testlab.demo.dummy.Result;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
//Let's import Mockito statically so that the code looks clearer
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AssessmentTest {

    @Test
    public void averageRateHigerThanNinety() {
        DummyDeveloper dummyDeveloper = new DummyDeveloper("1572000","someOne");
        //Developer mockitoDeveloper = mock(DummyDeveloper.class);

        Assessment coreJava = new Assessment(dummyDeveloper,"corejava", new BigDecimal("90.0"));
        Assessment es6      = new Assessment(dummyDeveloper,"es6", new BigDecimal("91.0"));
        Assessment html5    = new Assessment(dummyDeveloper,"html5", new BigDecimal("95.2"));

        List<Assessment> loa = Arrays.asList(coreJava, es6, html5);
        Result r = new DevLead().assess(loa);

        assertEquals(Result.Excellent, r);
    }
}

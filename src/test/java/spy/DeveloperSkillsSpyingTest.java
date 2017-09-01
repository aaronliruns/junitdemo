package spy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperSkillsSpyingTest {

    //@Spy
    //List<String> spySkillList = new ArrayList<String>();
    List<String> spySkillList = Mockito.spy(ArrayList.class);


    @Test
    public void testSkillsAdded() {
        spySkillList.add("Java");
        spySkillList.add("Javascript");

        //Behavior
        Mockito.verify(spySkillList).add("Java");
        Mockito.verify(spySkillList).add("Javascript");

        //Result
        assertEquals(2, spySkillList.size());
    }



}

package mock;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DeveloperSkillsMockingTest {


    List<String> spySkillList = Mockito.mock(ArrayList.class);


    @Test
    public void testSkillsAdded() {
        spySkillList.add("Java");
        spySkillList.add("Javascript");

        //Behavior
        Mockito.verify(spySkillList).add("Java");
        Mockito.verify(spySkillList).add("Javascript");

        //Result
        //WE EXPECT 0 HERE
        assertEquals(0, spySkillList.size());
    }
}

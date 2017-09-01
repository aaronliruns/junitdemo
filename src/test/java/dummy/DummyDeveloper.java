package dummy;

import com.testlab.demo.dummy.Developer;

public class DummyDeveloper extends Developer {
    public DummyDeveloper(String psid, String name) {
        super(psid, name);
    }

    @Override
    public void writeVeryComplicatedCode() {
        throw new RuntimeException("Sorry, not implemented.");
    }

    @Override
    public void writeUnitTests() {
        throw new RuntimeException("Sorry, not implemented.");
    }

    @Override
    public void getSomeBeersAfterWork() {
        throw new RuntimeException("Sorry, not implemented.");
    }
}

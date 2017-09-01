package fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import com.testlab.demo.fake.Developer;
import com.testlab.demo.fake.DeveloperDaoImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class DeveloperDaoTest {
    //Test method name convention
    //https://dzone.com/articles/7-popular-unit-test-naming

    TestableDeveloperDao dao;
    Map<String, Integer> sqlCount = null;

    @Before
    public void setup() {
        dao = new TestableDeveloperDao();
        sqlCount = new HashMap<String, Integer>();
    }

    @Test(expected = IllegalStateException.class)
    public void when_row_count_does_not_match_then_rollbacks_tarnsaction() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(null, "Aaron Li"));

        int[] expect_update_fails_count = {0};
        dao.valuesToReturn = expect_update_fails_count;

        dao.batchUpdate(developers);

    }

    @Test
    //Not a very good test method name
    public void testCreateNewDeveloper() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(null, "Aaron Li"));
        int[] expect_update_success = {1};
        dao.valuesToReturn = expect_update_success;
        dao.batchUpdate(developers);
        int actualInsertCount = sqlCount.get("insert");
        int expectedInsertCount = 1;
        assertEquals(expectedInsertCount, actualInsertCount);

    }

    @Test
    public void when_existing_developer_then_updates_developer_successfully() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("001", "American Captain"));
        int[] expect_update_success = {1};
        dao.valuesToReturn = expect_update_success;

        dao.batchUpdate(developers);
        int actualUpdateCount = sqlCount.get("update");
        int expectedUpdate = 1;
        assertEquals(expectedUpdate, actualUpdateCount);
    }

    @Test
    public void when_new_and_existing_developers_then_creates_and_updates_developers() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("001", "Hello Kitty"));
        developers.add(new Developer(null, ""));
        developers.add(new Developer("002", "American Captain"));

        dao.batchUpdate(developers);
        int actualUpdateCount = sqlCount.get("update");
        int expectedUpdate = 2;
        assertEquals(expectedUpdate, actualUpdateCount);
    }

    class TestableDeveloperDao extends DeveloperDaoImpl {
        int[] valuesToReturn;

        @Override
        public int[] update(String sql, List<Map<String, Object>> params) {
            Integer count = sqlCount.get(sql);
            if (count == null) {
                sqlCount.put(sql, params.size());
            } else {
                sqlCount.put(sql, count + params.size());
            }

            if (valuesToReturn != null) {
                return valuesToReturn;
            }

            int[] val = new int[params.size()];
            for (int i = 0; i < params.size(); i++) {
                val[i] = 1;
            }
            return val;
        }

    }
}

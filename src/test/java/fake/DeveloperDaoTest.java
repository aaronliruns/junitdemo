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

    TestableDeveloperDao dao;
    Map<String, Integer> sqlCount = null;

    @Before
    public void setup() {
        dao = new TestableDeveloperDao();
        sqlCount = new HashMap<String, Integer>();
    }

    @Test(expected = IllegalStateException.class)
    @Ignore
    public void when_row_count_does_not_match_then_rollbacks_tarnsaction() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer(null, "Gautam Kohli"));

        int[] expect_update_fails_count = {0};
        dao.valuesToReturn = expect_update_fails_count;

        dao.batchUpdate(developers);

    }

    @Test
    public void when_new_student_then_creates_student() {
        List<Developer> students = new ArrayList<>();
        students.add(new Developer(null, "Gautam Kohli"));
        int[] expect_update_success = {1};
        dao.valuesToReturn = expect_update_success;

        dao.batchUpdate(students);
        int actualInsertCount = sqlCount.get("insert");
        int expectedInsertCount = 1;
        assertEquals(expectedInsertCount, actualInsertCount);

    }

    @Test
    @Ignore
    public void when_existing_student_then_updates_student_successfully() {
        List<Developer> students = new ArrayList<>();
        students.add(new Developer("001", "Mark Leo"));
        int[] expect_update_success = {1};
        dao.valuesToReturn = expect_update_success;

        dao.batchUpdate(students);
        int actualUpdateCount = sqlCount.get("update");
        int expectedUpdate = 1;
        assertEquals(expectedUpdate, actualUpdateCount);
    }

    @Test
    @Ignore
    public void when_new_and_existing_students_then_creates_and_updates_students() {
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("001", "Mark Joffe"));
        developers.add(new Developer(null, "John Villare"));
        developers.add(new Developer("002", "Maria Rubinho"));

        dao.batchUpdate(developers);
        int actualUpdateCount = sqlCount.get("update");
        int expectedUpdate = 2;
        assertEquals(expectedUpdate, actualUpdateCount);
    }

    class TestableDeveloperDao extends DeveloperDaoImpl {
        int[] valuesToReturn;

        int[] update(String sql, List<Map<String, Object>> params) {
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

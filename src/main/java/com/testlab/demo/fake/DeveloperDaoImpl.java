package com.testlab.demo.fake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DeveloperDaoImpl implements DeveloperDao {

    public DeveloperDaoImpl() {
    }

    @Override
    public void batchUpdate(List<Developer> developers) {

        List<Developer> insertList = new ArrayList<>();
        List<Developer> updateList = new ArrayList<>();

        for (Developer developer : developers) {
            if (developer.getPsid() == null) {
                insertList.add(developer);
            } else {
                updateList.add(developer);
            }
        }

        int rowsInserted = 0;
        int rowsUpdated = 0;
        if (!insertList.isEmpty()) {
            List<Map<String, Object>> paramList = new ArrayList<>();
            for (Developer dev : insertList) {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("name", dev.getName());
                paramList.add(param);
            }
            int[] rowCount = update("insert", paramList);
            rowsInserted = sum(rowCount);
        }

        if (!updateList.isEmpty()) {
            List<Map<String, Object>> paramList = new ArrayList<>();
            for (Developer dev : updateList) {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("psid", dev.getPsid());
                param.put("name", dev.getName());
                paramList.add(param);
            }
            int[] rowCount = update("update", paramList);
            rowsUpdated = sum(rowCount);
        }

        if (developers.size() != (rowsInserted + rowsUpdated)) {
            throw new IllegalStateException("Database update error, expected "
                    + developers.size() + " updates but actual "
                    + (rowsInserted + rowsUpdated));
        }

    }

    public int[] update(String sql, List<Map<String, Object>> params) {
        return new JdbcSupport().batchUpdate(sql, params);
    }

    private int sum(int[] rows) {
        int sum = 0;
        for (int val : rows) {
            sum += val;
        }
        return sum;
    }
}

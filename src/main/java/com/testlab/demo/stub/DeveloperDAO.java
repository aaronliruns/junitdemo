package com.testlab.demo.stub;

import java.sql.SQLException;

public interface DeveloperDAO {
    public String create(String name, String nameOfSprintTeam)
            throws SQLException;
}

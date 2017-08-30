package com.testlab.demo.stub;

import com.testlab.demo.dummy.Developer;

import java.sql.SQLException;

public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperDAO developerDAO;

    public DeveloperServiceImpl(DeveloperDAO developerDAO) {
        this.developerDAO = developerDAO;
    }

    @Override
    public DeveloperResponse create(String name, String nameOfSprintTeam) {
        DeveloperResponse response = null;
        try {
            int psid = developerDAO.create(name, nameOfSprintTeam);
            response = new DeveloperResponse(null, new Developer(psid, nameOfSprintTeam));
        } catch (SQLException e) {
            response = new DeveloperResponse("SQLException" + e.getMessage(), null);
        } catch (Exception e) {
            response = new DeveloperResponse(e.getMessage(), null);
        }
        return response;
    }
}

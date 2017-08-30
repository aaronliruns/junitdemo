package stub;

import com.testlab.demo.stub.DeveloperDAO;

import java.sql.SQLException;

public class ConnectionRefusedDAOStub implements DeveloperDAO {
    @Override
    public int create(String name, String nameOfSprintTeam) throws SQLException {
        throw new SQLException("Connection refused(DESCRIPTION=(TMP=)(VSNNUM=153093632)(ERR=12514)(ERROR_STACK=(ERROR=(CODE=12514)(EMFI=4))))");
    }
}

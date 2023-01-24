package org.example.Nothing;

import org.example.dao.Db;
import java.sql.Connection;
import java.sql.SQLException;

public class Know {
    private final Connection connection;

    public Know() throws SQLException {
        connection = new Db().getConnection();
    }
}

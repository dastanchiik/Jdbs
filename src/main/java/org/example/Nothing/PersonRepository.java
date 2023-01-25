package org.example.Nothing;

import org.example.Example;

import java.sql.SQLException;

public interface PersonRepository {
    void createTable() throws SQLException;
    void save(Example example) throws SQLException;
}
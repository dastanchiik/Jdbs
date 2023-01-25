package org.example.Nothing;

import org.example.Example;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PersonRepository {
    void createTable() throws SQLException;
    void save(Example example) throws SQLException;
    ArrayList<Example> findAll () throws SQLException;
    void deleteAll () throws SQLException;
}
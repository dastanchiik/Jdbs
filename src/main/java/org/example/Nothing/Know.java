package org.example.Nothing;

import org.example.Example;
import org.example.dao.Db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Know implements PersonRepository{
    private final Connection connection;

    public Know() throws SQLException {
        connection = new Db().getConnection();
    }

    @Override
    public void createTable() throws SQLException {
    String create = """
     create table if not exists person(
        id serial primary key,
        name varchar(55)  not null,
        age smallint
        );
   """;
        Statement statement = connection.createStatement();
        statement.execute(create);
        statement.close();
        System.out.println("Yoooooo");
    }

    @Override
    public void save(Example example) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into person(name, age) values (?,?)");
        ps.setString( 1,example.getName() );
        ps.setInt( 2,example.getAge() );
        ps.execute();
        ps.close();
        System.out.println("saved");

    }

}

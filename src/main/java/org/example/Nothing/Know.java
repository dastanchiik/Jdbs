package org.example.Nothing;

import org.example.Example;
import org.example.dao.Db;

import java.sql.*;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Example> findAll() throws SQLException {
    ArrayList<Example>list = new ArrayList<>();
    Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from person ;");
        while (resultSet.next()){
            Example example = new Example();
            example.setId(resultSet.getInt("id"));
            example.setName(resultSet.getString("name"));
            example.setAge(resultSet.getInt("age"));
            list.add(example);
        }
        return list;
    }


}

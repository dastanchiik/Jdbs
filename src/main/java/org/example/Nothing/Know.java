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
        String sql = """
                create table if not exists people(
                id serial primary key,
                name varchar ,
                age integer
                );
                """;
        Statement st = connection.createStatement();
        st.executeUpdate(sql);
        System.out.println("siuuuuuu");
        st.close();
    }

    @Override
    public void save(Example example) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("insert into people (name,age) values (?,?)");
        ps.setString(1,example.getName());
        ps.setInt(2,example.getAge());
        ps.execute();
    }

    @Override
    public ArrayList<Example> findAll() throws SQLException {
        ArrayList<Example>list = new ArrayList<>();
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery("select * from people");
        while (resultSet.next()){
            Example example = new Example();
            example.setId(resultSet.getInt("id"));
            example.setName(resultSet.getString("name"));
            example.setAge(resultSet.getInt("age"));
            list.add(example);
        }
        return list;
    }

    @Override
    public void deleteAll() throws SQLException {
        Statement st = connection.createStatement();
        st.execute("truncate table people");
        System.out.println("deleted");
    }
}

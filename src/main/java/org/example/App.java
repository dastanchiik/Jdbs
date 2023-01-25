package org.example;

import org.example.Nothing.Know;
import org.example.Nothing.PersonRepository;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws SQLException {
    Example example = new Example(1,"gsdjh",12);
        Know know = new Know();
    know.deleteAll();
    }
}

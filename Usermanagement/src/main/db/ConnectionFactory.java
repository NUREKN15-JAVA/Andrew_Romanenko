package main.db;

import java.sql.Connection;

/**
 * Author andy_
 * created 03.11.2017.
 */


public interface ConnectionFactory {
    Connection createConnection() throws DatabaseException;
}

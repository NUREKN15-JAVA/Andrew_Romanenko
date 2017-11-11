package main.db;

import main.User;

import java.util.Collection;


/**
 * Author andy_
 * created 05.11.2017.
 */


public interface UserDAO {
    Long create(User user) throws DatabaseException;

    void update(User user) throws DatabaseException;

    void delete(User user) throws DatabaseException;

    User findById(Long id) throws DatabaseException;

    Collection findAll() throws DatabaseException;

    public void setConnectionFactory(ConnectionFactory connectionFactory);
}

package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;

/**
 * Root interface for all DAO classes
 *
 * @author Adna Kurbegović
 */

public interface Dao<T> {

    /**
     * get entity from database base on ID
     *
     * @param id primary key of entity
     * @return Entity from database
     */
    T getById(int id) throws HotelException;

    /**
     * Saves entity into database
     * @param item bean for saving to database
     * @return saved item with id field populated
     */
    T add(T item) throws HotelException;

    /**
     * Fully updates entity in database based on id (primary) match.
     * @param item - bean to be updated. id must be populated
     * @return updated version of bean
     */
    T update(T item) throws HotelException;

    /**
     * Hard delete of item from database with given id
     * @param id - primary key of entity
     */
    void delete(int id) throws HotelException;

    /**
     * Lists all entities from database.
     * @return List of entities from database
     */
    List<T> getAll() throws HotelException;

}

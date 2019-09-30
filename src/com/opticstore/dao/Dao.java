package com.opticstore.dao;


public interface Dao<T> {

    void add(T element);

    T find(T element);
}

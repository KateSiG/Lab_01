package com.project_01.oop.dao;

import org.apache.log4j.Logger;

import java.util.List;

interface EntityDao<T> {
    List<T> getAll();
    boolean create(T e);
    boolean update(T e);
    boolean delete(T e);
}

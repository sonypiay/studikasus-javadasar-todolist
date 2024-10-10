package repository;

import entity.Todolist;

public interface TodolistRepository {

    Todolist[] getAll();

    void add(Todolist todolist);
    boolean delete(Integer number);
}

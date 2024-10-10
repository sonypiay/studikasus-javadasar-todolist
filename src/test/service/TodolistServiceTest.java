package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();

        todolistRepository.data[0] = new Todolist("Belajar Java Dasar");
        todolistRepository.data[1] = new Todolist("Belajar Java OOP");
        todolistRepository.data[2] = new Todolist("Belajar Java Standard Classes");

        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        todolistService.show();
    }

    public static void testAddTodoList() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.add("Belajar Java Dasar");
        todolistService.add("Belajar Java OOP");
        todolistService.add("Belajar Java Sandard Classes");
        todolistService.show();
    }

    public static void testRemoveTodoList() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.add("Belajar Java Dasar");
        todolistService.add("Belajar Java OOP");
        todolistService.add("Belajar Java Sandard Classes");

        todolistService.show();
        todolistService.delete(5);
        todolistService.delete(2);
        todolistService.show();
        todolistService.delete(2);
        todolistService.show();
        todolistService.delete(2);
        todolistService.show();
        todolistService.delete(1);
        todolistService.show();
    }
}

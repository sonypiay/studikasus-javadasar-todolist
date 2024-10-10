package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistViewTest {
    public static void main(String[] args) {
        testDelete();
    }

    public static void testShow() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.add("Belajar Java Dasar");
        todolistService.add("Belajar Java OOP");
        todolistService.add("Belajar Java Sandard Classes");

        todolistView.show();
    }

    public static void testAdd() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.add();
        todolistService.show();

        todolistView.add();
        todolistService.show();
    }

    public static void testDelete() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistService.add("Belajar Java Dasar");
        todolistService.add("Belajar Java OOP");
        todolistService.add("Belajar Java Sandard Classes");

        todolistService.show();
        todolistView.delete();
        todolistService.show();
    }
}

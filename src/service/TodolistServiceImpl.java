package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {
    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void show() {
        Todolist[] dataList = todolistRepository.getAll();
        System.out.println("TODOLIST");

        for(var i = 0; i < dataList.length; i++) {
            var todo = dataList[i];
            var no = i+1;

            if( todo != null ) {
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void add(String value) {
        Todolist todolist = new Todolist(value);
        todolistRepository.add(todolist);
    }

    @Override
    public void delete(Integer number) {
        boolean success = todolistRepository.delete(number);

        if(success) {
            System.out.println("Sukses menghapus todolist: " + number);
        } else {
            System.out.println("Gagal menghapus todolist: " + number);
        }
    }
}

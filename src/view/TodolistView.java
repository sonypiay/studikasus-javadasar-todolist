package view;

import service.TodolistService;
import util.UtilInput;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void show() {
        while (true) {
            todolistService.show();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = UtilInput.input("Pilih");

            if(input.equals("1")) {
                add();
            } else if(input.equals("2")) {
                delete();
            } else if(input.equals("x") || input.equals("X")) {
                System.out.println("Exit...");
                break;
            }else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public void add() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = UtilInput.input("Todo (x jika batal)");

        if(todo.equals("x")) {

        } else {
            todolistService.add(todo);
        }
    }

    public void delete() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = UtilInput.input("Nomor yang dihapus (x jika batal)");

        if(number.equals("x")) {

        } else {
            todolistService.delete(Integer.valueOf(number));
        }
    }
}

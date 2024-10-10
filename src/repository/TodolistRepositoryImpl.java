package repository;

import entity.Todolist;

public class TodolistRepositoryImpl implements TodolistRepository {

    public Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return this.data;
    }

    public boolean isFull() {
        boolean isFull = true;

        // cek apakah data penuh
        for(int i = 0; i < this.data.length; i++) {
            if( this.data[i] == null ) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    public void resizeData() {
        if(this.isFull()) {
            var dataListTemp = this.data;
            this.data = new Todolist[this.data.length * 2];

            for (int i = 0; i < dataListTemp.length; i++) {
                this.data[i] = dataListTemp[i];
            }
        }
    }

    @Override
    public void add(Todolist todolist) {
        resizeData();

        for( var i = 0; i < this.data.length; i++ ) {
            if( this.data[i] == null ) {
                this.data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public boolean delete(Integer number) {
        int index = number - 1;

        if(index >= this.data.length ) {
            return false;
        } else if( this.data[index] == null ) {
            return false;
        } else {
            for (int i = index; i < this.data.length; i++) {
                if( i == (this.data.length - 1) ) {
                    this.data[i] = null;
                } else {
                    this.data[i] = this.data[i+1];;
                }
            }

            return true;
        }
    }
}

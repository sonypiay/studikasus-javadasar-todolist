public class AplikasiTodolist {
    public static String[] dataList = new String[10];

    public static void main(String[] args) {
        testDeleteTodoList();
    }

    /**
     * Menampilkan data todolist
     */
    public static void showTodoList() {
        for(var i = 0; i < dataList.length; i++) {
            var todo = dataList[i];
            var no = i+1;

            if( todo != null ) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        dataList[0] = "Belajar Java Dasar";
        dataList[1] = "Membuat aplikasi todolist java dasar";
        showTodoList();
    }

    /**
     * Menambahkan data todolist
     */
    public static void addTodoList(String todo) {
        boolean isFull = true;

        // cek apakah data penuh
        for(int i = 0; i < dataList.length; i++) {
            if( dataList[i] == null ) {
                // datalist masih kosong
                isFull = false;
                break;
            }
        }

        if(isFull) {
            var dataListTemp = dataList;
            dataList = new String[dataList.length * 2];

            for (int i = 0; i < dataListTemp.length; i++) {
                dataList[i] = dataListTemp[i];
            }
        }

        // tambahkan ke posisi yang data arraynya null
        for( var i = 0; i < dataList.length; i++ ) {
            if( dataList[i] == null ) {
                dataList[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for( int i = 0; i < 25; i++ ) {
            addTodoList("Contoh todo ke: " + i);
        }

        showTodoList();
    }

    /**
     * Menghapus data todolist
     */
    public static boolean deleteTodoList(Integer number) {
        int index = number - 1;

        if(index >= dataList.length ) {
            return false;
        } else if( dataList[index] == null ) {
            return false;
        } else {
            for (int i = index; i < dataList.length; i++) {
                if( i == (dataList.length - 1) ) {
                    dataList[i] = null;
                } else {
                    dataList[i] = dataList[i+1];;
                }
            }

            return true;
        }
    }

    public static void testDeleteTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        boolean result = deleteTodoList(10);
        System.out.println(result);

        result = deleteTodoList(7);
        System.out.println(result);

        result = deleteTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    /**
     * Menampilkan view todolist
     */
    public static void viewShowTodoList() {

    }

    /**
     * Menampilkan view tambah todolist
     */
    public static void viewAddTodoList() {

    }

    /**
     * Menampilkan view delete todolist
     */
    public static void viewDeleteTodoList() {

    }
}

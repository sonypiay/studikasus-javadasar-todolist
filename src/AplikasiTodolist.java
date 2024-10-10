public class AplikasiTodolist {

    public static String[] dataList = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }
    
    public static String input(String info) {
        System.out.print(info + ": ");
        String data = scanner.nextLine();

        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan data todolist
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");

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
        while (true) {
            showTodoList();

            System.out.println("MENU: ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if(input.equals("1")) {
                viewAddTodoList();
            } else if(input.equals("2")) {
                viewDeleteTodoList();
            } else if(input.equals("x") || input.equals("X")) {
                System.out.println("Exit...");
                break;
            }else {
                System.out.println("Pilihan tidak ada");
            }
        }
    }

    public static void testViewShowTodolist() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        viewShowTodoList();
    }

    /**
     * Menampilkan view tambah todolist
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");

        if(todo.equals("x")) {

        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("1");
        addTodoList("2");
        addTodoList("3");
        viewAddTodoList();
        showTodoList();
    }

    /**
     * Menampilkan view delete todolist
     */
    public static void viewDeleteTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if(number.equals("x")) {

        } else {
            boolean success = deleteTodoList(Integer.valueOf(number));

            if(!success) {
                System.out.println("Gagal menghapus todolist: " + number);
            }
        }
    }

    public static void testViewDeleteTodoList() {
        addTodoList("1");
        addTodoList("2");
        addTodoList("3");

        showTodoList();
        viewDeleteTodoList();
        showTodoList();
    }
}

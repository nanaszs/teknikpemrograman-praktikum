public class GenericsTypeOld {

    private Object t;

    public Object get() {
        return t;
    }

    public void set(Object t) {
        this.t = t;
    }

    public static void main(String args[]) {
        GenericsTypeOld type = new GenericsTypeOld();
        type.set("Java");
        //menyimpan string ke dalam var object
        String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
        //nilai dari get() tipe nya object jadi harus dicasting ke string agar bisa digunakan sebagai string
    }
}

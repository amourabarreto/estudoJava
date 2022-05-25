package br.com.estudo.gc;

public class GcEstudo {
    public static void main(String[] args) {
        GcEstudo h = new GcEstudo();
        Inner ob = h.methodA(); /* Line 6 */
        System.out.println(ob.nome);
    }
    Inner methodA()
    {
        Inner obj1 = new Inner();
        obj1.nome="Andre";
        Inner [] obj2 = new Inner[1];
        obj2[0] = obj1;
        obj1 = null;
        return obj2[0];
    }
}
class Inner{
    public String nome;
}

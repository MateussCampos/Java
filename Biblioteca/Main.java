public class Main{
    public static void main(String[]args){
        Livro l1 = new Livro();
        Livro l2 = new Livro();

        Biblioteca b1 = new Biblioteca();

        l1.setNome("hffyg");
        l2.setNome("56566");

        b1.setNome("jhjj33");

        b1.setLivro(l1);
        b1.setLivro(l2);

        b1.show();
    }
}
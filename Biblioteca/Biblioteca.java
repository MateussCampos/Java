import java.util.ArrayList;

public class Biblioteca {
    ArrayList<String> acervo = new ArrayList<>();
    String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setLivro(Livro livro) {
        acervo.add(livro.nome);
    }

    public void removeLivro(Livro livro) {
        acervo.remove(livro.nome);
    }

    public void show() {
        System.out.println("Livros disponiveis no acervo: ");
       for(int i=0;i<acervo.size();i++){
        System.out.println(acervo.get(i));
       }
    }
}

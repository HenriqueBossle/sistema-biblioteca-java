import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<Livro>();

        Servicos servicos = new Servicos();
        boolean parar = false;
        int id_livro = 1;
        int id;

        do{
            int opcao = servicos.opcao();
            switch(opcao) {
                case 1:
                    livros.add(servicos.adicionarLivro(id_livro));
                    id_livro++;
                    break;
                case 2:
                    servicos.listarLivros(livros);
                    break;
                case 3:
                    System.out.println("Digite o id do livro que deseja: ");
                    id = scanner.nextInt();
                    servicos.emprestarLivros(livros, id);
                    break;
                case 4:
                    System.out.println("Digite o id do livro que deseja devolver: ");
                    id = scanner.nextInt();
                    servicos.devolverLivro(livros, id);
                    break;
                case 5:
                    System.out.println("Digite o id do livro que deseja excluir: ");
                    id = scanner.nextInt();
                    servicos.excluirLivro(livros, id);
                    break;
                case 6:
                    parar = true;
                    System.out.println("Encerrando...");
                    break;
            }
        }while(!parar);
    }
}

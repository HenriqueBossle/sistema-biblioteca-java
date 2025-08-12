import java.util.ArrayList;
import java.util.Scanner;

public class Servicos {

    Scanner scanner = new Scanner(System.in);

    public int opcao(){
        System.out.println("Digite a opção desejada: ");
        System.out.println("[1] - Adicionar um livro: ");
        System.out.println("[2] - Listar livros: ");
        System.out.println("[3] - Empréstimo de livro: ");
        System.out.println("[4] - Devolver livro: ");
        System.out.println("[5] - Excluir livro: ");
        System.out.println("[6] - Encerrar o programa: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public Livro adicionarLivro(int id){
        System.out.println("Digite o titulo do livro: ");
        String titulo = scanner.nextLine();
        System.out.println("Digite autor do livro: ");
        String autor = scanner.nextLine();
        System.out.println("Digite o ano do livro: ");
        int ano = scanner.nextInt();
        Livro livro = new Livro(id, titulo, autor, ano);
        System.out.println("--------");
        System.out.println("O livro adicionado com sucesso!");
        System.out.println("--------");
        return livro;
    }

    public void listarLivros(ArrayList<Livro> livros){
        if(livros.isEmpty()){
            System.out.println("--------");
            System.out.println("Nenhum livro cadastrado!");
            System.out.println("--------");
            return;
        }
        System.out.println("--------");
        System.out.println("Lista de livros: ");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(livros.get(i).toString());
        }
        System.out.println("--------");
    }

    public void emprestarLivros(ArrayList<Livro> livros, int id){
        for (Livro livro : livros) {
            if(livro.getId() == id){
                if(livro.getDisponibilidade()){
                    livro.setDisponibilidade(false);
                    System.out.println("Livro emprestado com sucesso: " + livro.getTitulo());
                    System.out.println("--------");
                }else{
                    System.out.println("--------");
                    System.out.println("O livro já foi emprestado!");
                    System.out.println("--------");
                }
                return;
            }
        }
        System.out.println("--------");
        System.out.println("Livro com ID " + id + " não encontrado!");
        System.out.println("--------");
    }

    public void devolverLivro(ArrayList<Livro> livros, int id){
        for (Livro livro : livros){
            if(livro.getId() == id){
                if(!livro.getDisponibilidade()){
                    livro.setDisponibilidade(true);
                    System.out.println("--------");
                    System.out.println("Livro devolvido com sucesso! " + livro.getTitulo());
                    System.out.println("--------");
                } else {
                    System.out.println("--------");
                    System.out.println("O livro "+ livro.getTitulo() + " não foi emprestado!");
                    System.out.println("--------");
                }
                return;
            }
        }
        System.out.println("--------");
        System.out.println("Livro com ID " + id + " não encontrado!");
        System.out.println("--------");
    }

    public void excluirLivro(ArrayList<Livro> livros, int id) {
        for (int i = 0; i < livros.size(); i++) {
            if(livros.get(i).getId() == id){
                System.out.println("--------");
                System.out.println("Livro excluido com sucesso: " + livros.get(i).getTitulo());
                System.out.println("--------");
                livros.remove(i);
                return;
            }
        }
        System.out.println("--------");
        System.out.println("Livro com ID: " + id + " não encontrado!");
        System.out.println("--------");
    }
}

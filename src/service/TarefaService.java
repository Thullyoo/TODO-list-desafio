package service;

import entity.Categoria;
import entity.Status;
import entity.Tarefa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TarefaService {

    public static List<Tarefa> criarTarefa(Scanner scanner, List<Tarefa> tarefas) {
        System.out.println("==========================================");
        System.out.println("Criação de tarefa, preencha os dados:\n");

        String nome = lerTexto(scanner, "Nome: ");
        String descricao = lerTexto(scanner, "Descrição: ");
        LocalDate dataDeTermino = lerData(scanner);
        int nivelDePrioridade = lerPrioridade(scanner);
        Categoria categoria = lerCategoria(scanner);
        Status status = lerStatus(scanner);

        

        tarefas.add(new Tarefa(
                nome,
                descricao,
                dataDeTermino,
                nivelDePrioridade,
                categoria,
                status
        ));

        return tarefas;
    }

    public static List<Tarefa> atualizarTarefa(Scanner scanner, List<Tarefa> tarefas, Tarefa tarefa) {
        System.out.println("\n=== Atualização de Tarefa ===");

        if (confirmar(scanner, "Deseja editar o nome?")) {
            tarefa.setNome(lerTexto(scanner, "Novo nome: "));
        }

        if (confirmar(scanner, "Deseja editar a descrição?")) {
            tarefa.setDescricao(lerTexto(scanner, "Nova descrição: "));
        }

        if (confirmar(scanner, "Deseja editar a data de término?")) {
            tarefa.setDataDeTermino(lerData(scanner));
        }

        if (confirmar(scanner, "Deseja editar o nível de prioridade?")) {
            tarefa.setNivelDePrioridade(lerPrioridade(scanner));
        }

        if (confirmar(scanner, "Deseja editar a categoria?")) {
            tarefa.setCategoria(lerCategoria(scanner));
        }

        if (confirmar(scanner, "Deseja editar o status?")) {
            tarefa.setStatus(lerStatus(scanner));
        }
        
        System.out.println("\nTarefa atualizada com sucesso!");

        return tarefas;
    }

    public static List<Tarefa> excluirTarefa(List<Tarefa> tarefas, Tarefa tarefa){
        tarefas.remove(tarefa);
        System.out.println("Tarefa removida");
        return tarefas;
    }

    public static void visualizarTarefa(Tarefa tarefa) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("------------------------------------------");
        System.out.println("Nome: " + tarefa.getNome());
        System.out.println("Descrição: " + tarefa.getDescricao());
        System.out.println("Data de término: " +
                tarefa.getDataDeTermino().format(formatter));
        System.out.println("Prioridade: " + tarefa.getNivelDePrioridade());
        System.out.println("Categoria: " + tarefa.getCategoria());
        System.out.println("Status: " + tarefa.getStatus());
        System.out.println("------------------------------------------");
    }

    public static List<Tarefa> ordenarTarefas(List<Tarefa> tarefas){
        tarefas.sort(Comparator.comparingInt(Tarefa::getNivelDePrioridade).reversed());
        return tarefas;
    }

    private static boolean confirmar(Scanner scanner, String pergunta) {
        while (true) {
            System.out.print(pergunta + " (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s")) return true;
            if (resposta.equals("n")) return false;
            System.out.println("Resposta inválida! Digite s ou n.");
        }
    }

    private static String lerTexto(Scanner scanner, String mensagem) {
        String valor;
        do {
            System.out.print(mensagem);
            valor = scanner.nextLine();
            if (valor.isBlank()) {
                System.out.println("Campo obrigatório!");
            }
        } while (valor.isBlank());
        return valor;
    }

    private static LocalDate lerData(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print("Data de término (dd/MM/yyyy): ");
                return LocalDate.parse(scanner.nextLine(), formatter);
            } catch (Exception e) {
                System.out.println("Data inválida! Use o formato dd/MM/yyyy.");
            }
        }
    }

    private static int lerPrioridade(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Nível de prioridade (1-5): ");
                int prioridade = Integer.parseInt(scanner.nextLine());
                if (prioridade >= 1 && prioridade <= 5) {
                    return prioridade;
                }
                System.out.println("Prioridade deve estar entre 1 e 5.");
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static Status lerStatus(Scanner scanner) {
        while (true) {
            System.out.print("Status (TODO, DOING, DONE): ");
            try {
                return Status.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Status inválido! Use TODO, DOING ou DONE.");
            }
        }
    }

    private static Categoria lerCategoria(Scanner scanner){
        while (true) {
            System.out.print("Categoria (TRABALHO, ESTUDO, PESSOAL, CASA, SAUDE, FINANCEIRO): ");
            try {
                return Categoria.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Categoria inválida! Use trabalho, estudo, pessoal, casa, saude ou financeiro");
            }
        }
    }
}

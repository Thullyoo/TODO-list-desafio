import entity.Tarefa;
import service.TarefaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Tarefa> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println("--------- Menu Inicial --------");
            System.out.println("1 - Visualizar Tarefas");
            System.out.println("2 - Registrar uma Tarefa");
            System.out.println("3 - Atualizar uma Tarefa");
            System.out.println("4 - Remover uma Tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("---- Visualizar Tarefas ----");
                    System.out.println("1 - Todas as tarefas");
                    System.out.println("2 - Por Categoria");
                    System.out.println("3 - Por Prioridade");
                    System.out.println("4 - Por Status");
                    System.out.print("Escolha uma opção: ");

                    int opcaoVisualizacao = Integer.parseInt(scanner.nextLine());

                    switch (opcaoVisualizacao) {

                        case 1:
                            for (Tarefa t : tarefas) {
                                TarefaService.visualizarTarefa(t);
                            }
                            break;

                        case 2:
                            System.out.print("Digite a categoria (TRABALHO, ESTUDO, PESSOAL, CASA, SAUDE, FINANCEIRO): ");
                            String categoriaInput = scanner.nextLine().toUpperCase();

                            for (Tarefa t : tarefas) {
                                if (t.getCategoria().name().equals(categoriaInput)) {
                                    TarefaService.visualizarTarefa(t);
                                }
                            }
                            break;

                        case 3:
                            System.out.print("Digite a prioridade (1 - 5): ");
                            String nivelDePrioridadeInput = scanner.nextLine();

                            for (Tarefa t : tarefas) {
                                if (t.getNivelDePrioridade() == Integer.parseInt(nivelDePrioridadeInput)) {
                                    TarefaService.visualizarTarefa(t);
                                }
                            }
                            break;

                        case 4:
                            System.out.print("Digite o status (TODO, DOING, DONE): ");
                            String statusInput = scanner.nextLine().toUpperCase();

                            for (Tarefa t : tarefas) {
                                if (t.getStatus().name().equals(statusInput)) {
                                    TarefaService.visualizarTarefa(t);
                                }
                            }
                            break;

                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    TarefaService.criarTarefa(scanner, tarefas);
                    TarefaService.ordenarTarefas(tarefas);
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa a atualizar: \n");
                    for (int i = 0; i < tarefas.size(); i++){
                        System.out.println(i + "- " + tarefas.get(i).getNome());
                    }

                    tarefas = TarefaService.atualizarTarefa(scanner, tarefas, tarefas.get(Integer.parseInt(scanner.nextLine())));
                    TarefaService.ordenarTarefas(tarefas);

                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa a remover: \n");
                    for (int i = 0; i < tarefas.size(); i++){
                        System.out.println(i + "- " + tarefas.get(i).getNome());
                    }
                    tarefas = TarefaService.excluirTarefa(tarefas, tarefas.get(Integer.parseInt(scanner.nextLine())));
                    TarefaService.ordenarTarefas(tarefas);

                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
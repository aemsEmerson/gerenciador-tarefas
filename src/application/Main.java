package application;

import entities.Tarefas;
import service.GerenciadorTarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner sc = new Scanner(System.in);
        int opcao;


        do{
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefa");
            System.out.println("3 - Concluir tarefa");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.print("Descrição da tarefa: ");
                    String descricao = sc.nextLine();
                    gerenciador.adicionarTarefa(descricao);
                }

                case 2 -> gerenciador.listarTarefa();

                case 3 -> {
                    gerenciador.listarTarefa();
                    System.out.print("Digite o numero da tarefa para concluir: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    gerenciador.concluirTarefa(index);
                }

                case 0 -> System.out.println("Encerrando...");

                default -> System.out.println("Opção inválida!");
            }
        }
        while (opcao != 0);
        sc.close();
    }


}
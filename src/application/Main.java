package application;

import entities.Tarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static  ArrayList<Tarefas> tarefa = new ArrayList<>();

    public static void main(String[] args) {
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
                case 1 -> adicionarTarefa(sc);
                case 2 -> listarTarefa();
                case 3 -> concluirTarefa(sc);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        }
        while (opcao != 0);
        sc.close();
    }

    private static void adicionarTarefa(Scanner sc){
        System.out.println("Descrição da Tarefa: ");
        String descricao = sc.nextLine();
        tarefa.add(new Tarefas(descricao));
        System.out.println("Tarefa Adicionada!");
    }

    private static void listarTarefa(){
        if(tarefa.isEmpty()){
            System.out.println("Nenhuma tarefa Cadastrada!");
        } else {
            System.out.println("\n --- Lista de Tarefas ---");
            for(int i = 0; i < tarefa.size(); i++){
                System.out.println(i + " - " + tarefa.get(i));
            }
        }
    }

    private static void concluirTarefa(Scanner sc){
        listarTarefa();
        System.out.print("Digite o número da Tarefa para concluir: ");
        int index = sc.nextInt();
        if (index >= 0 && index < tarefa.size()){
            tarefa.get(index).tarefaConcluir();
            System.out.println("Tarefa concluída!");
        } else {
            System.out.println("Tarefa inválida!");
        }
    }
}
package service;

import entities.Tarefas;
import java.util.ArrayList;

public class GerenciadorTarefas {

    public ArrayList<Tarefas> tarefa = new ArrayList<>();

    public void adicionarTarefa(String desc){
        tarefa.add(new Tarefas(desc));
        System.out.println("Tarefa Adicionada!");
    }

    public void listarTarefa(){
        if(tarefa.isEmpty()){
            System.out.println("Nenhuma tarefa Cadastrada!");
        } else {
            System.out.println("\n --- Lista de Tarefas ---");
            for(int i = 0; i < tarefa.size(); i++){
                System.out.println(i + " - " + tarefa.get(i));
            }
        }
    }

    public void concluirTarefa(int index){
        if (index >= 0 && index < tarefa.size()){
            tarefa.get(index).tarefaConcluir();
            System.out.println("Tarefa concluída!");
        } else {
            System.out.println("Tarefa inválida!");
        }
    }
}

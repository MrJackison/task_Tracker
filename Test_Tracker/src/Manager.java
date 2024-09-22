import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    ArrayList<Task> taskList = carregarTaskJSON();

    private static final String arquivo_json = "tarefas.json";

    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int choice;
        String fraseMenu = "===== MENU =====\n\n1 = Adicionar Nova Tarefa\n2 = Atualizar Tarefa\n3 = Deletar Tarefa\n4 = Listar Tarefas Existentes\nO que deseja fazer?";

        while (running) {
            try {
                System.out.print(fraseMenu);
                choice = input.nextInt();
                System.out.println();

                switch (choice) {

                    case 1: //Adicionar Nova Tarefa
                        System.out.println("--- ADICIONAR NOVA TAREFA ---\n");
                        Task newTask = new Task(); //Cria nova instância da task

                        newTask.gerarId(); //Gera o Id desta task
                        newTask.nomearDescreverTask(); //Nomeia e descreve a task

                        taskList.add(newTask); //Adiciona a task na lista de tarefas
                        System.out.println("Nova Tarefa Adicionada Com Sucesso!");
                        salvarTaskJSON(taskList);

                        System.out.println();
                        break;

                    case 2:
                        System.out.println("--- ATUALIZAR TAREFA ---\n");

                        System.out.println();
                        break;

                    case 3:
                        System.out.println("--- DELETAR TAREFA ---\n");

                        System.out.println();
                        break;

                    case 4:  //Listar Tarefas Existentes
                        int voltarAoMenu;

                        System.out.println("=== TAREFAS EXISTENTES ===\n");

                        List<Task> taskCarregas = carregarTaskJSON();
                        if (taskCarregas != null) {
                            int contador = 1;
                            for (Task listarTask : taskCarregas) {
                                System.out.println("--- Tarefa " + contador + " ---\n\n" + listarTask.toString());
                                contador++;
                            }
                        }

                        while (true) {
                            try {
                                System.out.println("0 = Voltar ao Menu");
                                voltarAoMenu = input.nextInt();

                                if (voltarAoMenu == 0) {
                                    break; //Sai do Case 4
                                } else {
                                    System.out.println("Comando Inválido!");
                                }

                            } catch (Exception b) {
                                System.out.println("Comando Inválido!");
                                input.next(); //Limpa o buffer
                            }
                        }
                        System.out.println();
                        break;

                    case 0:
                        System.out.println("Saindo do Programa");
                        running = false;
                        break;

                    default:
                        System.out.println("Comando Inválido!\n" + fraseMenu);
                        input.nextInt();
                }

            } catch (Exception a) {
                System.out.println("Comando Inválido!\n");
                input.nextLine();
            }
        }
    }

//    public void listarTask() {
//        int contador = 1;
//
//        if (taskList.isEmpty()) {
//            System.out.println("Nenhuma Tarefa Aqui!\n");
//        } else {
//            for (Task task : taskList) {
//                System.out.println("--- Tarefa " + contador + " ---\n\n" + task.toString());
//                contador++;
//            }
//        }
//
//    }

    public void salvarTaskJSON(ArrayList<Task> taskList) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(arquivo_json)) {
            gson.toJson(taskList, writer);
        } catch (IOException c) {
            System.out.println("Algo de errado aconteceu ao salvarTaskJSON");
        }
    }

    /**
     * Transforma os dados do arquivo JSON em objetos Task
     * @return A leitura
     */

    public ArrayList<Task> carregarTaskJSON() {
        Gson gson = new Gson(); //Instância da biblioteca Gson que lida com serialização e deserialização (Leitura e escrita de/para JSON)

        try (FileReader reader = new FileReader(arquivo_json)) {
            Type taskListType = new TypeToken<ArrayList<Task>>() {
            }.getType();
            return gson.fromJson(reader, taskListType);
            /**
             * .fromJson : Método que converte representações JSON em objetos Java;
             * Argumento1 : Objeto FileReader que contém os dados serializados do arquivo JSON;
             * Argumento2 : Tipo de dado que o reader será convertido, neste caso ArrayList<Task>
             */
        } catch (IOException d) {
            System.out.println("Algo de errado aconteceu ao carregarTaskJSON");
        }
        return null;
    }

}

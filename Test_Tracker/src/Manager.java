import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Task> taskList = new ArrayList<>();

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

                    case 1:
                        System.out.println("--- ADICIONAR NOVA TAREFA ---\n");
                        Task newTask = new Task();

                        newTask.gerarId();
                        newTask.nomearDescreverTask();

                        taskList.add(newTask);
                        System.out.println("Nova Tarefa Adicionada Com Sucesso!");

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

                    case 4:
                        int voltarAoMenu;

                        System.out.println("--- TAREFAS EXISTENTES ---\n");
                        listarTask();

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

    public void listarTask() {
        int contador = 1;

        if (taskList.isEmpty()) {
            System.out.println("Nenhuma Tarefa Aqui!");
        } else {
            for (Task task : taskList) {
                System.out.println("--- Tarefa " + contador + " ---\n" + task.toString());
                contador++;
            }
        }
    }
}

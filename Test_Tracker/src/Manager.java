import java.util.Scanner;

public class Manager {

    /*

     */

    public void menu() {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        int choice;

        while (running) {
            try {
                System.out.println("1 = Adicionar Tarefa\n2 = Atualizar Tarefa\n3 = Deletar Tarefa\nO que deseja fazer?");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("\n--- ADICIONANDO TAREFA ---\n");
                        Task task1 = new Task();

                        task1.nomearDescreverTask();
                        task1.gerarId();

                        System.out.println(task1.toString());

                        running = false;
                        break;

                    case 2:
                        running = false;
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("""

                                Comando Inválido!
                                1 = Adicionar Tarefa
                                2 = Atualizar Tarefa
                                3 = Deletar Tarefa

                                O que deseja fazer?""");
                        choice = input.nextInt();
                }

            } catch (Exception e) {
                System.out.println("Comando Inválido!\n");
                input.nextLine();
            }

        }

    }

    public void addTask() {

    }

    public void updateTask() {

    }
}

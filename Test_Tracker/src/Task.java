import java.util.UUID;
import java.util.Scanner;

public class Task {
    private String id;
    private String titleTask;
    private String descTask;

    /**
     * Construtor da Task
     * Constrói uma task nula
     */

    public Task() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String titleTask) {
        this.titleTask = titleTask;
    }

    public void setDesc(String descTask) {
        this.descTask = descTask;
    }

    public String getId() {
        return id;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public String getDescTask() {
        return descTask;
    }

    /**
     * Gera um Identificador da tarefa
     */

    public void gerarId() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * Permite o usuário dar um título a task
     */

    public void nomearTask() {
        Scanner input = new Scanner(System.in);

        System.out.println("Título da tarefa: ");
        this.titleTask = input.nextLine();
    }

    /**
     * Permite o usuário descrever a task
     */

    public void descreverTask() {
        Scanner input = new Scanner(System.in);

        System.out.println("Descrição da tarefa: ");
        this.descTask = input.nextLine();
    }

    /**
     * Permite o usuário nomear e descrever a task
     */

    public void nomearDescreverTask() {
        nomearTask();
        descreverTask();
    }

    @Override
    public String toString() {
        /*
          "Id da Tarefa: " + id +
         */
        return "Nome da Tarefa: " + titleTask + "\nDescrição da Tarefa: " + descTask + "\n";
    }
}
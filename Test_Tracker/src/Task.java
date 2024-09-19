import java.util.Scanner;

public class Task {
    private String titleTask;
    private String descTask;

    public Task(){
    }

    public void setTitle(String titleTask) {
        this.titleTask = titleTask;
    }

    public void setDesc(String descTask) {
        this.descTask = descTask;
    }

    public String getTitleTask() {
        return titleTask;
    }

    public String getDescTask() {
        return descTask;
    }

    public void nomearTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Título da tarefa: ");
        String paraNomearTask = input.nextLine();
        this.titleTask = paraNomearTask;
    }

    @Override
    public String toString() {
        return "Titulo da tarefa: " + getTitleTask() + "\nDescrição da tarefa: " + getDescTask();
    }
}
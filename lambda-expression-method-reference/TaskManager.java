import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    } 
    

    public void executeAllTasks() {
        taskList.stream().forEach(e -> e.execute());
    }

    public static void main(String[] args) {
        TaskManager taskManger = new TaskManager();

        taskManger.addTask(TaskUtility::startTask);
        taskManger.addTask(TaskUtility::stopTask);
        taskManger.addTask(TaskUtility::resetTask);

        taskManger.addTask(() -> System.out.println("Added another task using lambda expression"));

        System.out.println("Executing task");

        taskManger.executeAllTasks();
    }
}

package annotations;

public class Service {

    @LogExecution(value = "Executing processTask")
    public void processTask(String taskName) {
        System.out.println("Processing task: " + taskName);
    }

    @LogExecution
    public void completeTask(String taskName) {
        System.out.println("Completing task: " + taskName);
    }
}


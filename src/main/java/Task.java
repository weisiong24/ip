//Matric Number: A0200273X
public class Task {
    protected String description;
    protected boolean isDone;

    //Initial setup for the description of task
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    //Return tick or X symbols
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    //Method to mark task when it is done
    public void markAsDone() {
        this.isDone = true;
    }

    //Method to mark task as undone
    public void markUndone() {
        this.isDone = false;
    }
}
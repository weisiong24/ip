//Matric Number: A0200273x
public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {

        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    //Method to mark task when it is done
    public void markAsDone() {
        this.isDone = true;
    }
    //Method to mark task as undone
    public void marknotDone() {
        this.isDone = false;
    }
}
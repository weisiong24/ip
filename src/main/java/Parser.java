public class Parser {
    //Method to list all the tasks entered and their current status
    static void ListCommand(String[] itemList, Duke numTasks, int j) {
        if(numTasks.getNumTasks()== j +1) {

            Task t = new Task(itemList[j]);
            t.markAsDone();
            if(numTasks.getTodoNum()== j +1) {

                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            } else if(numTasks.getDeadlineNum()== j +1) {

                System.out.print(j + 1 + "." + "[" + "D" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            } else if(numTasks.getEventNum()== j +1) {

                System.out.print(j + 1 + "." + "[" + "E" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            } else {

                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            }

        } else {

            Task t = new Task(itemList[j]);
            t.markUndone();
            if(numTasks.getTodoNum()== j +1) {

                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            } else if(numTasks.getDeadlineNum()== j +1) {

                System.out.print(j + 1 + "." + "[" + "D" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            } else if(numTasks.getEventNum()== j +1) {

                System.out.print(j + 1 + "." + "[" + "E" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            } else {

                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

            }
        }
    }
    //Method to mark a task as done using the index of the task
    public static void DoneCommand(String[] itemList, Duke numTasks, String description, String s) {
        Task t = new Task(description);
        t.markAsDone();
        int taskNum = Integer.parseInt(s);

        Ui.printLines();
        System.out.print("Nice! I've marked this task as done: \n");
        System.out.print("\t[" + t.getStatusIcon() + "] " + itemList[taskNum - 1] + "\n");
        Ui.printLines();
        numTasks.setNumTasks(taskNum);
    }
}

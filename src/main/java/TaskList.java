import java.util.ArrayList;

public class TaskList {
    protected static ArrayList<String> tasks = new ArrayList<>();

    public static int TodoCommand(String[] itemList, String line, Duke numTasks, int taskCounts, int i) {

        numTasks.setTaskCount(taskCounts += 1);
        Todo t = new Todo(line.substring(5));
        Ui.printLines();
        System.out.print("Got it. I've added this task: \n");
        System.out.print("\t" + t.toString());
        System.out.print("Now you have " + numTasks.getTaskCount() + " tasks in the list.\n");
        Ui.printLines();
        itemList[i] = line.substring(5);
        numTasks.setTodoNum(numTasks.getTaskCount());
        tasks.add(line.substring(5));
        Storage.writeFile(Storage.Dir, line);
        return taskCounts;

    }

    public static int DeadlineCommand(String[] itemList, String line, Duke numTasks, int taskCounts, int i) {

        numTasks.setTaskCount(taskCounts += 1);
        String taskItem = line.substring(9);
        Deadline d = new Deadline(taskItem, "");
        Ui.printLines();
        System.out.print("Got it. I've added this task: \n");
        System.out.print("\t" + d.toString());
        System.out.print("Now you have " + numTasks.getTaskCount() + " tasks in the list.\n");
        Ui.printLines();
        itemList[i] = taskItem;
        numTasks.setDeadlineNum(numTasks.getTaskCount());
        tasks.add(line.substring(9));
        Storage.writeFile(Storage.Dir, line);
        return taskCounts;

    }

    public static int EventCommand(String[] itemList, String line, Duke numTasks, int taskCounts, int i) {

        numTasks.setTaskCount(taskCounts += 1);
        String taskItem = line.substring(6);
        Event e = new Event(taskItem, "");
        Ui.printLines();
        System.out.print("Got it. I've added this task: \n");
        System.out.print("\t" + e.toString());
        System.out.print("Now you have " + numTasks.getTaskCount() + " tasks in the list.\n");
        Ui.printLines();
        itemList[i] = taskItem;
        numTasks.setEventNum(numTasks.getTaskCount());
        tasks.add(line.substring(6));
        Storage.writeFile(Storage.Dir, line);
        return taskCounts;

    }

    public static int DeleteCommand(String[] itemList, String line, Duke numTasks, int taskCounts, String description) {

        Task t = new Task(description);
        Ui.printLines();
        System.out.print("Noted. I've removed this task: \n");
        tasks.remove(tasks.get(Integer.valueOf(line.substring(7)) - 1));
        System.out.print("\t[E]" + "[" + t.getStatusIcon() + "] " + itemList[Integer.valueOf(line.substring(7)) - 1] + "\n");
        taskCounts -= 1;
        System.out.print("Now you have " + Integer.valueOf(numTasks.taskCount - 1) + " tasks in the list.\n");
        Ui.printLines();
        return taskCounts;

    }
}

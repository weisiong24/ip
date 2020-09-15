//Matric Number: A0200273X

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private final static String Dir = "src/main/resource/task.txt";
    private static ArrayList<String> tasks = new ArrayList<>();


    public static void main(String[] args) {
        System.out.print("Tasks saved previously: \n");
        printLines();
        retrieveFile(Dir);
        showWelcomeMessage();
        //String Array of size 100 created to store item list
        String[] itemList = new String[100];
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        Duke numTasks = new Duke();
        int taskCounts = 0;

        /**
         * When user enter list it will show a list of input saved
         * to do command add a item into the list and mark it as task
         * deadline command set a item with the deadline and mark it as deadline
         * Event command add item as events to do and mark it as event
         * When user enter done it will mark the task as done into the list
         * It will run continuously till bye command is given
         */
        while (!line.equals("bye")) {
            for (int i = 0; i < 100; i++) {

                String[] doneSide = line.split(" ");
                String[] task = line.split(" ");

                if (line.equals("list")) {

                    printLines();
                    System.out.print("Here are the tasks in your list:\n");
                    printLines();

                    for(int j=0;j<i;j++) {

                        if(numTasks.getNumTasks()==j+1) {

                            Task t = new Task(itemList[j]);
                            t.markAsDone();
                            if(numTasks.getTodoNum()==j+1) {

                                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getDeadlineNum()==j+1) {

                                System.out.print(j + 1 + "." + "[" + "D" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getEventNum()==j+1) {

                                System.out.print(j + 1 + "." + "[" + "E" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else {

                                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            }

                        } else {

                            Task t = new Task(itemList[j]);
                            t.markUndone();
                            if(numTasks.getTodoNum()==j+1) {

                                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getDeadlineNum()==j+1) {

                                System.out.print(j + 1 + "." + "[" + "D" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else if(numTasks.getEventNum()==j+1) {

                                System.out.print(j + 1 + "." + "[" + "E" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            } else {

                                System.out.print(j + 1 + "." + "[" + "T" + "]" + "[" + t.getStatusIcon() + "] " + itemList[j] + "\n");

                            }
                        }
                    }
                    i -= 1;

                    printLines();

                } else if (doneSide[0].equals("done")) {

                    Task t = new Task(itemList[i]);
                    t.markAsDone();
                    int taskNum = Integer.parseInt(doneSide[1]);

                    printLines();
                    System.out.print("Nice! I've marked this task as done: \n");
                    System.out.print("\t[" + t.getStatusIcon() + "] " + itemList[taskNum - 1] + "\n");
                    printLines();
                    numTasks.setNumTasks(taskNum);

                } else if (task[0].equals("todo")) {

                    if (!line.substring(4).equals(" ") && !line.substring(3).equals("o")) {

                        numTasks.setTaskCount(taskCounts += 1);
                        Todo t = new Todo(line.substring(5));
                        printLines();
                        System.out.print("Got it. I've added this task: \n");
                        System.out.print("\t" + t.toString());
                        System.out.print("Now you have " + numTasks.getTaskCount() + " tasks in the list.\n");
                        printLines();
                        itemList[i] = line.substring(5);
                        numTasks.setTodoNum(numTasks.getTaskCount());
                        tasks.add(line.substring(5));
                        writeFile(Dir, line);

                    } else {
                        try {

                            i -= 1;
                            throw new DukeException();
                        } catch (DukeException e) {

                            printLines();
                            System.out.print("☹ OOPS!!! The description of a todo cannot be empty.\n");
                            printLines();

                        }
                    }
                } else if (task[0].equals("deadline")) {
                    if (!line.substring(8).equals(" ") && !line.substring(7).equals("e")) {

                        numTasks.setTaskCount(taskCounts += 1);
                        String taskItem = line.substring(9);
                        Deadline d = new Deadline(taskItem, "");

                        printLines();
                        System.out.print("Got it. I've added this task: \n");
                        System.out.print("\t" + d.toString());
                        System.out.print("Now you have " + numTasks.getTaskCount() + " tasks in the list.\n");
                        printLines();
                        itemList[i] = taskItem;
                        numTasks.setDeadlineNum(numTasks.getTaskCount());
                        tasks.add(line.substring(9));
                        writeFile(Dir, line);

                    } else {
                        try {

                            i -= 1;
                            throw new DukeException();
                        } catch (DukeException e) {

                            printLines();
                            System.out.print("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                            printLines();
                        }
                    }
                } else if (task[0].equals("event")) {

                    if (!line.substring(5).equals(" ") && !line.substring(4).equals("t")) {

                        numTasks.setTaskCount(taskCounts += 1);
                        String taskItem = line.substring(6);
                        Event e = new Event(taskItem, "");
                        printLines();
                        System.out.print("Got it. I've added this task: \n");
                        System.out.print("\t" + e.toString());
                        System.out.print("Now you have " + numTasks.getTaskCount() + " tasks in the list.\n");
                        printLines();
                        itemList[i] = taskItem;
                        numTasks.setEventNum(numTasks.getTaskCount());
                        tasks.add(line.substring(6));
                        writeFile(Dir, line);


                    } else {
                        try {

                            i -= 1;
                            throw new DukeException();
                        } catch (DukeException e) {

                            printLines();
                            System.out.print("☹ OOPS!!! The description of a event cannot be empty.\n");
                            printLines();

                        }
                    }
                } else if (task[0].equals("delete")) {
                    if (!line.substring(6).equals(" ") && !line.substring(5).equals("e")) {

                        Task t = new Task(itemList[i]);
                        printLines();
                        System.out.print("Noted. I've removed this task: \n");
                        tasks.remove(tasks.get(Integer.valueOf(line.substring(7)) - 1));
                        System.out.print("\t[E]" + "[" + t.getStatusIcon() + "] " + itemList[Integer.valueOf(line.substring(7)) - 1] + "\n");
                        taskCounts -= 1;
                        System.out.print("Now you have " + Integer.valueOf(numTasks.taskCount - 1) + " tasks in the list.\n");
                        printLines();

                    } else {
                        try {
                            i -= 1;
                            throw new DukeException();
                        } catch (DukeException e) {
                            printLines();
                            System.out.print("☹ OOPS!!! The delete number command cannot be empty.\n");
                            printLines();
                        }
                    }

                } else {
                    try {
                        i -= 1;
                        throw new DukeException();

                    } catch (DukeException n) {

                        printLines();
                        System.out.print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                        printLines();

                    }
                }

                line = in.nextLine();

                if (line.equals("bye")) {
                    break;
                }
            }
        }
        showByeMessage();
    }

    //Three methods that are refactored for readability
    private static void printLines() {

        System.out.print("____________________________________________________________\n");
    }


    private static void showByeMessage() {

        System.out.print("____________________________________________________________\n");
        System.out.print("Bye. Hope to see you again soon!\n");
        System.out.print("____________________________________________________________\n");
    }

    private static void showWelcomeMessage() {

        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke \n"
                + "What can I do for you? \n"
                + " _   _  ____  _     _     ____ \n" +
                "| |_| || ===|| |__ | |__ / () \\\n" +
                "|_| |_||____||____||____|\\____/\n"
                + "____________________________________________________________\n";
        System.out.println(logo);
    }

    /**
     * Getter and setter to get task number from done command and send that number to list command
     * Getter and setter for task count to show number of tasks that are entered
     * Getter and setter for the deadline,to do,event number for usage in updating the list
     */
    int taskNumber, taskCount;
    int todoNum, deadlineNum, eventNum;

    int getNumTasks() {

        return taskNumber;
    }

    void setNumTasks(int num) {

        taskNumber = num;
    }

    int getTodoNum() {

        return todoNum;
    }

    void setTodoNum(int n) {

        todoNum = n;
    }

    int getDeadlineNum() {
        return deadlineNum;
    }

    void setDeadlineNum(int d) {

        deadlineNum = d;
    }

    int getEventNum() {

        return eventNum;
    }

    void setEventNum(int e) {

        eventNum = e;
    }

    int getTaskCount() {


        return taskCount;
    }

    void setTaskCount(int t) {

        taskCount = t;
    }

    public static void retrieveFile(String taskData) {
        try {
            File myData = new File(taskData);
            Scanner myReader = new Scanner(myData);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String taskData, String description) {
        try {
            FileWriter myData = new FileWriter(taskData, true);

            String[] taskName = description.split(" ");
            switch (taskName[0]) {
            case "todo":
                myData.write("[T] " + taskName[1] +"\n");
                break;
            case "deadline":
                myData.write("[D] " + taskName[1] +"\n");
                break;
            case "event":
                myData.write("[E] " + taskName[1] +"\n");
                break;
            default:
                break;
            }
            myData.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    protected final static String Dir = ".\\task.txt";

    public static void retrieveFile(String taskData) {
        try {
            String data=" ";
            File myData = new File(taskData);
            Scanner myReader = new Scanner(myData);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
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
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

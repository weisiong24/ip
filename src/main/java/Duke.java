//Matric Number: A0200273x
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = "____________________________________________________________\n"
                + "Hello! I'm Duke \n"
                + "What can I do for you? \n"
                + "____________________________________________________________\n";
        System.out.println(logo);
        //String Array of size 100 created to store item list
        String[] itemList = new String[100];
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        //The loop will continue until bye is entered and record the item and display listed item from list command
        while(!line.equals("bye")){
            for(int i=0;i<100;i++) {
                if(line.equals("list")) {
                    System.out.print("____________________________________________________________\n");
                    for(int j=0;j<i;j++) {
                        System.out.print(j+1+". " + itemList[j] + "\n");
                    }
                    System.out.print("____________________________________________________________\n");
                    i-=1;
                }
                else {
                    itemList[i] = line;
                    System.out.print("____________________________________________________________\n");
                    System.out.print("added: " + line);
                    System.out.print("\n____________________________________________________________\n");
                }
                line = in.nextLine();
                if (line.equals("bye")){
                    break;
                }
            }
        }
        System.out.print("____________________________________________________________\n");
        System.out.print("Bye. Hope to see you again soon!\n");
        System.out.print("____________________________________________________________\n");
    }
}




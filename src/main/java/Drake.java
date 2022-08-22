import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Drake {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("media/logo.txt"));
        StringBuilder logo = new StringBuilder();
        while (sc.hasNextLine())
            logo.append(sc.nextLine()).append("\n");
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
        System.out.println("You used to call me on my cellphone\n" + logo);
        System.out.println("Drake's (me) the kind of guy to help you out uwu");
        System.out.println("Go ahead, make that hotline bling");
        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");

        sc = new Scanner(System.in);
        String command = sc.nextLine();
        ArrayList<Task> list = new ArrayList<>();
        while (!Objects.equals(command, "bye")) {
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                int i = 1;
                for (Task item : list)
                    System.out.println(i++ + ". " + item);
            } else if (command.startsWith("mark")) {
                String[] commands = command.split(" ");
                int taskNo = Integer.parseInt(commands[1]);
                System.out.println("I've marked this task as done!");
                list.get(taskNo - 1).markAsDone();
                System.out.println(list.get(taskNo - 1));
            } else if (command.startsWith("unmark")) {
                String[] commands = command.split(" ");
                int taskNo = Integer.parseInt(commands[1]);
                System.out.println("I've marked this task as not done (yet ;))");
                list.get(taskNo - 1).unmarkAsDone();
                System.out.println(list.get(taskNo - 1));
            } else {
                System.out.println("added: " + command);
                list.add(new Task(command));
            }
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            command = sc.nextLine();
        }
        System.out.println("I'm down for you always. See you (✿˶˘ ³˘)~♡");
    }

}

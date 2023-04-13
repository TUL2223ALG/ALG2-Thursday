package week07_cmd;

import java.io.IOException;
import java.util.Scanner;

public class CmdApp {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //System.out.println(System.getProperties());
        //System.out.println(System.getProperty("file.separator"));
        //System.out.println(System.getProperty("user.dir"));

        CommandLine cmd = new CommandLine();
        boolean end = false;
        String command;
        while (!end) {
            System.out.print(cmd.getActualDir() + ">");
            command = sc.nextLine();
            String[] parts = command.split(" ");
            try {
                switch (parts[0]) {
                    case "dir":
                        if (parts.length == 1){
                        System.out.println(cmd.dir());
                        } else {
                            System.out.println(cmd.dir(parts[1]));
                        }
                        break;
                    case "exit":
                        end = true;
                        break;
                    case "mkfile":
                        boolean wasCreated = cmd.mkfile(parts[1]);
                        if (!wasCreated) {
                            System.out.println("Soubor již existuje.");
                        }
                        break;
                    case "cd":
                        cmd.cd(parts[1]);
                        break;
                    case "rm":
                        boolean wasDeleted = cmd.rm(parts[1]);
                        if (!wasDeleted) {
                            System.out.println("Soubor nelze smazat.");
                        }
                        break;
                    default:
                        System.out.println("Neplatny prikaz");
                }
            } catch (IOException e) {
                System.out.println("Soubor nelze vytvořit");
            } catch (FileException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Playing {
    public static void main(String[] args) {
        String data = "";
        String path = "C:/Users/hanen/Downloads/TestingFolder";

        File dir = new File(path);
        System.out.println(dir.isDirectory());

        File[] FilewithPath = dir.listFiles(); // return an Array of Files inside TestingFolder
        System.out.println(Arrays.toString(FilewithPath));

        try {
            File f = new File("./Datafile.txt");
            if (f.createNewFile()) {
                System.out.println("New File created!");
                System.out.println(f.getAbsoluteFile());
            } else {
                System.out.println("The file already exists.");
                try {
                    Scanner sc = new Scanner(f);

                    while (sc.hasNextLine()) {
                        data = data + "\n" + sc.nextLine();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found ");
                    System.out.println(e.getCause());
                }
                System.out.println(data);
                f.delete();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
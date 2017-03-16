import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final String INPUT_FILE = "INPUT.TXT";
    public static final String OUTPUT_FILE = "OUTPUT.TXT";
    public static int n = 0;

    public static void main(String[] args) {
        try {
            parseFileAndCalculate();
            writeFile();
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода/выводв! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        }

    }

    private static void parseFileAndCalculate() throws IOException {

        List<Integer> indexList = new ArrayList<Integer>();

        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));

        String line = scanner.nextLine();
        char[] chars = line.toCharArray();

        for (int i = 0; i < chars.length - 4; i++) {

            if ((chars[i] == '>') & (chars[i + 1] == '>') & (chars[i + 2] == '-') & (chars[i + 3] == '-') & (chars[i + 4] == '>')) {
                n++;
            } else if ((chars[i] == '<') & (chars[i + 1] == '-') & (chars[i + 2] == '-') & (chars[i + 3] == '<') & (chars[i + 4] == '<')) {
                n++;
            }
        }
        scanner.close();
    }


    private static void writeFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(OUTPUT_FILE);
            Writer output = new BufferedWriter(fw);
//            output.append(summArr + " ");
//            output.append(multArr + "");
            output.append(n + "");
            output.flush();
            output.close();
            fw.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}




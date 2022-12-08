package homeWork12;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class HomeWork12Task1 {
    public static void main(String[] args) throws Exception {
        File file1 = new File("in1.txt");
        writeToTxt(file1);
        readFromFile(file1);

        File file2 = new File("in2.txt");
        writeToTxt(file2);
        readFromFile(file2);

        File file3 = new File("out.txt");

        List<Path> inputs = Arrays.asList(Paths.get("in1.txt"), Paths.get("in2.txt"));
        Path output = Paths.get("out.txt");
        Charset charset = StandardCharsets.UTF_8;

        for (Path path : inputs) {
            List<String> lines = Files.readAllLines(path, charset);
            Files.write(output, lines, charset, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }

        readFromFile(file3);
    }

    public static void writeToTxt(File fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            Random random = new Random();
            List<Long> integerList = new ArrayList<>();
            for (long index = 0; index < 1000; index++) {
                integerList.add(random.nextLong(99999) + 1);
                Collections.sort(integerList);
            }
            writer.write(integerList.toString());
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFromFile(File fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8), 1024)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                System.out.println(fileName + ": " + line);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


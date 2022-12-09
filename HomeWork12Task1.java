package homeWork12;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HomeWork12Task1 {
    public static void main(String[] args) throws Exception {
        writeNumbersInFile(new File("in1.txt"));
        writeNumbersInFile(new File("in2.txt"));

        List<Path> inputs = Arrays.asList(Paths.get("in1.txt"), Paths.get("in2.txt"));
        Path output = Paths.get("out.txt");

        for (Path path : inputs) {
            List<String> lines = Files.readAllLines(path, UTF_8);
            Files.write(output, lines, UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }
    }

    public static void writeNumbersInFile(File fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, UTF_8))) {
            Random random = new Random();
            List<Long> integerList = new ArrayList<>();
            for (long index = 0; index < 1000; index++) {
                integerList.add(random.nextLong(99999) + 1);
                Collections.sort(integerList);
            }
            writer.write(String.valueOf(integerList));
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Error. Check entered parameters.");
        }
    }
}


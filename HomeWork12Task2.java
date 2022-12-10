package homeWork12;

import java.io.*;

public class HomeWork12Task2 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.append("In the middle of December, we buy a New Year's tree, " +
                    "which we decorate with my parents. It's traditional " +
                    "because it brings us together and we really have fun doing it." +
                    "Also, before New Year's Day, we always clean the house and create a festive atmosphere." +
                    " I like to decorate the house with paper snowflakes, candles, and garlands.");
            writer.flush();
        } catch (IOException ex) {
            System.out.println("File is not written.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (IOException ex) {
            System.out.println("File not found.");
        }

        System.out.print("Words in text: ");
        countInText(file, "\\s");

        System.out.print("Punctuations marks in text: ");
        countInText(file, "\\p{Punct}");
    }

    public static void countInText(File file, String regex) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] byteArray = new byte[(int) file.length()];
            fileInputStream.read(byteArray);
            String str = new String(byteArray);

            String[] strArray = str.split(regex);
            int counter = 0;
            for (String text : strArray) {
                counter++;
            }
            System.out.println(counter);

        } catch (IOException ex) {
            System.out.println("File is empty.");
        }
    }
}



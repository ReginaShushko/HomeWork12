package homeWork12;

import java.io.*;

public class HomeWork12Task2 {
    public static void main(String[] args) {
        File file = new File("text.txt");
        try (FileWriter writer = new FileWriter(file)) {
            String text = "In the middle of December, we buy a New Year's tree, " +
                    "which we decorate with my parents. It's traditional" +
                    "because it brings us together and we really have fun doing it." +
                    "Also, before New Year's Day, we always clean the house and create a festive atmosphere." +
                    "I like to decorate the house with paper snowflakes, candles, and garlands.";
            writer.write(text);
            writer.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)) {
            int counter;
            while ((counter = reader.read()) != -1) {
                System.out.print((char) counter);
            }
            System.out.println();

        } catch (IOException ex) {
            ex.printStackTrace();
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
            ex.printStackTrace();
        }
    }
}


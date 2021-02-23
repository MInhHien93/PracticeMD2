package FileCSV;

import Entities.PhoneBook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileCSV {
    private static final String COMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String PATH = "src/data/contacts.csv";
    private static final String FILE_HEADER = "phoneNumber, group, name, gender, address, email";

    public static void writePhoneBookToFileCSV(ArrayList<PhoneBook> phoneBooks) throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(PATH);
            fw.append(FILE_HEADER);
            fw.append(NEW_LINE_SEPARATOR);
            for (PhoneBook p : phoneBooks) {
                fw.append(p.getPhoneNumber());
                fw.append(COMA_DELIMITER);
                fw.append(p.getGroup());
                fw.append(COMA_DELIMITER);
                fw.append(p.getName());
                fw.append(COMA_DELIMITER);
                fw.append(p.getGender());
                fw.append(COMA_DELIMITER);
                fw.append(p.getAddress());
                fw.append(COMA_DELIMITER);
                fw.append(p.getEmail());
                fw.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi ghi file CSV!");
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (Exception e) {
                System.out.println("Lỗi khi đóng luồng và đồng bộ!");
            }
        }
    }

    public static ArrayList<PhoneBook> readPhoneBooksFileCSV() {
        BufferedReader br = null;
        ArrayList<PhoneBook> phoneBooks = new ArrayList<>();
        Path path = Paths.get(PATH);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(PATH);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            br = new BufferedReader(new FileReader(PATH));
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("phoneNumber")) {
                    continue;
                }
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.setPhoneNumber(splitData[0]);
                phoneBook.setGroup(splitData[1]);
                phoneBook.setName(splitData[2]);
                phoneBook.setGender(splitData[3]);
                phoneBook.setAddress(splitData[4]);
                phoneBook.setEmail(splitData[5]);
                phoneBooks.add(phoneBook);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return phoneBooks;
    }
}

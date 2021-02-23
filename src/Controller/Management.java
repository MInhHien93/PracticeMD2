package Controller;

import Entities.PhoneBook;
import FileCSV.FileCSV;

import java.io.IOException;
import java.util.ArrayList;

public class Management {
    public static ArrayList<PhoneBook> phoneBooks = new ArrayList<>();

    public void showAll() {
        phoneBooks = FileCSV.readPhoneBooksFileCSV();
        for (PhoneBook p : phoneBooks) {
            System.out.println(p.toString());
        }
    }

    public void add(PhoneBook phoneBook) {
        phoneBooks = FileCSV.readPhoneBooksFileCSV();
        phoneBooks.add(phoneBook);
        try {
            FileCSV.writePhoneBookToFileCSV(phoneBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(String phoneNumber, PhoneBook phoneBook) {
        phoneBooks = FileCSV.readPhoneBooksFileCSV();
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                p.setPhoneNumber(phoneBook.getPhoneNumber());
                p.setGroup(phoneBook.getGroup());
                p.setName(phoneBook.getName());
                p.setGender(phoneBook.getGender());
                p.setAddress(phoneBook.getAddress());
                p.setEmail(phoneBook.getEmail());
            }
        }
        try {
            FileCSV.writePhoneBookToFileCSV(phoneBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(String phoneNumber) {
        phoneBooks = FileCSV.readPhoneBooksFileCSV();
        for (PhoneBook p : phoneBooks) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                phoneBooks.remove(p);
            }
        }
        try {
            FileCSV.writePhoneBookToFileCSV(phoneBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PhoneBook searchByName(String name) {
        phoneBooks = FileCSV.readPhoneBooksFileCSV();
        PhoneBook phoneBook = null;
        for (PhoneBook p : phoneBooks) {
            if (p.getName().equals(name)) {
                phoneBook.setPhoneNumber(p.getPhoneNumber());
                phoneBook.setGroup(p.getGroup());
                phoneBook.setName(p.getName());
                phoneBook.setGender(p.getGender());
                phoneBook.setAddress(p.getAddress());
                phoneBook.setEmail(p.getEmail());
            }
        }
        return phoneBook;
    }
}

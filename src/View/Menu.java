package View;

import Entities.PhoneBook;

public class Menu {

    public static PhoneBook getPhoneBookInfo() {
        System.out.println("Enter a phone number:");
        String phoneNumber = Program.sc.nextLine();
        System.out.println("Enter  a group:");
        String group = Program.sc.nextLine();
        System.out.println("Enter a name:");
        String name = Program.sc.nextLine();
        System.out.println("Enter a gender:");
        String gender = Program.sc.nextLine();
        System.out.println("Enter an address:");
        String address = Program.sc.nextLine();
        System.out.println("Enter an email:");
        String email = Program.sc.nextLine();
        return new PhoneBook(phoneNumber, group, name, gender, address, email);
    }
}

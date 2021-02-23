package View;

import Controller.Management;
import Entities.PhoneBook;
import FileCSV.FileCSV;

import java.util.Scanner;

public class Program {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Management management = new Management();
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----\n" +
                "Chọn chức năng theo số (để tiếp tục):\n" +
                "1.Xem danh sách\n" +
                "2.Thêm mới\n" +
                "3.Cập nhật\n" +
                "4.Xóa\n" +
                "5.Tìm kiếm theo tên\n" +
                "6.Đọc từ file\n" +
                "7.Ghi vào file\n" +
                "8.Thoát\n" +
                "Chọn chức năng: ");
        try {
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    management.showAll();
                    break;
                case 2:
                    System.out.println("Enter a phone book: ");
                    System.out.println("--------------------");
                    PhoneBook phoneBook = Menu.getPhoneBookInfo();
                    management.add(phoneBook);
                    break;
                case 3:
                    System.out.println("Enter a phone number to change: ");
                    String phoneNumber = sc.nextLine();
                    PhoneBook updatePhoneBook = Menu.getPhoneBookInfo();
                    management.update(phoneNumber, updatePhoneBook);
                    break;
                case 4:
                    System.out.println("Enter a phone number to delete: ");
                    String phoneNumberDelete = sc.nextLine();
                    management.delete(phoneNumberDelete);
                    break;
                case 5:
                    System.out.println("Enter a name to find: ");
                    String name = sc.nextLine();
                    management.searchByName(name);
                    break;
                case 6:
                    FileCSV.readPhoneBooksFileCSV();
                    break;
                case 7:
                    FileCSV.writePhoneBookToFileCSV(FileCSV.readPhoneBooksFileCSV());
                    break;
                case 8:
                    System.exit(8);
                    break;
                default:
                    System.out.println("!!!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Thử lại!");
        }
    }
}

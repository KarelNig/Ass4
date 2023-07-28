package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main2 {
    public static void main(String[] args) {
        Main user1 = new Main("Petrov VV", 75, "SE", "21.07.2001", "87074003939");
        System.out.println("Name: " + user1.getFullName());
        System.out.println("Card ID: " + user1.getId());
        System.out.println("Faculty: " + user1.getFaculty());
        System.out.println("Date of birth: " + user1.getBirth());
        System.out.println("Phone number: " + user1.getNumber());



        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books you want to add: ");
        int numBooksToAdd = scanner.nextInt();
        scanner.nextLine();

        String[] newBooks = {"Book1","Book2","Book3","Book4","Book5"};
        user1.addBooks(newBooks);

        for (int i = 0; i < numBooksToAdd; i++) {
            System.out.print("Enter the title of book " + (i + 1) + ": ");
            newBooks[i] = scanner.nextLine();
        }

        user1.reserveBook("Book3");
        user1.reserveBook("Book4");

        System.out.print(user1.getFullName() + " now has books: ");
        for (int i = 0; i < user1.getAmountOfBooks(); i++) {
            if (i < user1.getAmountOfBooks() - 1) {
                System.out.print(user1.getBooks()[i] + ", ");
            } else {
                System.out.println(user1.getBooks()[i] + ".");
            }
        }

        System.out.print("Enter the title of the book you want to reserve: ");
        String bookToReserve = scanner.nextLine();
        user1.reserveBook(bookToReserve);

        System.out.print("Enter the title of the book you want to cancel the reservation for: ");
        String bookToCancel = scanner.nextLine();
        user1.cancelReservation(bookToCancel);

        System.out.print("Enter the title of the book you want to extend the reservation for: ");
        String bookToExtend = scanner.nextLine();
        user1.extendReservation(bookToExtend);

        System.out.print("Enter the category to search books: ");
        String category = scanner.nextLine();
        String[] booksInCategory = user1.searchBooksByCategory(category);
        if (booksInCategory.length == 0) {
            System.out.println("No books found in the category: " + category);
        } else {
            System.out.println("Books in the category " + category + ":");
            for (String book : booksInCategory) {
                System.out.println(book);
            }
        }
    }
}
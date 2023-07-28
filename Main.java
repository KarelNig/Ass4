package library;

import java.util.*;

public class Main {
    private String fullName;
    private int id;
    private String faculty;
    private String birth;
    private String number;

    private String[] books;
    private boolean[] reservedStatus;
    private int amountOfBooks;

    public Main(String fullName, int id, String faculty, String birth, String number) {
        this.fullName = fullName;
        this.id = id;
        this.faculty = faculty;
        this.birth = birth;
        this.number = number;

        this.books = new String[0];
        this.reservedStatus = new boolean[0];
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBirth() {
        return birth;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void takeBook(String[] args){
        this.books = args;
        amountOfBooks = args.length;
        System.out.print(fullName + " took books: ");
        for(int i = 0; i < args.length; i++){
            if(i < args.length-1) {
                System.out.print(args[i] + ", ");
            }
            else{
                System.out.println(args[i]+ ".");
            }
        }
    }

    public void addBooks(String[] newBooks) {
        int currentLength = books.length;
        int newLength = currentLength + newBooks.length;
        String[] updatedBooks = new String[newLength];
        boolean[] updatedReservedStatus = new boolean[newLength];

        System.arraycopy(books, 0, updatedBooks, 0, currentLength);
        System.arraycopy(reservedStatus, 0, updatedReservedStatus, 0, currentLength);

        System.arraycopy(newBooks, 0, updatedBooks, currentLength, newBooks.length);

        for (int i = currentLength; i < newLength; i++) {
            updatedReservedStatus[i] = false;
        }

        books = updatedBooks;
        reservedStatus = updatedReservedStatus;
        amountOfBooks += newBooks.length;
    }

    public int getAmountOfBooks() {
        return amountOfBooks;
    }

    public String[] getBooks() {
        return books;
    }
    private boolean[] getReservedStatus;
    //бронь
    public void reserveBook(String bookTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(bookTitle)) {
                if (!reservedStatus[i]) {
                    reservedStatus[i] = true;
                    System.out.println("Book \"" + bookTitle + "\" has been reserved.");
                    return;
                } else {
                    System.out.println("Book \"" + bookTitle + "\" is already reserved.");
                    return;
                }
            }
        }
        System.out.println("Book \"" + bookTitle + "\" not found in the library.");
    }

    public void cancelReservation(String bookTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(bookTitle)) {
                if (reservedStatus[i]) {
                    reservedStatus[i] = false;
                    System.out.println("Reservation for book \"" + bookTitle + "\" has been canceled.");
                    return;
                } else {
                    System.out.println("Book \"" + bookTitle + "\" is not reserved.");
                    return;
                }
            }
        }
        System.out.println("Book \"" + bookTitle + "\" not found in the library.");
    }


    public void extendReservation(String bookTitle) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].equalsIgnoreCase(bookTitle)) {
                if (reservedStatus[i]) {
                    System.out.println("Reservation for book \"" + bookTitle + "\" has been extended.");
                    return;
                } else {
                    System.out.println("Book \"" + bookTitle + "\" is not reserved.");
                    return;
                }
            }
        }
        System.out.println("Book \"" + bookTitle + "\" not found in the library.");
    }

    private Map<String, List<String>> categories = new HashMap<>();

    public void addBookToCategory(String bookTitle, String category) {
        if (!categories.containsKey(category)) {
            categories.put(category, new ArrayList<>());
        }
        List<String> booksInCategory = categories.get(category);
        if (!booksInCategory.contains(bookTitle)) {
            booksInCategory.add(bookTitle);
        }
    }
    public String[] searchBooksByCategory(String category) {
        List<String> matchingBooks = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : categories.entrySet()) {
            String currentCategory = entry.getKey();
            if (currentCategory.toLowerCase().contains(category.toLowerCase())) {
                matchingBooks.addAll(entry.getValue());
            }
        }
        return matchingBooks.toArray(new String[0]);
    }
}


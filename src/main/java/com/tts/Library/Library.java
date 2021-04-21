package com.tts;

import java.util.ArrayList;

public class Library {

    String libraryAdd;
    ArrayList<Book> bookType;

    public Library(String address) {
        this.libraryAdd = address;
        this.bookType = new ArrayList();
    }

    public void addBook(Book book) {
        this.bookType.add(book);
    }

    public void printAddress() {
        System.out.println(this.libraryAdd);
    }

    public void printAvailableBooks() {
        boolean clearLibrary = true;

        for(int i = 0; i < this.bookType.size(); ++i) {
            Book libraryBook = (Book)this.bookType.get(i);
            if (!libraryBook.isBorrowed()) {
                System.out.println(libraryBook.getTitle());
                clearLibrary = false;
            }
        }

        if (clearLibrary) {
            System.out.println("Sorry, our inventory is cleared");
        }

    }

    public String borrowBook(String bookTitle) {
        for(int i = 0; i < this.bookType.size(); ++i) {
            Book libraryBook = (Book)this.bookType.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (!libraryBook.isBorrowed()) {
                    libraryBook.borrowed();
                    System.out.println("We have " + libraryBookTitle + ", borrowed accepted!");
                    return null;
                }

                System.out.println("Someone else has " + libraryBookTitle + " Sorry!");
                return null;
            }
        }

        System.out.println("Your book is not in our inventory, sorry.");
        return null;
    }

    public String returnBook(String bookTitle) {
        boolean inventory = false;

        for(int i = 0; i < this.bookType.size(); ++i) {
            Book libraryBook = (Book)this.bookType.get(i);
            String libraryBookTitle = libraryBook.getTitle();
            if (libraryBookTitle.equals(bookTitle)) {
                if (libraryBook.isBorrowed()) {
                    libraryBook.returned();
                    System.out.println("Returned accepted: " + libraryBookTitle + "!");
                    inventory = true;
                    break;
                }

                if (!inventory) {
                    System.out.println("Sorry that book is not in our system? I'll keep checking!");
                }
            }
        }

        System.out.println();
        return null;
    }
}
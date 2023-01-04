package org.example;


import org.example.entities.Book;
import org.example.entities.Librarian;
import org.example.entities.Library;
import org.example.entities.User;
import org.example.enums.Type;
import org.example.services.serviceImpl.LibraryServiceImpl;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Librarian librarian = new Librarian("Fabian");

        Book Mathematics = new Book("Mathematics","Victor");
        Book English = new Book("English","Taiwo");
        Book Biology = new Book("Biology","Blessing");
        Book Chemistry = new Book("Chemistry","Emmanuel");

        User Mary = new User(Type.JUNIOR_STUDENT,"Mary", 3);
        User Okeke = new User(Type.TEACHERS,"Okeke", 1);
        User Matthew = new User(Type.SENIOR_STUDENT,"Matthew", 2);
        User Efe = new User(Type.SENIOR_STUDENT,"Efe", 2);
        User Laura = new User(Type.JUNIOR_STUDENT,"Laura", 3);

        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();

        libraryServiceImpl.addToBookList(Mathematics,3);
        libraryServiceImpl.addToBookList(English,3);
//        libraryServiceImpl.addToBookList(Biology,4);
//        libraryServiceImpl.addToBookList(Chemistry,4);

 //       System.out.println(libraryServiceImpl1.addlibraryUsers(Mary,Type.JUNIOR_STUDENT));
       libraryServiceImpl.addlibraryUsers(Okeke,Type.TEACHERS);
       libraryServiceImpl.addlibraryUsers(Matthew,Type.SENIOR_STUDENT);
        libraryServiceImpl.addlibraryUsers(Efe,Type.SENIOR_STUDENT);
        libraryServiceImpl.addlibraryUsers(Laura,Type.JUNIOR_STUDENT);
        libraryServiceImpl.addlibraryUsers(Mary,Type.JUNIOR_STUDENT);

        libraryServiceImpl.addToQueueList(Laura,Mathematics);
        libraryServiceImpl.addToQueueList(Efe,Mathematics);
        libraryServiceImpl.addToQueueList(Okeke,Mathematics);
        libraryServiceImpl.addToQueueList(Matthew,Mathematics);

        //System.out.println(libraryServiceImpl.getQueueList());

        System.out.println(libraryServiceImpl.giveBooksUsingQueue(Mathematics));
        System.out.println(libraryServiceImpl.giveBooksUsingQueue(Mathematics));
        System.out.println(libraryServiceImpl.giveBooksUsingQueue(Mathematics));
        System.out.println(libraryServiceImpl.giveBooksUsingQueue(Mathematics));
//
//        libraryServiceImpl.addToPriorityList(Efe,English);
//        libraryServiceImpl.addToPriorityList(Mary,Mathematics);
//        libraryServiceImpl.addToPriorityList(Okeke,Mathematics);
//       libraryServiceImpl.addToPriorityList(Matthew,Mathematics);
//
//        System.out.println(libraryServiceImpl.getPriorityQueueList());
//
//        System.out.println(libraryServiceImpl.giveBooksUsingPriorityQueue(Mathematics));
//        System.out.println(libraryServiceImpl.giveBooksUsingPriorityQueue(Mathematics));
//        System.out.println(libraryServiceImpl.giveBooksUsingPriorityQueue(Mathematics));
//        System.out.println(libraryServiceImpl.giveBooksUsingPriorityQueue(Mathematics));







    }
}
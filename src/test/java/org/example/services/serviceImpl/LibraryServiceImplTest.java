package org.example.services.serviceImpl;

import org.example.entities.*;
import org.example.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    Library library;
    Librarian librarian;
    User user;
    Book book;
    Queue<User> queueList;
    Queue<User> queueList1;
    PriorityQueue<User> priorityQueueList;
    Map<Book, Integer> bookList = new HashMap<>();
    Map<User, Type> usersList = new HashMap<>();

    @BeforeEach
    void setup(){

        user = new User();
        user.setType(Type.JUNIOR_STUDENT);
        user.setName("Efe");
        user.setId(3);


        User teacher = new User();
        teacher.setType(Type.TEACHERS);
        teacher.setName("Okeke");
        teacher.setId(1);

        User seniorStudent = new User();
        seniorStudent.setType(Type.SENIOR_STUDENT);
        seniorStudent.setName("Laura");
        seniorStudent.setId(2);

        book = new Book();
        book.setName("Mathematics");
        book.setAuthor("victor");

        librarian = new Librarian();
        librarian.setName("Okonkwo");

        library = new Library(book,user,librarian);



        queueList = new LinkedList<>();
        queueList.add(user);
       queueList.add(teacher);
       queueList.add(seniorStudent);

//        queueList1 = new LinkedList<>();


        priorityQueueList = new PriorityQueue<>(Comparator.comparingInt(User::getId));
        priorityQueueList.add(user);
        priorityQueueList.add(teacher);
        priorityQueueList.add(seniorStudent);

    }

    @Test
    void addToBookList() {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = book.getName() + " Book has been added";
        String actual = libraryServiceImpl.addToBookList(book, 3);
        assertEquals(expected,actual);
    }

    @Test
    void libraryUseralreadyexist() {

        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = user.getName() + " is on the list ";
        libraryServiceImpl.addlibraryUsers(user, Type.JUNIOR_STUDENT);
        String actual = libraryServiceImpl.addlibraryUsers(user, Type.JUNIOR_STUDENT);
        assertEquals(expected,actual);
    }

    @Test
    void  addLibraryUser() {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = user.getName() + " has been added";
        String actual = libraryServiceImpl.addlibraryUsers(user, Type.JUNIOR_STUDENT);
        assertEquals(expected,actual);


    }

    @Test
    void addToQueueList() {

        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = user.getName() + " has been added to the queue list";
        libraryServiceImpl.addlibraryUsers(user, Type.JUNIOR_STUDENT);
        libraryServiceImpl.addToBookList(book,2);
        String actual = libraryServiceImpl.addToQueueList(user, book);
        assertEquals(expected,actual);
    }
    @Test
    void notAddedToQueueList(){
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = " There is no book request for "+ user.getName();
        String actual = libraryServiceImpl.addToQueueList(user, book);
        assertEquals(expected,actual);

    }

    @Test
    void giveBooksUsingQueue() {

        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        libraryServiceImpl.setQueueList(queueList);
        String expected = book.getName() + " book has been given to " + queueList.peek().getName();
        libraryServiceImpl.addToBookList(book,2);
        libraryServiceImpl.addToQueueList(user,book);
        String actual = libraryServiceImpl.giveBooksUsingQueue(book);
        assertEquals(expected,actual);

    }
    @Test
    void cannotGiveBooksUsingQueue(){
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = book.getName() + " book is no longer available";
        String actual = libraryServiceImpl.giveBooksUsingQueue(book);
        assertEquals(expected,actual);
    }

    @Test
    void addToPriorityList() {
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = user.getName() + " has been added to the priority list";
        libraryServiceImpl.addToBookList(book, 2);
        libraryServiceImpl.addlibraryUsers(user, Type.JUNIOR_STUDENT);
        String actual = libraryServiceImpl.addToPriorityList(user, book);
        assertEquals(expected,actual);
    }
    @Test
    void  notaddedToPriorityList(){
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = " There is no book request for "+ user.getName();
        String actual = libraryServiceImpl.addToPriorityList(user, book);
        assertEquals(expected,actual);

    }

    @Test
    void giveBooksUsingPriorityQueue() {
//        bookList.put(book,4);
       // user.compareTo(user);
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = book.getName() + " Book has been given to " + priorityQueueList.peek().getName();
        libraryServiceImpl.addToBookList(book,2);
        libraryServiceImpl.addToPriorityList(user,book);
        libraryServiceImpl.addlibraryUsers(user, Type.JUNIOR_STUDENT);
        String actual = libraryServiceImpl.giveBooksUsingPriorityQueue(book);
        assertEquals(expected,actual);
    }
    @Test
    void cannotGiveBooksUsingPriorityQueue(){
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = book.getName() + " book is no longer available ";
        String actual = libraryServiceImpl.giveBooksUsingPriorityQueue(book);
        assertEquals(expected,actual);
    }
}
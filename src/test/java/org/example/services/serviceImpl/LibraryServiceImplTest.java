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
    PriorityQueue<User> priorityQueueList;
    Map<Book, Integer> bookList = new HashMap<>();
    Map<User, Type> usersList = new HashMap<>();

    @BeforeEach
    void setup(){

        user = new User();
        user.setType(Type.JUNIOR_STUDENT);
        user.setName("Efe");
        user.setId(101);


        User teacher = new User();
        teacher.setType(Type.TEACHERS);
        teacher.setName("Okeke");
        teacher.setId(2);

        User seniorStudent = new User();
        seniorStudent.setType(Type.SENIOR_STUDENT);
        seniorStudent.setName("Laura");
        seniorStudent.setId(40);

        book = new Book();
        book.setName("Mathematics");
        book.setAuthor("victor");

        librarian = new Librarian();
        librarian.setName("Okonkwo");

        library = new Library(book,user,librarian);

        Map<User, Type> userList1 = new HashMap<>();
        userList1.put(seniorStudent, Type.SENIOR_STUDENT);

        queueList = new LinkedList<>();
        queueList.add(user);
        queueList.add(teacher);
        queueList.add(seniorStudent);

        priorityQueueList = new PriorityQueue<>();
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
        usersList = new HashMap<>();
        usersList.put(user,Type.JUNIOR_STUDENT);
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = user.getName() + " is on the list ";
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
        bookList = new HashMap<>();
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = user.getName() + " has been added to the queue list";
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
        String actual = libraryServiceImpl.giveBooksUsingQueue(book);
        String expected = book.getName() + " book has been given to " + queueList.poll().getName();
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
        LibraryServiceImpl libraryServiceImpl = new LibraryServiceImpl();
        String expected = book.getName() + " Book has been given to " + priorityQueueList.poll().getName();
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
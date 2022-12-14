package org.example.services.serviceImpl;

import org.example.entities.Book;
import org.example.entities.User;
import org.example.enums.Type;

import java.util.*;

public class LibraryServiceImpl {
    public Map<Book, Integer> bookList = new HashMap<>();

    public Map<User, Type> usersList = new HashMap<>();
    Queue<User> queueList = new LinkedList<>();
    PriorityQueue<User> priorityQueueList = new PriorityQueue<>();

    public Queue<User> getQueueList() {
        return queueList;
    }

    public void setQueueList(Queue<User> queueList) {
        this.queueList = queueList;
    }

    public PriorityQueue<User> getPriorityQueueList() {
        return priorityQueueList;
    }

    public void setPriorityQueueList(PriorityQueue<User> priorityQueueList) {
        this.priorityQueueList = priorityQueueList;
    }

    public String addToBookList(Book book, int number){
        if(bookList.containsKey(book)){
            bookList.put(book, bookList.get(book) + number);
            return book.getName() + " Book has been added";
        }else{
            bookList.put(book, number);
                 return book.getName() + " Book has been added";
        }
    }

    public String addlibraryUsers(User user, Type type) {
        if (usersList.containsKey(user)) {
            return user.getName() + " is on the list ";
        } else {
            usersList.put(user, type);
            return user.getName() + " has been added";
        }

    }

    public String addToQueueList(User user, Book book) {
        if(usersList.containsKey(user)) {
            queueList.add(user);
            return user.getName() + " has been added to the queue list";
        } else {
            return " There is no book request for " + user.getName();
        }
    }

    public String giveBooksUsingQueue(Book book) {

        if (bookList.containsKey(book) && (bookList.get(book) > 0)) {
            bookList.put(book, bookList.get(book) - 1);
            queueList.peek();
            return book.getName() + " book has been given to " + queueList.poll().getName();
        }   else {
            return  book.getName() + " book is no longer available";
        }
    }

    public String addToPriorityList(User user, Book book) {

        if(usersList.containsKey(user)){
            priorityQueueList.add(user);
            return user.getName() + " has been added to the priority list";
        } else return " There is no book request for "+ user.getName();
    }

    public String giveBooksUsingPriorityQueue(Book book) {
        User user = priorityQueueList.peek();
        if (bookList.containsKey(book) && bookList.get(book) > 0) {
            bookList.put(book, bookList.get(book) - 1);
            priorityQueueList.peek();

            return  book.getName() + " Book has been given to " + priorityQueueList.poll().getName();
        } else {
            return book.getName() + " book is no longer available ";
        }
    }
}


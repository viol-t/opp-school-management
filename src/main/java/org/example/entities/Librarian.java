package org.example.entities;

public class Librarian{
private String name;

    public Librarian(String name) {
        this.name = name;
    }

    public Librarian() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                '}';
    }
}

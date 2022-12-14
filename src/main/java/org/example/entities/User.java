package org.example.entities;


import org.example.enums.Type;

import java.util.Comparator;

public class User implements Comparable<User> {
    private Type type;
   private String name;
   private int id;

    public User(Type type, String name, int id) {
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public User() {
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }



    @Override
    public int compareTo(User user) {
        if(this.getId() == user.getId()){
            return 0;
        } else if(this.getId() < user.getId()){
            return -1;
        }else{
            return 1;
        }
    }
}

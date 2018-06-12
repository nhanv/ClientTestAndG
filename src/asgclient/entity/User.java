/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.entity;

/**
 *
 * @author Nguyen Van Nha
 */
public class User {
    private String email;
    private String password;
    private String name;
    private int age;

    public User() {
        email = null;
        password = null;
        name = null;
        age = -1;
    }

    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, String name, int age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public String toString (){
        StringBuilder result = new StringBuilder ();
        if (email !=null && !email.isEmpty())
            result.append("Email: ").append(email).append("\n");
        if (name != null && !name.isEmpty())
            result.append("Name: ").append(name).append("\n");
        if (age > 0 && age < 150)
            result.append("Age: ").append("\n");
        return result.toString();
    }
    
}

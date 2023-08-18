/*............................................
    Library Management System
    Autor: Madhusanka Wijerathne
    Java OOP design 
  ...........................................*/

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
 
class Student {
 
    HashMap<Integer, String> student = new HashMap<>();
    Scanner input = new Scanner(System.in);
 
    // add students
    void add() {
        student.put(101, "Niall");
        student.put(102, "Anna");
    }
 
    // register student
    void addStudent() {
 
        System.out.println("Enter your name: ");
        String name = input.next();
        System.out.println("Enter your id: ");
        int id = input.nextInt();
        student.put(id, name);
    }
}
 
class Book {
 
    HashMap<Integer, String> book = new HashMap<>();
 
    // add books
    void add() {
        book.put(11, "The Fault in our Stars");
        book.put(22, "A Good Book");
    }
}
 
class Issue {
 
    // store book issued by student
    HashMap<Integer, String> issue = new HashMap<>();
 
    Scanner input = new Scanner(System.in);
 
    Book b1 = new Book();
    Student s1 = new Student();
 
    public Issue() {
 
        // add elements to student HashMap
        s1.add();
 
        // add elements to book HashMap
        b1.add();
    }
 
    // method to issue book
    void issueBook(int id) {
 
        System.out.println("enter a book");
        String bookName = input.nextLine();
 
        // check if book is inside the book hashmap
        if (b1.book.containsValue(bookName)) {
 
            // get book id to remove it from the book HashMap
            int bookId = 0;
            // iterate each entry of hashmap
            for (Entry<Integer, String> entry : b1.book.entrySet()) {
 
                // if give value is equal to value from entry
                // print the corresponding key
                if (entry.getValue().equals(bookName)) {
                    bookId = entry.getKey();
                    break;
                }
            }
 
            // add value of student id and book to issue hashmap
            issue.put(id, bookName);
 
            // remove book from the book hashmap
            b1.book.remove(bookId);
 
            // get student name from id
            String name = s1.student.get(id);
            // print name and issued book
            System.out.println("Name: " + name);
            System.out.println("Book: " + bookName);
            System.out.println("Book issued Congratulation");
        }
 
        else {
            System.out.println("Book doesn't exist");
            System.out.println("We have following Books:");
            System.out.println(b1.book);
        }
 
    }
 
    void returnBook(int id) {
 
        issue.put(101, "A Good Book");
        
        if (issue.containsKey(id)) {
            System.out.println("enter a book to return");
            String bookName = input.nextLine();
           
            //get book id
            int bookId = 0;
            // iterate each entry of hashmap
            for (Entry<Integer, String> entry : b1.book.entrySet()) {
 
                // if give value is equal to value from entry
                // print the corresponding key
                if (entry.getValue().equals(bookName)) {
                    bookId = entry.getKey();
                    break;
                }
            }
 
            // check if book is issued
            if (issue.containsValue(bookName)) {
 
                // remove issue record form issue HashMap
                issue.remove(id);
 
                // add book back to book hashmap
                b1.book.put(bookId, bookName);
 
                // print name of student and book
                // get student name from id
                String name = s1.student.get(id);
                System.out.println("Name: " + name);
                System.out.println("Book: " + bookName);
                System.out.println("Book returned");
 
            }
 
            else {
                System.out.println("Book is not issued.");
            }
 
        } else {
            System.out.println("You haven't issued any book");
        }
    }
 
    void getPurpose(int id) {
 
        Issue i1 = new Issue();
        String purpose;
        
        System.out.println("Enter your purpose: return or issue");
        purpose = input.next();
 
        if (purpose.equals("issue")) {
 
            i1.issueBook(id);
 
        } else if (purpose.equals("return")) {
 
            i1.returnBook(id);
        }
    }
}
 
class Main {
 
    public static void main(String[] args) {
 
        Issue i1 = new Issue();
 
        Student s1 = new Student();
        // add student to student hashmap
        s1.add();
 
        Scanner input = new Scanner(System.in);
 
        System.out.println("Enter your Id: ");
        int id = input.nextInt();
 
        // check if student is registered
        if (s1.student.containsKey(id)) {
            i1.getPurpose(id);
        }
 
        // ask if student want to register
        else {
            System.out.println("Be a member? yes or no");
            String answer = input.next();
            if (answer.equals("yes")) {
                s1.addStudent();
                System.out.println("You are registered.");
                i1.getPurpose(id);
            } 
            else {
                System.out.println("Okay, bye");
            }
        }
    }
}
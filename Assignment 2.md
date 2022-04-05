# Basic Assignment 2

1.	Why we need packages in java?
    - prevent naming conflicts
    - control access
    - make searching / locating and usage of classes, interfaces, enumrations and annotations easier.

2.	What is the default imported package?
    1.  unnamed package which is the default package
        - package with no name are imported by java compiler automatically
    2.  java.lang package
        - java.lang is imported implicitly
    3.  the package being editing
        - current java package is imported by java compiler automatically
3.	What is Class? What is Object?
    - The class keyword is used to declare a new Java class, which is a collection of related variables and/or methods. Classes are the basic building blocks of object−oriented programming. A class typically represents some real−world entity such as a geometric Shape or a Person. A class is a template for an object. Every object is an instance of a class. To use a class, you instantiate an object of the class, typically with the new operator, then call the classes methods to access the features of the class.

    -  An object stores its state in fields (variables in some programming languages) and exposes its behavior through methods (functions in some programming languages). Methods operate on an object's internal state and serve as the primary mechanism for object-to-object communication. Hiding internal state and requiring all interaction to be performed through an object's methods is known as data encapsulation — a fundamental principle of object-oriented programming.
    
4.	Why we need constructor?

    - we initialize object with default or initial state.
    - some constructors have required parameters, which ask users to provide necessary information.

5.	What is the default value of local variable? What is the default value of instance variable?
    - local variable is variable declared inside a method
        1.  local variable has no default value
    - instance variable is variable decalred inside a class but not in any method
        1.  numeric types has 0 as default value
        2.  boolean type has false as default value
        3.  object has null as default value
6.	What is garbage collection?

    - Automatic garbage collection is the process of looking at heap memory, identifying which objects are in use and which are not, and deleting the unused objects. An in use object, or a referenced object, means that some part of your program still maintains a pointer to that object. An unused object, or unreferenced object, is no longer referenced by any part of your program. So the memory used by an unreferenced object can be reclaimed.

7.	The protected data can be accessed by subclasses or same package. True or false?
    - True, protected modifer allows access from package, class and subclass.
    
8.	What is immutable class?
    - immutable classes once created never change their value
    1.  final class
    2.  private final fields
    3.  no setter
    4.  return deep copy of collections for getter
9.	What’s the difference between “==” and equals method?
    - "==" compare if the 2 operands are the same object while equals method compares the value of them
10.	What is wrapper class?
    - wrapper class provides a way to use primitive data type as object, every wrapper class has a corresponding primitive type.
11.	What is autoboxing?
    - autoboxing is automatic conversion by java compiler from primitive type to its corresponding wrapper class
12.	StringBuilder is threadsafe but slower than StringBuffer, true or false?
    - false, StringBuilder is not thread safe.
13.	Constructor can be inherited, true or false?
    - false
14.	How to call a super class’s constructor?
    > super()
15.	Which class is the super class of all classes?
    - Object()
16.	Create a program to count how many files/folders are there inside one folder.
•	the count method should take a parameter called Criteria like this: count(Criteria criteria){}
•	For Criteria class, multiple conditions should be included such as: folder path, includeSubFolder or not, the extension of the file be counted and so on. 
•	Optional: Take the input from keyboard.
•	Take care of the invalid inputs. Exception handling.
•	Get proper result displayed.
”There are XXX file(s) and XXX folder(s) inside folder XXX with extension XXX.” or something user friendly.
~~~
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Criteria c = new Criteria();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter folder path: ");
        String path = sc.nextLine();
        if(!isValidPath(path)) {
            System.out.println(path + " is not a valid path");
            return;
        }
        c.setFolderPath(path);
        System.out.println("Do you want to include folders? Y / N");
        String include = sc.nextLine();
        if(include.equalsIgnoreCase("y")) {
            c.setIncludeSubFolder(true);
        } else if(include.equalsIgnoreCase("n")) {
            c.setIncludeSubFolder(false);
        } else {
            System.out.println("Entered: " + include + "\nPlease enter Y or N");
            return;
        }
        System.out.println("Enter extension: ");
        c.setExtension(sc.nextLine());

        count(c);
    }

    public static void count(Criteria c) {
        try {
            File f = new File(c.getFolderPath());
            String[] files = f.list();
            int fileCounter = 0;
            int folderCounter = 0;
            for(int i = 0; i < files.length; i++){
                if(getExtensionByStringHandling(files[i]).equals(Optional.empty())) {
                    folderCounter++;
                } else if(getExtensionByStringHandling(files[i]).get().equals(c.getExtension())) {
                    fileCounter++;
                }
            }
            if(c.isIncludeSubFolder()) {
                System.out.println("There are " + fileCounter + " file(s) and " + folderCounter + " folder(s) inside folder " + c.getFolderPath() + " with extension " + c.getExtension() + ".");
            } else {
                System.out.println("There are " + fileCounter + " file(s) inside folder " + c.getFolderPath() + " with extension " + c.getExtension() + ".");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException ex) {
            return false;
        }
        return true;
    }
}

class Criteria {
    private String folderPath;
    private boolean includeSubFolder;
    private String extension;

    public Criteria (String folderPath, boolean includeSubFolder, String extension) {
        this.folderPath = folderPath;
        this.includeSubFolder = includeSubFolder;
        this.extension = extension;
    }

    public Criteria() {

    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public void setIncludeSubFolder(boolean include) {
        this.includeSubFolder = include;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public boolean isIncludeSubFolder() {
        return includeSubFolder;
    }

    public String getExtension() {
        return extension;
    }
}

~~~


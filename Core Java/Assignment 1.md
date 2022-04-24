# Basic Assignment 1

1.	What is JDK? JRE? JVM?

    1.  **JDK: Java Development Kit**
        
    - Java Development Kit is a distribution of Java technology by Oracle Corporation, which implements the Java Language Specification (JLS) and Java Virtual Machine Specification (JVMS) and provides the Standard Edition (SE) of Java Application Programming Interface (API).

    2.  **JRE: Java Runtime Environment**
        
    - JRE is a software layer runs on operating system which provides class libraries and other sources to enable java program to run. 
    - JRE also create the instance of JVM.
    - JRE uses heap space for dynamic memory allocation for Java objects. 
    - JRE is also used in JDB (Java Debugging).

    3.  **JVM: Java Virtual Machine**

    - JVM loads, verifies and executes Java bytecode compiled by java compiler.
    - JVM has 3 main components.

        1.  **Class Loader** is responsible for loading, linking and initializing a Java class fil, otherwise known as dynamic programming.
        2.  **Runtime Data Area** contain method areas, PC registers, stack area and threads.
        3.  **Execution Engine** contains an interpreter, compiler and garbage collection

2.	What is java compiler?
    
    - java compiler compiles .java file to java bytecode which can be interpreted into machine code by JVM. javac is an implementation by Oracle.

3.	Why is java platform independent?

    - Because java program will be compile to java bytecode regardless of operating system. However, JVM which interprets java bytecode into machine code is platform-dependent.

4.	What is IDE? Why is it important for developers?
    
    - IDE: Integrated Development Environment
    - IDE usually contains soure code editor, build automation and debugger. Some of them could have version contorl system and other features as well. It's important to developers as they are designed to maximize developers' productivity by providing them Graphic User Interface (GUI). 

5.	Is java case sensitive?

    - Java is case sensitive

6.	What do the following key words do?
    1.  static

        1.  static class
            - Only inner class can be static
        2.  static method
            - static method can be called as ClassName.StaticMethod(parameters) without instanciating the class.
        3.  static block
            - statements in static blocks are executed only once as the class is loaded into memory.
        3.  static variable
            - static variable can be accessed across all instances of it.
    2.  final
        1.  final class
            - final class cannot be extended
        2.  final method
            - final method cannot be overriden
        3.  final variable
            - final variable cannot be modified and must be initialized
    3.  public
        - public modifier defines the access level as world, which allows references from other packages
        1.  public class
        2.  public method
        3.  public variable
    
    4.  private
        - private modifer defines the access level as class level, which only allows reference from the same class
        1.  private class
        2.  private method
        3.  private variable
    5.  void
        - void represents the null type as a return type.
    6.  null
        - null represents no value
        - assigning null value to non-primitive variable has the effect of releasing the object to which the variable previously referred. 
        - null cannot be assigned to primitive types.
    7.  package
        - package specifies the Java package in which the classes declared in a Java source file reside.
    8.  Class
        - The class keyword is used to declare a new Java class, which is a collection of related variables and/or methods.
    9.  new
        - new keyword is used to create new instance of a class.
7.	What is primitive type and reference type?
    - Primitive type are predefined data type, they specify the size and type. 
    - Reference type are not predefined, they are reference to object which contains the stored data.
8.	Is parameter passed by value or reference?
    - Passed by value, however mutable object's value can be changed when it's passed to a method.
9.	What is the output: System.out.println(1 > 0 ? "A":"B");
    - A
10.	How to define constants in java?
    1.  use final and static
        > final static int MAX = 100;
    2.  use final 
        > final int MAX = 100;
    3.  use enum
        > public enum Color {
            RED("Red"), Green("Green");
        }
11.	What is String? Is it primitive type?
    - String is a class of java.lang which contains a sequence of characters.
    - String is not a primitive type.
12.	How to check if a String is representing a number?
    1.  using parse method of numeric class
        > Integer.parseInt(String)
        > Integer.valueOf(String)
        > Float.parseFloat(String)
        > Double.parseDouble(String)
        > Long.parseLong(String)
        > new BigInteger(String)
    2.  using regular expression
        > numeric = string.matches("-?\\d+(\\.\\d+)?");
13.	Write a program to implement the following activity diagram:
    ~~~
    import java.util.Scanner;

    public class Assignment1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a positive integer: ");
            String input = in.nextLine();

            if(input.equals("q")) {
                System.out.println("Thank you for using!");
            } else {
                try {
                    int x = Integer.parseInt(input);
                    if(x > 0) {
                        for(int i = 0; i < x; i++) {
                            doSomething(x);
                        }
                    } else {
                        System.out.println("Invalid input, please enter a positive integer.");
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        }
        private static void doSomething(int x) {
            System.out.println((x * x + x) / 2);
        }
    }
    ~~~
14.	Write a program to merge two array of int.
    ~~~
    import java.util.ArrayList;
    import java.util.List;

    public class Assignment1 {
        public static void main(String[] args) {
            int[] array1 = {1,3,5,7,9};
            int[] array2 = {2,4,6,8,0};
            List<Integer> merge = mergeInt(array1, array2);
            for(int i : merge) {
                System.out.println(i);
           }
        }
        private static List<Integer> mergeInt(int[] array1, int[] array2) {
            List<Integer> result = new ArrayList<>();
            for(int i : array1) {
                result.add(i);
            }
            for(int i : array2) {
                result.add(i);
            }
            return result;
        }
    }
    ~~~
15.	Write a program to find the second largest number inside an array of int.
    ~~~
    public class Assignment1 {
        public static void main(String[] args) {
            int[] array = {2,4,6,8,0};
            System.out.println(findSecondLargest(array));
        }
        private static int findSecondLargest(int[] array) {
            if(array.length < 2) {
                System.out.println("Array is too short.");
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int secondMax = Integer.MIN_VALUE;
            for(int i = 0; i < array.length; i++) {
                int num = array[i];
                if(num > max) {
                secondMax = max;
                max = num;
                } else if(num < max && num > secondMax) {
                    secondMax = num;
                }
            }
            return secondMax;
        }
    }
    ~~~

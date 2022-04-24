1.  used keywords (48)
    1.  data type (8)
        byte 8-bit [-2^7, 2^7 - 1]
            signed integer value by 2's complement
        short 16-bit [-2^15, 2^15 - 1]
            signed integer value by 2's complement
        int 32b-bit [-2^31, 2^31 - 1]
            signed integer value by 2's complement
        long 64-bit [-2^63, 2^63 - 1]
            signed integer value by 2's complement
        float 32-bit [see IEEE 754, could underflow and overflow]
            signed floating point by IEEE 754
        double 64-bit [see IEEE 754, could underflow and overflow]
            signed floating point by IEEE 754
        char 16-bit ['\u0000', '\uffff']
            characters encoded by unicode
        boolean 1-bit [true, false]
            true / false
    2.  flow control (11)

        //conditions must be boolean expressions
        if(condition_1) {
            ...
        }else if(condition_2) {
            ...
        }else if(condition_3) {
            ...
        }else {
            ...
        }

        // values are possible values of variable
        switch (variable) {
            case value_1 :
                ...
                break;
            case value_2 :
                ...
                break;
            case value-3 :
                ...
                break;
            default:
                ...
                break;
        }
        
        for(int i = 0; i < max; i++){
            ...
        }
        for(int i: nums){
            ...
        }

        do{
            ...
        }while(condition);

        while(condition){
            ...
        }
        
        break
            1.  unlabeled break
                break terminates current loop / switch
            2.  labeled break
                break terminates labeled loop / switch
                search:
                    for (i = 0; i < arrayOfInts.length; i++) {
                        for (j = 0; j < arrayOfInts[i].length; j++) {
                            if (arrayOfInts[i][j] == searchfor) {
                                foundIt = true;
                                break search;
                            }
                        }
                    }
        contine
            1.  unlabeled continue
                continue skip current iteration
            2.  labeled continue
                continue skip labeled iteration
                test:
                    for (int i = 0; i <= max; i++) {
                        int n = substring.length();
                        int j = i;
                        int k = 0;
                        while (n-- != 0) {
                            if (searchMe.charAt(j++) != substring.charAt(k++)) {
                                continue test;
                            }
                        }
                        foundIt = true;
                        break test;
                    }
        return
            return terminates current callee and return to caller
            return can return a value or nothing
                1.  return value's data type must match that declared by the method
                2.  if method is void method, then just use return

    3.  modifiers (10)

        Access Level    public  protected   no modifier private   
        class           yes     yes         yes         yes
        package         yes     yes         yes         no
        subclass        yes     yes         no          no
        world           yes     no          no          no
            
        final
            1.  final class
                final class cannot be subclassed
            2.  final method
                final method cannot be overriden
            3.  final variable
                final variable cannot be changed once initialized
            
        abstract
            1.  abstract class
                abstract class cannot be instanciated but could be subclassed
            2.  abstract method
                abstract method is a method declared without implementation
                abstract void moveTo(double deltaX, double deltaY);

        synchronized
            synchronized method will be inaccessible to other threads once one threads have access
            this is a simple solution to multi-thread, but it's not thread safe for all situation and not affective as all threads blocked will compete once the synchronized method is released

        native
            1.  native keyword can only be used to decorate method
            2.  it's Java Native Interface (JNI) which allows java code to coperate with other languages such as C / C++
        
        strictfp
            1.  strictfp is short for strict floating point
            2.  it could be used to decorate class / interface / concrete method / variables, but not abstract method
            3.  it ensures floating point by IEEE 754 on different platforms (16 / 32 / 64 bit) to produce same result
        transient
            1.  transient variable
                transient variable will not be saved in serialization, reasons can be as followed
                1.  private credentials
                2.  value of variable could be calculated
        volatile
            1.  volatile variables are shared by multi-threads, modification by in any thread will affect other threads
    4.  exception handling (6)
        //At least one of catch or finally is necessary
        //multiple catch blocks can coexist
        //finally block will execute anyway
        try {
            ...
        } catch (Exception ex1) {
            ...
        } catch (Exception ex2) {
            ...
        } finally {
            ...
        }

        //only Throwable can be thrown
        throw new Exception();

        throws
            type method_name(parameters) throws exception_list
            exception_list is a comma separated list of all the 
            exceptions which a method might throw.

            public void method(int i) throws ArithmeticException, IOException {
                ...
            }
        
        assert
            assert assumes the following boolean expression to be true, other wise it throws AssertionError
            2 possiblt syntax
                1.  assert expression;
                2.  assert expression_1 : expression_2;
                    expression_1 : boolean expression to be evaluated
                    expression_2 : error info to be printed
    5.  class related
        class
            The class keyword is used to declare a new Java class, which is a collection of related variables and/or
            methods
            class ClassName{
                ...
            }
        package
            The package keyword specifies the Java package in which the classes declared in a Java source file reside.
            package com.company
            
            public class MyClass {
                ...
            }
        
        import
            The import keyword makes one class or all classes in a package visible in the current Java source file.
            Imported classes can be referened without the use of fully−qualified class names.

            import java.util.Collections;
        
        extends
            The extends keyword is used in a class or interface declaration to indicate that the class or interface being
            declared is a subclass of the class or interface whose name follows the extends keyword.
            Class extends class and interface extends interface

            public class Rectangle extends Polygon {
                ...
            }

            public interface Football extends Sports {
                ...
            }

        implements
            The implements keyword is used in a class declaration to indicate that the class being declared provides
            implementations for all methods declared in the interface whose name follows the implements keyword.
            Class implements interface

            public class Truck implements IVehicle {
                ...
            }
        interface
            The interface keyword is used to declare a new Java interface, which is a collection of methods.
            Interfaces are a powerful feature of the Java language. Any class may declare that it implements one or more
            interfaces, meaining it implements all of the methods defined in those interfaces.
            interface's naming usually start with I to differentiate with class

             public interface IPolygon {
                public float getArea();
                public int getNumberOfSides();
                public int getCircumference();
            }


    6.  object related keywords
        new
            The new keyword is used to create a new instance of a class.

            String str = new String("Hello");

        instanceof
            The instanceof keyword is used to determine the class of an object.
            subclass of class / interface to be evaluated will be true.

            if (node instanceof TreeNode) {
                ...
            }

        super
            The super keyword refers to the superclass of the class in which the keyword is used.
            1.  super as a standalone statement, it is a call of default constructor of its super class
            2.  super.<methodname> is calling static method of super class
            public class MyClass {
                public MyClass(String arg) {
                    super(arg);
                }
                public String myStringMethod() {
                    return super.otherStringMethod();
                }
            }

        this
            The this keyword refers to the current instance.

            public class MyClass {
                int number;
                public MyClass(int number) {
                    this.number = number;
                }
            }  

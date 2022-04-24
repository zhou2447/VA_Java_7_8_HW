# Basic Assignment 3
1.	Explain polymorphism.
    *   **Polymorphism**

        The dictionary definition of polymorphism refers to a principle in biology in which an organism or species can have many different forms or stages. This principle can also be applied to object-oriented programming and languages like the Java language. Subclasses of a class can define their own unique behaviors and yet share some of the same functionality of the parent class.

        In Java, polymorphism shows in 2 forms
        1.  **Overriding**
            *   The overriding method has the same ***name***, ***number*** and ***type*** of ***parameters***, and ***return type*** as the method that it overrides. An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.
        2.  **Overloading**
            *   The Java programming language supports overloading methods, and Java can distinguish between methods with different method signatures. This means that methods within a class can have the same name if they have different ***parameter lists*** (there are some qualifications to this that will be discussed in the lesson titled "Interfaces and Inheritance").

            *   Suppose that you have a class that can use calligraphy to draw various types of data (strings, integers, and so on) and that contains a method for drawing each data type. It is cumbersome to use a new name for each method—for example, drawString, drawInteger, drawFloat, and so on. In the Java programming language, you can use the same name for all the drawing methods but pass a different argument list to each method. Thus, the data drawing class might declare four methods named draw, each of which has a different parameter list.
2.	What is overloading?
    *   The Java programming language supports overloading methods, and Java can distinguish between methods with different method signatures. This means that methods within a class can have the same name if they have different ***parameter lists*** (there are some qualifications to this that will be discussed in the lesson titled "Interfaces and Inheritance").

    *   Suppose that you have a class that can use calligraphy to draw various types of data (strings, integers, and so on) and that contains a method for drawing each data type. It is cumbersome to use a new name for each method—for example, drawString, drawInteger, drawFloat, and so on. In the Java programming language, you can use the same name for all the drawing methods but pass a different argument list to each method. Thus, the data drawing class might declare four methods named draw, each of which has a different parameter list.
3.	What is overriding?
    *   The overriding method has the same ***name***, ***number*** and ***type*** of ***parameters***, and ***return type*** as the method that it overrides. An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.
4.	What does the final mean in this method:  public void doSomething(final Car aCar){}
    *   final keyword on arguments prevents reassignment, which makes compile error.
5.	Suppose in question 4, the Car class has a method setColor(Color color){…}, inside doSomething method, Can we call aCar.setColor(red)?
    *   this call is valid, final keyword only prevents reassignment.
6.	Can we declare a static variable inside a method?
    *   No, static variable can only be declared in a class but outside a method, constructor and block.
7.	What is the difference between interface and abstract class?
    *   Abstract classes are similar to interfaces. You cannot instantiate them, and they may contain a mix of methods declared with or without an implementation. However, with abstract classes, you can declare fields that are not static and final, and define public, protected, and private concrete methods. With interfaces, all fields are automatically public, static, and final, and all methods that you declare or define (as default methods) are public. In addition, you can extend only one class, whether or not it is abstract, whereas you can implement any number of interfaces.

    *   **Consider using abstract classes if any of these statements apply to your situation:**
        *   You want to share code among several closely related classes.
        *   You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
        *   You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.

    *   **Consider using interfaces if any of these statements apply to your situation:**
        *   You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
        *   You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
        *   You want to take advantage of multiple inheritance of type.
8.	Can an abstract class be defined without any abstract methods?
    *   Yes, public, protected and private concrete methods are all allowed in abstract class.
9.	Since there is no way to create an object of abstract class, what’s the point of constructors of abstract class?
    *   You want to share code among several closely related classes.
    *   You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
    *   You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.
10.	What is a native method?
    *   A native method is a Java method (either an instance method or a class method) whose implementation is also written in another programming language such as C/C++.
11.	What is marker interface?
    *   Marker Interface is a design pattern commonly used, where marker interface is an empty interface.
    
    *   Cloneable, Serializable and Remote and examples of marker interface
    *   Classes implements Cloneable have to override clone() method in Object, otherwise CloneNotSupportedException will be thrown.
12.	Why to override equals and hashCode methods?
    *   "==" only compares if the 2 operands have references to the same object. To compare the equality of the objects, we have to override equals() method and compare their fields.
    *   After overriding equals() method, it's necessary to override hashCode() method as well. Otherwise, equals objects will not be hashed to same bucket in Collections that use hashCode().
13.	What’s the difference beween int and Integer?
    *   int is a primitive type
    *   Integer is a wrapper class
14.	What is serialization?
    *   serialization is to write java object in files with its object type, data types stored and data stored in that objects.
    *   with files contain serialized object, recreation object in the same memory and another system is possible.
15.	Create List and Map. List A contains 1,2,3,4,10(integer) . Map B contains ("a","1") ("b","2") ("c","10")   (key = string, value =   string) 
    Question: get a list which contains all the elements in list A, but not in map B.
    ~~~
    import java.util.*;
    import java.util.stream.Collectors;

    public class Assignment3 {
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,10));
            Map<String, String> map = new HashMap<>();
            map.put("a", "1");
            map.put("b", "2");
            map.put("c", "10");
            System.out.println(list.stream().filter(e -> !map.containsValue(e.toString()) && !map.containsKey(e.toString())).collect(Collectors.toList()));
        }
    }
    ~~~
16.	Implement a group of classes that have common behavior/state as Shape. Create Circle, Rectangle and Square for now as later on we may need more shapes. They should have the ability to calculate the area. They should be able to compare using area. Please write a program to demonstrate the classes and comparison.  You can use either abstract or interface. Comparator or Comparable interface.
    ~~~
    public class Assignment3 {
        public static void main(String[] args) {
            Circle c = new Circle(1);
            Rectangle r = new Rectangle(2,2);
            Square s = new Square(2);
            compareShape(c, s);
            compareShape(r, s);
        }
        public static void compareShape(Shape s1, Shape s2) {
            switch (s1.compareTo(s2)) {
                case 0:
                    System.out.println(s1.toString() + " is as big as " + s2.toString());
                    break;
                case 1:
                    System.out.println(s1.toString() + " is bigger than " + s2.toString());
                    break;
                case -1:
                    System.out.println(s1.toString() + " is smaller than " + s2.toString());
                    break;
                default:
                    System.err.println("Shape Comparison Error");
                    break;
            }

        }
    }

    interface Shape extends Comparable<Shape>{
        double area();
        String toString();

        @Override
        public default int compareTo(Shape other) {
            final double TOLERANCE = 0.000001D;
            double thisArea = area();
            double otherArea = other.area();
            if(Math.abs(thisArea - otherArea) < TOLERANCE) {
                return 0;
            }
            return thisArea > otherArea ? 1 : -1;
        }
    }

    class Circle implements Shape {
        protected double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        public double area() {
            return Math.PI * radius * radius;
        }

        public String toString() {
            return "Circle with radius of " + String.valueOf(radius);
        }
    }

    class Rectangle implements Shape {
        protected double width;
        protected double length;

        Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double area() {
            return length * width;
        }

        public String toString() {
            return "Rectangle with length of " + String.valueOf(length) + " and width of " + String.valueOf(width);
        }
    }

    class Square extends Rectangle {

        Square(double length) {
            super(length, length);
        }

        public String toString() {
            return "Square with length of " + String.valueOf(length);
        }
    }
    ~~~



# Basic Assignment 4
1.  What’s the difference between final, finally? What is finalize()?
    1.  final
        1.  final class
            *   prevent ineritance
        2.  final method
            *   prevent overriding
        3.  final variable
            *   prevent reassignment
    2.  finally
        *   The finally block always executes when the try block exits. This ensures that the finally block is executed even if an unexpected exception occurs. But finally is useful for more than just exception handling — it allows the programmer to avoid having cleanup code accidentally bypassed by a return, continue, or break. Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.
    3.  finalize()
        *   **Deprecated.**
        The finalization mechanism is inherently problematic. Finalization can lead to performance issues, deadlocks, and hangs. Errors in finalizers can lead to resource leaks; there is no way to cancel finalization if it is no longer necessary; and no ordering is specified among calls to finalize methods of different objects. Furthermore, there are no guarantees regarding the timing of finalization. The finalize method might be called on a finalizable object only after an indefinite delay, if at all. Classes whose instances hold non-heap resources should provide a method to enable explicit release of those resources, and they should also implement AutoCloseable if appropriate. The Cleaner and PhantomReference provide more flexible and efficient ways to release resources when an object becomes unreachable.
2.  What’s the difference between throw and throws?
    *   throws is a keyword used in method signature which indicates exceptions might be thrown by the method.
    *   throw is used in method or block to throw exceptions explicitly.
3.  What are the two types of exceptions?
    1.  checked exceptions
        *   checked exceptions will result in compile error
        *   exceptions that's under throwable but not Error and RuntimeException are checked exceptions
        *   Example: IOException, FileNotFoundException
    2.  unchecked exceptions
        *   unchecked exceptions will compile but result in runtime error
        *   Example: ArithmeticException
4.  What is error in java?
    *   An Error is a subclass of Throwable that indicates serious problems that a reasonable application should not try to catch. Most such errors are abnormal conditions. The ThreadDeath error, though a "normal" condition, is also a subclass of Error because most applications should not try to catch it.
    *   A method is not required to declare in its throws clause any subclasses of Error that might be thrown during the execution of the method but not caught, since these errors are abnormal conditions that should never occur. That is, Error and its subclasses are regarded as unchecked exceptions for the purposes of compile-time checking of exceptions.
5.  Exception is object, true or false?
    *   True, exception is a class and they can be instantiated as object.
6.  Can a finally block exist with a try block but without a catch?
    *   Yes, but at lease one catch block or finally block is necessary.
7.  From java 1.7, give an example of the try-resource feature.
    *   The try-with-resources statement is a try statement that declares one or more resources. A resource is an object that must be closed after the program is finished with it. The try-with-resources statement ensures that each resource is closed at the end of the statement. Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.

    *   The following example reads the first line from a file. It uses an instance of FileReader and BufferedReader to read data from the file. FileReader and BufferedReader are resources that must be closed after the program is finished with it:

    ~~~
	static String readFirstLineFromFile(String path) throws IOException {
	    try (FileReader fr = new FileReader(path);
	         BufferedReader br = new BufferedReader(fr)) {
	        return br.readLine();
	    }
	}
    ~~~
8.  What will happen to the Exception object after exception handling?
    *   The exception object will be garbage collectde in the next garbage collection
9.  Can we use String as a condition in switch(str){} clause?
    *   Yes for java version after JDK 7
    *   but the using string can be expensive compared to primitive types
    *   String should not be null
    *   It's case sensitive
    *   switch case is still more efficient than if-else statements
10. What’s the difference between ArrayList, LinkedList and vector?
    1.  ArrayList
        *   ArrayList uses dynamic array and supports random access so it has better performance in getter and setter.
    2.  LinkedList
        *   LinkedList is implemented by doubly linked list, so it has better performance in adding and removing.
    3.  Vector
        *   Vector is a legacy class and it's similar to ArrayList, but the main difference between them is that Vector is synchronized while ArrayList is not, so ArrayList will have better performance than Vector but Vector is thread-safe.
11. What’s the difference between hashTable and hashMap?
    1.  hashTable is synchronized while hashMap is not.
    2.  as hashTable is synchronized, its performance is worse than hashMap
    3.  hashTable doesn't allow null key or value, while hashMap allows one null key and multiple null values.

12. What is static import?
    *   Qualified reference is necesary to access static variables of other classes. But not all times we want to import the whole class, so we only import the static variable from that package.
13. What is static block?
    *   statements in static block will only executes once when the class is loaded into memory, it's usually used as static initialization of a class.
14. Explain the keywords:
    *   default(java 1.8)
        *   The default keyword is used to label the default branch in a switch statement.
        ~~~
        int arg = <some value>;
        switch (arg)
        {
            case 1:
                <statements>
                break;
            case 2:
                <statements>
                break;
            default:
                <statements>
                break;
        }
        ~~~
    *   break
        1.  unlabeled break
            *   break terminates current loop / switch
        2.  labeled break
            *   break terminates labeled loop / switch
            ~~~
            search:
            for (i = 0; i < arrayOfInts.length; i++) {
                for (j = 0; j < arrayOfInts[i].length; j++) {
                    if (arrayOfInts[i][j] == searchfor) {
                        foundIt = true;
                        break search;
                    }
                }
            }
            ~~~
    *   continue
        1.  unlabeled continue
            *   continue skip current iteration
        2.  labeled continue
            *   continue skip labeled iteration
            ~~~
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
                    continue test;
                }
    *   synchronized
        *   synchronized method will be inaccessible to other threads once one threads have access
        *    this is a simple solution to multi-thread, but it's not thread safe for all situation and not affective as all threads blocked will compete once the synchronized method is released
    *   strictfp
        *   strictfp is short for strict floating point
        *   it could be used to decorate class / interface / concrete method / variables, but not abstract method
        *   it ensures floating point by IEEE 754 on different platforms (16 / 32 / 64 bit) to produce same result
    *   transient
        *   transient variable
            *   transient variable will not be saved in serialization, reasons can be as followed
                1.  private credentials
                2.  value of variable could be calculated
    *   volatile
        *   volatile variables are shared by multi-threads, modification by in any thread will affect other threads
    *   instanceOf
        *   The instanceof keyword is used to determine the class of an object.
        *   subclass of class / interface to be evaluated will be true.
            ~~~
            if (node instanceof TreeNode) {
                ...
            }
            ~~~
15. Create a program including two threads – thread read and thread write.
    *   Input file ->Thread read -> Calculate -> buffered area
    *   Buffered area -> Thread write -> output file
    *   Detailed description is in assignment4.txt file.
    *   Sample input.txt file.
    *   Attached files are input.txt and a more detailed description file.
    ~~~
    import java.io.*;
    import java.util.LinkedList;

    public class Assignment4 {
        public static void main(String[] args) throws InterruptedException, IOException {
            final String inputPath = "C:\\Users\\leviz\\VA_Java_7_8\\src\\main\\resources\\input.txt";
            final String outputPath = "C:\\Users\\leviz\\VA_Java_7_8\\src\\main\\resources\\output.txt";
            final BufferArea bufferArea = new BufferArea(inputPath, outputPath);
            Thread t1 = new Thread(() -> {
                try {
                    bufferArea.produce();
                }
                catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    bufferArea.consume();
                }
                catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();

            bufferArea.stop();
        }
        public static class BufferArea {
            private static String inputPath;
            private static String outputPath;
            private int capacity;
            private FileReader reader;
            private FileWriter writter;
            private StreamTokenizer tokenizer;
            private LinkedList<Object> tokens;
            private String operator;
            private Double sum;

            public BufferArea (String in, String out) throws FileNotFoundException, IOException {
                inputPath = in;
                outputPath = out;
                tokens = new LinkedList<>();
                capacity = 2;
                reader = new FileReader(inputPath);
                writter = new FileWriter(outputPath);
                tokenizer = new StreamTokenizer(reader);
                tokenizer.whitespaceChars(' ', ' ');
                tokenizer.wordChars('+', '-');
                operator = null;
                sum = 0d;
            }

            public void stop() throws IOException {
                reader.close();
                writter.close();
            }

            // Function called by producer thread
            public void produce() throws InterruptedException, IOException {
                int currentToken;

                while (true) {
                    synchronized (this)
                    {
                        // producer thread waits while list
                        // is full
                        while (tokens.size() == capacity)
                            wait();

                        currentToken = tokenizer.nextToken();
                        if(currentToken != StreamTokenizer.TT_EOF) {
                            if(tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                                tokens.add(tokenizer.nval);
                            } else if(tokenizer.ttype == StreamTokenizer.TT_WORD) {
                                tokens.add(tokenizer.sval);
                            } else {
                                tokens.add(Character.toString((char)currentToken));
                            }
                        }

                        // notifies the consumer thread that
                        // now it can start consuming
                        notify();
                    }
                }
            }

            // Function called by consumer thread
            public void consume() throws InterruptedException, IOException {
                while (true) {
                    synchronized (this)
                    {
                        // consumer thread waits while list
                        // is empty
                        while (tokens.size() == 0)
                            wait();

                        // to retrieve the first job in the list

                        Object o = tokens.removeFirst();
                        if(o instanceof Double) {
                            if(operator != null) {
                                writter.write(sum.toString() + " " + operator + " " + o + " = ");
                                if(operator.equals("-")) {
                                    sum -= (Double) o;
                                } else if (operator.equals("+")) {
                                    sum += (Double) o;
                                }
                                writter.write(sum.toString() + "\n");
                            } else {
                                sum = (Double) o;
                            }
                        } else if(o instanceof String) {
                            if(o.equals("-")) {
                                operator = "-";
                            }else if(o.equals("+")) {
                                operator = "+";
                            }
                        }

                        // Wake up producer thread
                        notify();
                    }
                }
            }
        }
    }
    ~~~
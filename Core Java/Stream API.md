1.  Given a list of Objects, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters. TIP: Use Java 8 Lambdas and Streams API's.
    ~~~
    public static List<String> search(List<Person> list) {
        return list.stream().filter(p -> p.getName().startsWith("a") && p.getName().length() == 3).map(Person::getName).collec(Collectors.toList());
    }
    ~~~
2.  Write a method that returns a comma separated string based on a given list of integers. Each element should be preceded by the letter 'e' if the number is even, preceded by the letter 'o' if the number is odd. For example, if the input list is (3,44), the output should be 'o3,e44'.
    ~~~
    public static String getString(List<Integer> list) {
        return list.stream().map(i -> {
            if(i % 2 == 0) {
                return "e" + i.toString();
            } else {
                return "o" + i.toString();
            }
        }).collect(Collectors.joining(","));
    }
    ~~~
3.  Write a method that returns the average of a list of integers.  
    ~~~
    public static Double avg(List<Integer> list) {
        return list.stream().mapToDouble(Integer::doubleValue).average().getAsDouble();
    }
    ~~~
4.  Write a method that converts all strings in a list to their upper case.
    ~~~
    public static List<String> upperCase(List<String> list) {
        return list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
    }
    ~~~

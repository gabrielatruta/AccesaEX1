package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        /*
        - maps a key to value
        - duplicate keys aren't allowed, but duplicate values are
        - doesn't maintain an order
        - allows null values and a null key
         */
        HashMap<Integer, String> postalCodes = new HashMap<>();
        /*
        Add items to the HashMap
         */
        postalCodes.put(450084, "Zalau, Aleea Kiss Karoly, nr. 2");
        postalCodes.put(400001, "Cluj-Napoca, Str. Calea Motilor nr. 1-39; 2-40;");
        postalCodes.put(400363, "Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80");

        /*
        Access an item from HashMap while iterating through it
         */
        System.out.println("EX1:\n");
        for (Map.Entry<Integer, String> set: postalCodes.entrySet())
            System.out.println("Street with the postal code " + set.getKey() + " is: " + set.getValue());

        System.out.println("\n");

        System.out.println("EX2:\n All the streets from the HashMaps:\n" );
        for(String streets: postalCodes.values())
            System.out.println(streets);

        /*
        Checking if the map contains a certain band
         */
        if (postalCodes.containsValue("Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80"))
            System.out.println("\nThe street Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80 exists in the HashMap");
        else
            System.out.println("\nThe street Cluj-Napoca, Str. Observatorului, nr. 105-113; 72-80 doesn't exist in the HashMap");

        /*
        Size of the hashmap
         */
        System.out.println("\nThe number of entries from the Hashmap: " + postalCodes.size());

        /*
        Removing an item from HashMap
         */
        postalCodes.remove(450084);
        System.out.println("\nThe number of entries from the Hashmap after removing an entry: " + postalCodes.size());

        /*
        Removing all the items from the HashMap
         */
        postalCodes.clear();
        System.out.println("\nThe number of entries from the Hashmap after removing everything: " + postalCodes.size());
        System.out.println("--------------------------------------------------------------------------------------------");

        /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        - doesn't allow duplicate values
        - has a single null value
        - doesn't guarantee the order of the elements
         */
        HashSet<String> bands = new HashSet<>();

        /*
        Add items to HashSet
         */
        bands.add("Led Zeppelin");
        bands.add("Rolling Stones");
        bands.add("Red Hot Chili Peppers");
        bands.add("Cage the Elephant");

        /*
        Accessing the items from the HashSet while iterating through it
         */
        for (String band: bands)
            System.out.println(band);

        /*
        Checking if the set contains a certain band
         */
        if (bands.contains("Grouplove"))
            System.out.println("\nThe band Grouplove exists in the HashSet");
        else
            System.out.println("\nThe band Grouplove doesn't exist in the HashSet");

        /*
        Size of the HashSet
         */
        System.out.println("\nThere are " + bands.size() + " bands in the set");

        /*
        Remove an entry
         */
        bands.remove("Cage the Elephant");
        System.out.println("\nThere are " + bands.size() + " bands in the set after removing Cage The Elephant");

        /*
        Remove all entries
         */
        bands.clear();
        System.out.println("\nThere are " + bands.size() + " bands in the set");
        System.out.println("--------------------------------------------------------------------------------------------");

         /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        - same as HashMap but the TreeMap maintains an order of the objects
         */
        TreeSet<String> names = new TreeSet<>();

        /*
        Add items to the TreeSet
         */
        names.add("Gabriela");
        names.add("Elena");
        names.add("Aniko");
        names.add("Valentina");

        /*
        Accessing the items while iterating through the TreeSet
         */
        for (String name: names)
            System.out.println(name);

        /*
        Accessing the items while iterating in descending order
         */
        Iterator<String> iterator = names.descendingIterator();
        System.out.println("Descending order of the TreeSet: ");
        while(iterator.hasNext())
            System.out.println(iterator.next());

        /*
        Check if a name is in the TreeSet
         */
        if (names.contains("Alexandru"))
            System.out.println("\nAlexandru is in the TreeSet");
        else
            System.out.println("\nAleandru isn't in the TreeSet");

        /*
        Size of the TreeSet
         */
        System.out.println("\nSize of the TreeSet is: " + names.size());

        /*
        Removing an entry
         */
        names.remove("Gabriela");
        System.out.println("\nSize after removing Gabriela from the TreeSet: " + names.size());

        /*
        Accessing the first entry
         */
        System.out.println("\nFirst entry from the TreeSet is: " + names.first());

        /*
        Accessing the last entry
         */
        System.out.println("\nLast entry from the TreeSet is: " + names.last());

        /*
        Removing all entries
         */
        names.clear();
        System.out.println("\nSize after removing every entry: " + names.size());
        System.out.println("--------------------------------------------------------------------------------------------");

         /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        - elements are not stored in a contiguous locations and every element is a separate object with a data part and address part
        - elements are linked using pointers and addresses
        - each element is known as a node
        - nodes cannot be accessed directly and we need to start from the head
         */
        LinkedList<String> animals = new LinkedList<>();

        /*
        Adding elements
         */
        animals.add("cat");
        animals.add("dog");
        //add as the first
        animals.addFirst("zebra");
        //add as the last
        animals.addLast("antilope");

        /*
        Iterating and accessing elements
         */
        System.out.println("EX1:\n");
        for ( int i=0; i < animals.size(); i++)
            System.out.println(animals.get(i));

        System.out.println("EX2:\n");
        for (String animal: animals)
            System.out.println(animal);

        /*
        Changing the list
         */
        System.out.println("\nThe list after changing it: \n");
        animals.add(1, "bat");
        for (String animal: animals)
            System.out.println(animal);

        /*
        Removing an item
         */
        animals.remove("antilope");
        animals.remove(1);
        System.out.println("\nThe list after removing elements: \n");
        for (String animal: animals)
            System.out.println(animal);
        System.out.println("--------------------------------------------------------------------------------------------");
        /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        /*
        STREAMS
         */
        List<Integer> randomNumbers = Arrays.asList(1, 2, 10, 98, 67, 44, 12);

        /*
        MAP + COLLECT
         */
        List<Integer> squareNumbers = randomNumbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println("Square Numbers: " + squareNumbers);

        /*
        FILTER
         */
        animals.add("Camel");
        animals.add("Cow");
        List<String> animalsWithC = animals.stream().filter(x -> x.startsWith("C")).collect(Collectors.toList());
        System.out.println("Animals that start with C: " + animalsWithC);

        names.add("Andrei");
        names.add("Robert");
        names.add("Xenia");
        names.add("Matei");
        names.add("Radu");
        Set<String> namesThatEndWithI = names.stream().filter(x -> x.endsWith("i")).collect(Collectors.toSet());
        System.out.println("Names that end with i: " + namesThatEndWithI);

        System.out.println("First name: " + names.stream().findFirst());
        System.out.println("Find any: " + names.stream().findAny());
        System.out.println("Starts with R: " + names.stream().anyMatch(x -> x.startsWith("R")));

        int result = squareNumbers.stream().reduce(0, (x, y) -> x + y % squareNumbers.size());
        System.out.println(result);

        Map<Object, Long> groupBy = names.stream().collect(Collectors.groupingBy(x-> x.startsWith("R"), Collectors.counting()));
        System.out.println("GroupBy: " + groupBy);

        List<String> animalsOrdered = animals.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted list of animals: " + animalsOrdered);

        List<Integer> reversedNumbers = randomNumbers.stream().collect(Collectors.toList());
        Collections.reverse(reversedNumbers);
        System.out.println("Reversed ordered list of numbers: " + reversedNumbers);

        System.out.println("--------------------------------------------------------------------------------------------");
        /*
        ----------------------------------------------------------------------------------------------------------------
         ---------------------------------------------------------------------------------------------------------------
          --------------------------------------------------------------------------------------------------------------
         */
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Gabriela", 23));
        persons.add(new Person("Gabriel", 55));
        persons.add(new Person("Garofita", 13));
        persons.add(new Person("Tudor", 24));
        Collections.sort(persons, new CompareAge());
        System.out.println("Sorted persons by age: " + persons);

        Collections.sort(persons, new CompareName());
        System.out.println("Sorted persons by name: " + persons);

    }
}

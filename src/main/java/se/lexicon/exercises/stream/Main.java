package se.lexicon.exercises.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );

        // 1. Filter all active people
        List<Person> activePeople = people.stream()
                .filter(p -> p.isActive())
                .collect(Collectors.toList());

        System.out.println("Active people:");
        for (Person p : activePeople) {
            System.out.println(p);
        }

        // 2. Map all names
        List<String> names = people.stream()
                .map(p -> p.getName())
                .collect(Collectors.toList());

        System.out.println("\nNames:");
        for (String name : names) {
            System.out.println(name);
        }

        // 3. Count adults
        long adultCount = people.stream()
                .filter(p -> p.getAge() >= 18)
                .count();

        System.out.println("\nNumber of adults: " + adultCount);

        // 4. Sort by age
        List<Person> sortedByAge = people.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .collect(Collectors.toList());

        System.out.println("\nSorted by age:");
        for (Person p : sortedByAge) {
            System.out.println(p);
        }

        // 5. Find first active person in Stockholm
        Optional<Person> firstActiveInStockholm = people.stream()
                .filter(p -> p.isActive())
                .filter(p -> p.getCity().equals("Stockholm"))
                .findFirst();

        System.out.println("\nFirst active person in Stockholm:");
        if (firstActiveInStockholm.isPresent()) {
            System.out.println(firstActiveInStockholm.get());
        } else {
            System.out.println("None found");
        }
    }
}

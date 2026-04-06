package se.lexicon.exercises.functional;

import java.util.ArrayList;
import java.util.List;

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

        // --- Rules ---
        PersonRule isActive = p -> p.isActive();
        PersonRule isAdult = p -> p.getAge() >= 18;
        PersonRule livesInStockholm = p -> p.getCity().equals("Stockholm");

        // Combined rule
        PersonRule activeAdultInStockholm =
                p -> isActive.test(p) && isAdult.test(p) && livesInStockholm.test(p);

        // --- filterPeople method demonstration ---
        List<Person> filtered = filterPeople(people, activeAdultInStockholm);

        System.out.println("Filtered (active + adult + Stockholm):");
        for (Person p : filtered) {
            System.out.println(p);
        }

        // --- PersonAction demonstration ---
        PersonAction printName = p -> System.out.println("Name: " + p.getName());
        PersonAction sendEmail = p -> System.out.println("Send email to " + p.getName());

        // --- PersonProcessor demonstration ---
        PersonProcessor processor = new PersonProcessor();

        List<Person> adults = processor.findPeople(people, isAdult);

        System.out.println("\nAdults:");
        for (Person p : adults) {
            printName.apply(p);
        }

        System.out.println("\nSend email to active people:");
        processor.applyToMatching(people, isActive, sendEmail);
    }

    // --- filterPeople method ---
    public static List<Person> filterPeople(List<Person> list, PersonRule rule) {
        List<Person> result = new ArrayList<>();
        for (Person p : list) {
            if (rule.test(p)) {
                result.add(p);
            }
        }
        return result;
    }
}

package se.lexicon.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamAPI {

    void main() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter((number) -> number % 2 == 0)
                .toList();
        System.out.println(evenNumbers);


        List<Employee> employees = Arrays.asList(
                new Employee("Anna", "Engineering", 30, 60000),
                new Employee("Erik", "Engineering", 35, 70000),
                new Employee("Karin", "HR", 28, 50000),
                new Employee("Lars", "HR", 40, 45000),
                new Employee("Sofia", "Finance", 32, 65000),
                new Employee("Gustav", "Finance", 25, 55000),
                new Employee("Ingrid", "Engineering", 45, 80000),
                new Employee("Oskar", "Engineering", 29, 62000),
                new Employee("Maja", "HR", 33, 52000),
                new Employee("Nils", "Finance", 38, 68000),
                new Employee("Astrid", "Engineering", 27, 58000),
                new Employee("Sven", "HR", 42, 47000),
                new Employee("Elin", "Finance", 31, 64000),
                new Employee("Johan", "Engineering", 36, 72000),
                new Employee("Linnea", "HR", 26, 48000)
        );



                System.out.println("\n---Employees in Engineering department earning more than 60k---");
                List<Employee> filtredlist = employees.stream()
                                .filter((employee->  employees.getDepartment().equals("Engineering")))
                                        .filter((employee-> employees.getSalary())60000)
                                                toList();


    }

}

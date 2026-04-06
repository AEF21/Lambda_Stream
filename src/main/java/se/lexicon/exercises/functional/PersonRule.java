package se.lexicon.exercises.functional;




@FunctionalInterface
interface PersonRule { // using interface name Predicate and value boolean for testing some possible values
    boolean test(Person person);


}

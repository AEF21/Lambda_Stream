package se.lexicon.exercises.functional;

import java.util.ArrayList;
import java.util.List;

public class PersonProcessor {


        public List<Person> findPeople(List<Person> list, PersonRule rule) {
            List<Person> result = new ArrayList<>();
            for (Person p : list) {
                if (rule.test(p)) result.add(p);
            }
            return result;
        }

        public void applyToMatching(List<Person> list, PersonRule rule, PersonAction action) {
            for (Person p : list) {
                if (rule.test(p)) action.apply(p);
            }
        }
    }



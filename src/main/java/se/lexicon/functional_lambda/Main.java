package se.lexicon.functional_lambda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void main() {

        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Fix a bugs !", 2, false));
        todos.add(new Todo("Write tests", 1, false));
        todos.add(new Todo("Deploy app", 3, false));
        todos.add(new Todo("Refactor code", 1, true));
        todos.add(new Todo("Update documentation", 1, false));
        todos.add(new Todo("Investigate production issue", 5, false));
        todos.add(new Todo("Code review PR #42", 2, true));
        todos.add(new Todo("Optimize database query", 4, false));
        todos.add(new Todo("Plan next sprint", 3, true));
        todos.add(new Todo("Clean up warnings", 2, false));
        todos.add(new Todo("Improve UI layout", 3, false));
        todos.add(new Todo("Release hot fix", 5, false));

        System.out.println("\n-- All tasks (initial list) --\n");


        todos.forEach(todo -> System.out.println("todo = " + todo));
        // Defining filters using Lambdas : boolean matches(Todo todo);

        TaskFilter highPriority = todo -> todo.getPriority() >= 4;

        // Expanded syntax version
       /* TaskFilter highPriority1 = (Todo todo) -> {
            if (todo.getPriority() >= 4) {
                return true;
            } else {
                return false;
            }
        };*/


        // --- Filters ---

        TaskFilter mediumPriority = todo -> todo.getPriority() == 3;
        TaskFilter lowPriority = todo -> todo.getPriority() <= 2;
        TaskFilter completed = Todo::isCompleted;
        TaskFilter notCompleted = completed.negate();

        System.out.println("\n--- High priority tasks ---");
        System.out.println(findTasks(todos, highPriority));

        System.out.println("\n--- Medium priority tasks ---");
        System.out.println(findTasks(todos, mediumPriority));

        System.out.println("\n--- Low priority tasks ---");
        System.out.println(findTasks(todos, lowPriority));

        System.out.println("\n--- Not completed tasks ---");
        System.out.println(findTasks(todos, notCompleted));

        // --- Actions ---
        TaskAction markCompleted = task -> task.setCompleted(true);
        TaskAction increasePriority = task -> task.setPriority(task.getPriority() + 1);
        TaskAction printTask = task -> System.out.println("Updated: " + task);

        // Example: apply action to matching tasks
        List<Todo> updatedHighPriorityTasks = applyToMatchingTasks(todos, highPriority, markCompleted);
        updatedHighPriorityTasks.forEach(task -> printTask.run(task));
    }

    public static List<Todo> findTasks(List<Todo> todos, TaskFilter filter) {
        List<Todo> result = new ArrayList<>();
        for (Todo task : todos) {
            if (filter.matches(task)) {
                result.add(task);
            }
        }
        return result;
    }

    public static List<Todo> applyToMatchingTasks(List<Todo> todos, TaskFilter filter, TaskAction action) {
        List<Todo> updated = new ArrayList<>();
        for (Todo task : todos) {
            if (filter.matches(task)) {
                action.run(task);
                updated.add(task);
            }
        }
        return updated;
    }
}

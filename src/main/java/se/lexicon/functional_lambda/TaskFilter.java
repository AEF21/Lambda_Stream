package se.lexicon.Lambda_Functional;


public interface TaskFilter {

    boolean matches(Todo todo);
    default TaskFilter negate(){
        return todo -> !matches(todo);
    }
}

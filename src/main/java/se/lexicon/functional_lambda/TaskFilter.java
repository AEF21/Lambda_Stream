package se.lexicon.functional_lambda;


public interface TaskFilter {

    boolean matches(Todo todo);
    default TaskFilter negate(){
        return todo -> !matches(todo);
    }
}

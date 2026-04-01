package se.lexicon.Lambda_Functional;

public interface TaskAction {

    @FunctionalInterface
    interface Action {
        void run(Todo task);
    }
}

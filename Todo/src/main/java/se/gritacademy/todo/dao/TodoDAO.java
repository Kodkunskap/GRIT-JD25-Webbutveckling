package se.gritacademy.todo.dao;

import se.gritacademy.todo.model.Todo;

public class TodoDAO extends GenericDAO<Todo, Integer> {

    public TodoDAO() {
        super(Todo.class);
    }

}

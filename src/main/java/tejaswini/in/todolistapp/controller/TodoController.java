package tejaswini.in.todolistapp.controller;

import tejaswini.in.todolistapp.model.Status;
import tejaswini.in.todolistapp.model.Todo;
import tejaswini.in.todolistapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String listTodos(@RequestParam(required = false) Status status, Model model){
        List<Todo> todos;
        if (status == null) {
            todos = todoService.getAllTodos();
        } else {
            todos = todoService.getTodosByStatus(status);
        }

        model.addAttribute("todos", todos);
        model.addAttribute("status", status);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        Todo todo = new Todo();
        todo.setCreatedAt(LocalDateTime.now()); // Set timestamp before showing form
        model.addAttribute("todo", todo);
        return "create";
    }

    @PostMapping
    public String createTodo(@ModelAttribute Todo todo){
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
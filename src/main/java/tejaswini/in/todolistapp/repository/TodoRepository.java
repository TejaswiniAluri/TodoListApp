package tejaswini.in.todolistapp.repository;

import tejaswini.in.todolistapp.model.Status;
import tejaswini.in.todolistapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByStatus(Status status);
}
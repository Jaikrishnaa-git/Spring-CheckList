package todo.todoList.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import todo.todoList.Models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}

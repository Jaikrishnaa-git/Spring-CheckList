package todo.todoList.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo.todoList.Models.Task;
import todo.todoList.Repository.TaskRepository;
import java.util.List;

@Service
public class TaskService
{
    @Autowired
    TaskRepository repo;

    public void addTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        repo.save(task);
    }
    public void deleteTask(int id)
    {
        repo.deleteById(id);
    }

    public List<Task> getAllTasks()
    {
        return repo.findAll();
    }

    public void toggleTask(int id)
    {
        Task task = repo.findById(id).orElse(null);
        task.setCompleted(!task.isCompleted());
        repo.save(task);
    }
}

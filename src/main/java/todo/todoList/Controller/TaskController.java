package todo.todoList.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import todo.todoList.Models.Task;
import todo.todoList.Service.TaskService;
import java.util.List;

@Controller
public class TaskController
{
    @Autowired
    TaskService taskService;

    @GetMapping
    public String getTasks(Model model)
    {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping("/")
    public String addTask(@RequestParam String title)
    {
        taskService.addTask(title);
        return "redirect:/";
    }
    @GetMapping("{id}/delete")
    public String deleteTask(@PathVariable int id)
    {
        taskService.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("{id}/toggle")
    public String toggleTask(@PathVariable int id)
    {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}

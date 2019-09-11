package com.mytaskmanager.mtm.web;

import com.mytaskmanager.mtm.domain.Task;
import com.mytaskmanager.mtm.services.MapValidationErrorService;
import com.mytaskmanager.mtm.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewTask(@Valid @RequestBody Task task, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationErrorService(result);
        if (errorMap != null) return errorMap;

        Task task1 = taskService.saveOrUpdateTask(task);
        return new ResponseEntity<Task>(task1, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<?> getTaskById(@PathVariable String taskId) {

        Task task = taskService.findTaskByIdentifier(taskId);
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Task> getAllTasks() {
        return taskService.findAllTasks();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable String taskId) {
        taskService.deleteTaskByIdentifier(taskId.toUpperCase());

        return new ResponseEntity<String>("Task with Id " + taskId + " was deleted.", HttpStatus.OK);
    }

}

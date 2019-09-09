package com.mytaskmanager.mtm.services;

import com.mytaskmanager.mtm.domain.Task;
import com.mytaskmanager.mtm.exceptions.TaskIdException;
import com.mytaskmanager.mtm.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveOrUpdateTask (Task task) {
        try {
            task.setTaskIdentifier(task.getTaskIdentifier().toUpperCase());
            return taskRepository.save(task);

        } catch (Exception e) {
            throw new TaskIdException("Task Id " + task.getTaskIdentifier().toUpperCase() + " already exists" );
        }
    }
}

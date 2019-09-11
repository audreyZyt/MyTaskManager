package com.mytaskmanager.mtm.repositories;

import com.mytaskmanager.mtm.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByTaskIdentifier (String taskId);

    @Override
    Iterable<Task> findAll();
}

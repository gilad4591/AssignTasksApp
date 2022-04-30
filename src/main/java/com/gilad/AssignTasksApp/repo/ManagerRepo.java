package com.gilad.AssignTasksApp.repo;

import com.gilad.AssignTasksApp.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepo extends JpaRepository<Manager,Long> {

    Optional<Manager> findManagerByEmployeeId(Long id);
}

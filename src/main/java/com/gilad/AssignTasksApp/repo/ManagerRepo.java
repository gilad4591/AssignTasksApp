package com.gilad.AssignTasksApp.repo;

import com.gilad.AssignTasksApp.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface ManagerRepo extends JpaRepository<Manager,Long> {

    Optional<Manager> findManagerByEmployeeId(Long id);
}

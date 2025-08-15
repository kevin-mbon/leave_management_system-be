package leavemanagementsystem.repository;

import leavemanagementsystem.model.Role;
import leavemanagementsystem.model.User;
import leavemanagementsystem.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByStatus(UserStatus status);
    List<User> findByStatusAndDepartmentId(UserStatus status, Long departmentId);

    List<User> findByDepartmentId(Long departmentId);
    List<User> findByRoleIn(List<Role> roles);
} 
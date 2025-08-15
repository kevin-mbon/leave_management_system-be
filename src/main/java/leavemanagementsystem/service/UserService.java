package leavemanagementsystem.service;

import leavemanagementsystem.dto.UserApprovalRequest;
import leavemanagementsystem.model.Role;
import leavemanagementsystem.model.User;
import leavemanagementsystem.model.UserStatus;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    List<User> getAllUsers();
    List<User> getUsersByStatus(UserStatus status);
    List<User> getUsersByDepartment(Long departmentId);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User approveUser(Long userId, String department, Role role);
    User rejectUser(Long id);
    User getUserByEmail(String email);
} 
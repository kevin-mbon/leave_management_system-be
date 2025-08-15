package leavemanagementsystem.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import leavemanagementsystem.model.Department;
import leavemanagementsystem.model.Role;
import leavemanagementsystem.model.User;
import leavemanagementsystem.model.UserStatus;
import leavemanagementsystem.repository.UserRepository;
import leavemanagementsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    @Value("${admin.email}")
    private String adminEmail;
    
    @Value("${admin.password}")
    private String adminPassword;

    private final DepartmentService departmentService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Ensure Administration department exists
        departmentService.ensureAdministrationDepartmentExists();
        
        // Create default admin user if not exists
        createDefaultAdminUser();

    }
    
    private void createDefaultAdminUser() {
        if (!userRepository.existsByEmail(adminEmail)) {
            Department adminDepartment = departmentService.getDepartmentByName("Administration");
            
            User adminUser = User.builder()
                    .firstName("Admin")
                    .lastName("User")
                    .email(adminEmail)
                    .password(passwordEncoder.encode(adminPassword))
                    .role(Role.ADMIN)
                    .status(UserStatus.APPROVED)
                    .department(adminDepartment)
                    .build();
            
            userRepository.save(adminUser);
            log.info("Default admin user created");
        }
    }
    
}
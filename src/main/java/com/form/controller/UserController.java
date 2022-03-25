package com.form.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.form.model.User;
import com.form.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List < User > getUsers() {
        return this.userRepository.findAll();
    }
    
    @PostMapping("/add")
    User newUser(@RequestBody User newUser) {
      return this.userRepository.save(newUser);
    }
    
//    @PutMapping("/employees/{id}")
//    public ResponseEntity< User> updateEmployee(@PathVariable(value = "id") Long employeeId,
//      @Valid @RequestBody  User  userDetails) throws ResourceNotFoundException {
//         User employee = userRepository.findById(employeeId)
//         .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//         employee.setEmailId(employeeDetails.getEmailId());
//         employee.setLastName(employeeDetails.getLastName());
//         employee.setFirstName(employeeDetails.getFirstName());
//         final User updatedEmployee = userRepository.save(employee);
//         return ResponseEntity.ok(updatedEmployee);
//    }
    
        
    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
      this.userRepository.deleteById(id);
    }
}
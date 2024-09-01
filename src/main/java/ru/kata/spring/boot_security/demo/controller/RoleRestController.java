//package ru.kata.spring.boot_security.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import ru.kata.spring.boot_security.demo.entity.Role;
//import ru.kata.spring.boot_security.demo.service.RoleService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/roles")
//public class RoleRestController {
//
//    @Autowired
//    private RoleService roleService;
//
//    @GetMapping
//    public ResponseEntity<List<Role>> getAllRoles() {
//        List<Role> roles = roleService.findAll();
//        return ResponseEntity.ok(roles);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
//        Role role = roleService.findById(id);
//        return ResponseEntity.ok(role);
//    }
//
//    @PostMapping
//    public ResponseEntity<Role> createRole(@RequestBody Role role) {
//        Role createdRole = roleService.save(role);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
//        roleService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}

package com.attendance.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be 100 characters or less")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Roll number is required")
    @Size(max = 30, message = "Roll number must be 30 characters or less")
    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNumber;

    @Size(max = 100, message = "Department must be 100 characters or less")
    @Column(name = "department")
    private String department;

    @Email(message = "Email is not valid")
    @Size(max = 100, message = "Email must be 100 characters or less")
    @Column(name = "email")
    private String email;

    @Size(max = 20, message = "Phone must be 20 characters or less")
    @Column(name = "phone")
    private String phone;

    public Student() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}

package com.example.components;

import javafx.scene.image.ImageView;

public class Staff {
    private ImageView image;
    private String name;
    private String designation;
    private String department;
    private String email;
    private String subject;

    public Staff(ImageView image, String name, String designation, String department, String email, String subject) {
        this.image = image;
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.subject=subject;
        this.email = email;
    }

    // Getters
    public ImageView getImage() { return image; }
    public String getName() { return name; }
    public String getDesignation() { return designation; }
    public String getDepartment() { return department; }
    public String getEmail() { return email; }
    public String getSubject() { return subject; }
}

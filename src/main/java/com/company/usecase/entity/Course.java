package com.company.usecase.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Student> students;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    private List<Book> books;
}

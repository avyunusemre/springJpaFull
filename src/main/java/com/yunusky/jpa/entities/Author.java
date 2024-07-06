package com.yunusky.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@NamedQueries({
        @NamedQuery(
                name = "Author.findByNamedQuery",
                query = "select a from Author a where a.age >= :age"
        ),
        @NamedQuery(
                name = "Author.updateByNamedQuery",
                query = "update Author a set a.age = :age"
        )
    }
)

public class Author extends BaseEntity {

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private int age;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private List<Course> courses;

}

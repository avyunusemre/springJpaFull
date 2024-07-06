package com.yunusky.jpa.repositories;

import com.yunusky.jpa.entities.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer>, JpaSpecificationExecutor<Author> {

    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);


    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);

    @Transactional
    @Modifying
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    List<Author> findByFirstName(String firstName);

    // select * from author where first_name like '%yunus%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // select * from author where first_name like 'yunus%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    // select * from author where first_name like '%yunus'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

}

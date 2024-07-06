package com.yunusky.jpa.specification;

import com.yunusky.jpa.entities.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            if (age < 0) {
                return null;
            }
            return criteriaBuilder.equal(root.get("age"), age);
        };
    }

    public static Specification<Author> firstNameLike(String firstName) {
        return (Root<Author> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            if (firstName == null) {
                return null;
            }
            return criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%");
        };
    }
}

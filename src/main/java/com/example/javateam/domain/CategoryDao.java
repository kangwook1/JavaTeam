package com.example.javateam.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(
        name = "category"
)
public class CategoryDao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long categoryId;
    @Column(
            length = 50
    )
    private String categoryName;


    public Long getCategoryId() {
        return this.categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryId(final Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryDao(final Long categoryId, final String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public CategoryDao() {
    }
}

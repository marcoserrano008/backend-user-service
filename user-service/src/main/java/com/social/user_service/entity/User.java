package com.social.user_service.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = Constants.UserTable.TABLE_NAME)
@SQLRestriction(Constants.SQL_RESTRICTION)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.UserTable.Id.NAME)
    private Long id;

    @Column(name = Constants.UserTable.AccountId.NAME)
    private Long accountId;

    @Column(name = Constants.UserTable.Username.NAME, length = Constants.UserTable.Username.LENGTH,
            unique = true, nullable = false)
    private String username;

    @Column(name = Constants.UserTable.FirstName.NAME, length = Constants.UserTable.FirstName.LENGTH)
    private String firstName;

    @Column(name = Constants.UserTable.LastName.NAME, length = Constants.UserTable.LastName.LENGTH)
    private String lastName;

    @Column(name = Constants.UserTable.Password.NAME, length = Constants.UserTable.Password.LENGTH)
    private String password;

    @Column(name = Constants.UserTable.CreatedDate.NAME)
    private LocalDateTime createdDate;

    @Column(name = Constants.UserTable.IsDeleted.NAME)
    private Boolean isDeleted;

    @PrePersist
    private void onCreate() {
        if (isDeleted == null) {
            isDeleted = Boolean.FALSE;
        }

        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
    }
}

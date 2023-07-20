package com.flat.management.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name="login_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDao implements Serializable {
    @Id
    private String docId;
    private String apartmentId;

    private String userId;
    private String userName;

    private String mobileNumber;

    private ZonedDateTime createdAt;
    private String password;
}

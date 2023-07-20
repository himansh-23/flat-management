package com.flat.management.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@ToString
@Entity
@Table(name="tenant")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TenantDao {
    @Id
    private String tenantId;
    private String tenantName;
    private String flatId;
    private int rent;
    private int deposit;
    private ZonedDateTime entryDate;
    private ZonedDateTime exitDate;
    private ZonedDateTime createdAt;
    private boolean isActive;
}

package com.flat.management.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.flat.management.configuration.JacksonConfiguration;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@ToString
public class TenantDTO {
    private String tenantId;
    private String tenantName;
    private String flatId;
    private int rent;
    private int deposit;
    @JsonDeserialize(using = JacksonConfiguration.ZonedDateTimeDeserializer.class)
    @JsonSerialize(using = JacksonConfiguration.ZonedDateTimeSerializer.class)
    private ZonedDateTime entryDate;
    private ZonedDateTime exitDate;
    private String createdAt;
    private boolean isActive;

}

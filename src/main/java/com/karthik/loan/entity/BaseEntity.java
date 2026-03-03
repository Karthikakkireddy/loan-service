package com.karthik.loan.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalTime;

@MappedSuperclass
@Data
public class BaseEntity
{

    private LocalTime createdAt;

    private String createdBy;

    private LocalTime updatedAt;

    private String updatedBy;

}

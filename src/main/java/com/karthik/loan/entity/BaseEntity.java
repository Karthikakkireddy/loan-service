package com.karthik.loan.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity
{

    @CreatedDate
    private LocalTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

}

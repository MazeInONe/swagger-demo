package com.example.swagger.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Malu
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_on", length = 6)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdOn;

    @Column(name = "updated_on", length = 6)
    @DateTimeFormat(pattern = "YYYY-MM-DD HH:mm:SS")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedOn;

    @Column(name = "del_status")
    private boolean delStatus;
}

package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "classrooms")

public class Classroom {

    @Id
    @NotEmpty
    private String code;

    @NotEmpty
    private Integer capacity;

    public Classroom(String code, int capacity) {
        this.code = code;
        this.capacity = capacity;
    }

}

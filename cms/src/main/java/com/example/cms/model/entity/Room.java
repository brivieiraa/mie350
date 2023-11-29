package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rooms")

public class Room {

    @Id
    @NotEmpty
    private String roomCode;

    @NotEmpty
    private String building;

    @Nullable
    private String roomType;

//    @Nullable
//    private List<Room> techAvailable = new ArrayList<>();

    @NotEmpty
    private Integer capacity;

    public Room(String code, int capacity) {
        this.roomCode = code;
        this.capacity = capacity;
    }

}

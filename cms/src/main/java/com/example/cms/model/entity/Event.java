package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "events")

public class Event {

    @Id
    @NotNull
    private Integer eventCode;

    @NotEmpty
    private String eventName;

    @ManyToOne
    @JoinColumn(name = "studentGroup")
    private StudentGroup studentGroup;

    @ManyToOne
    @JoinColumn(name = "roomCode")
    private Room room;

    @NotEmpty
    private String date;

    @NotNull
    private double duration;

    @Nullable
    private String description;

    @Nullable
    private String eventType;

    @Nullable
    private int eventCapacity;

    @OneToMany(mappedBy = "event")
    @Nullable
    private List<RSVP> rsvps = new ArrayList<RSVP>();
}

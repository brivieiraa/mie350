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
public class RSVP {

    @EmbeddedId
    RSVPKey rsvpKey;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    private Student student;

    @ManyToOne
    @MapsId("eventCode")
    @JoinColumn(name = "eventCode")
    private Event event;

}

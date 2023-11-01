package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

import com.example.cms.model.entity.RSVPKey;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "rsvps")
public class RSVP {

    @EmbeddedId
    RSVPKey rsvpKey;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "studentId")
    @JsonIgnoreProperties({"rsvps"})
    private Student student;

    @ManyToOne
    @MapsId("eventCode")
    @JoinColumn(name = "eventCode")
    @JsonIgnoreProperties({"rsvps"})
    private Event event;

}

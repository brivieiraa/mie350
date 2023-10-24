package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class RSVPKey implements Serializable
{
    @Column(name = "studentId")
    Long studentId;

    @Column(name = "eventCode")
    String eventCode;

    @Override
    public int hashCode()
    {
        String concatString = String.valueOf(studentId.hashCode()) + String.valueOf(eventCode.hashCode());
        return concatString.hashCode()
    }
    public RSVPKey(){}

    public RSVPKey(Long studentId, String eventCode)
    {
        this.setStudentId(studentId);
        this.setEventCode(eventCode);
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) {return false;}
        if (!(o instanceof RSVPKey)) {return false;}
        RSVPKey other = (RSVPKey) o;
        return studentId.equals(other.studentId) && eventCode.equals(other.eventCode);
    }
}

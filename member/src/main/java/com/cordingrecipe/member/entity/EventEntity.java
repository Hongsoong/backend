package com.cordingrecipe.member.entity;

import com.cordingrecipe.member.dto.EventDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "event_table")
public class EventEntity {

    @Id
    @GeneratedValue
    private Long eventNum;

    @Column
    private String eventContents;

    public static EventEntity toEventEntity(EventDTO eventDTO){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventContents(eventDTO.getEventContents());
        return eventEntity;
    }
    public static EventEntity toUpdateEntity(EventDTO eventDTO){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventNum(eventDTO.getEventNum());
        eventEntity.setEventContents(eventDTO.getEventContents());
        return eventEntity;
    }

}

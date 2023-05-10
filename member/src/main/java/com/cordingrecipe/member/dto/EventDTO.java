package com.cordingrecipe.member.dto;

import com.cordingrecipe.member.entity.EventEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDTO {
    private Long eventNum;
    private String eventContents;

    public static EventDTO toEventDTO(EventEntity eventEntity){
        EventDTO eventDTO = new EventDTO();
        eventDTO.setEventNum(eventEntity.getEventNum());
        eventDTO.setEventContents(eventEntity.getEventContents());
        return eventDTO;
    }


}

package com.cordingrecipe.member.service;


import com.cordingrecipe.member.dto.EventDTO;
import com.cordingrecipe.member.entity.EventEntity;
import com.cordingrecipe.member.repository.EventRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void save(EventDTO eventDTO){
        EventEntity eventEntity = EventEntity.toEventEntity(eventDTO);
        eventRepository.save(eventEntity);
    }
    public List<EventDTO> findAll(){
        List<EventEntity> eventEntityList = eventRepository.findAll();
        List<EventDTO> eventDTOList = new ArrayList<>();
        for(EventEntity eventEntity: eventEntityList){
            eventDTOList.add(EventDTO.toEventDTO(eventEntity));
        }
        return eventDTOList;
    }
    public EventDTO findByEventNum(Long eventNum){
        Optional<EventEntity> optionalEventEntity = eventRepository.findByEventNum(eventNum);
        if(optionalEventEntity.isPresent()){
            return  EventDTO.toEventDTO(optionalEventEntity.get());
        }
        else {
            return null;
        }
    }
    public EventDTO update(EventDTO eventDTO){
        EventEntity eventEntity = EventEntity.toUpdateEntity(eventDTO);
        eventRepository.save(eventEntity);
        return findByEventNum(eventDTO.getEventNum());
    }
    public void delete(Long eventNum) {
        eventRepository.deleteById(eventNum);
    }
}

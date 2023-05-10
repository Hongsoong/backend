package com.cordingrecipe.member.Controller;

import com.cordingrecipe.member.dto.EventDTO;
import com.cordingrecipe.member.service.EventService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/event/save")
    public String saveForm(){ return "eventsave";}
    @PostMapping("/event/save")
    public String save(@ModelAttribute EventDTO eventDTO){
        System.out.println("EventController.save");
        System.out.println("eventDTO=" +eventDTO);
        eventService.save(eventDTO);
        return "eventcomplete";
    }
    @GetMapping("/event/")
    public String findAll(Model model){
        List<EventDTO> eventDTOList = eventService.findAll();
        model.addAttribute("eventList",eventDTOList);
        return "eventlist";
    }
    @GetMapping("/event/user")
    public String findAllUser(Model model){
        List<EventDTO> eventDTOList = eventService.findAll();
        model.addAttribute("eventList",eventDTOList);
        return "eventlistuser";
    }
    //이벤트정보 일반 유저용
    @GetMapping("/event/{eventNum}")
    public String findById(@PathVariable Long eventNum, Model model){
        EventDTO eventDTO = eventService.findByEventNum(eventNum);
        model.addAttribute("event", eventDTO);
        return "eventdetail";
    }
    @GetMapping("/event/update/{eventNum}")
    public String updateForm(@PathVariable Long eventNum, Model model) {
        EventDTO eventDTO = eventService.findByEventNum(eventNum);
        model.addAttribute("eventUpdate", eventDTO);
        return "eventupdate";
    }
    @PostMapping("/event/update")
    public String update(@ModelAttribute EventDTO eventDTO, Model model) {
        EventDTO event = eventService.update(eventDTO);
        model.addAttribute("event", event);
        return "eventdetail";
    }
    @GetMapping("/event/delete/{eventNum}")
    public String delete(@PathVariable Long eventNum) {
        eventService.delete(eventNum);
        return "redirect:/event/";
    }


}

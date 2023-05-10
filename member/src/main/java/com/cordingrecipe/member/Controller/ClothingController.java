package com.cordingrecipe.member.Controller;

import com.cordingrecipe.member.dto.ClothingDTO;
import com.cordingrecipe.member.service.ClothingService;
//import jakarta.servlet.http.HttpSession;
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
public class ClothingController {
    private final ClothingService clothingService;

    @GetMapping("/clothing/save")
    public String saveForm(){
        return "clothingsave";
    }
    @PostMapping("/clothing/save")
    public String save(@ModelAttribute ClothingDTO clothingDTO){
        System.out.println("ClothingController.save");
        System.out.println("clothingDTO ="+clothingDTO);
        clothingService.save(clothingDTO);
        return"clothingcomplete";
    }
    @GetMapping("/clothing/")
    public String findAll(Model model){
        List<ClothingDTO> clothingDTOList = clothingService.findAll();
        model.addAttribute("clothingList",clothingDTOList);
        return "clothinglist";
    }
    @GetMapping("/clothing/user")
    public String findAllUser(Model model){
        List<ClothingDTO> clothingDTOList = clothingService.findAll();
        model.addAttribute("clothingList",clothingDTOList);
        return "clothinglistuser";
    }
    @GetMapping("/clothing/{clothingId}")
    public String findById(@PathVariable Long clothingId,Model model){
        ClothingDTO clothingDTO = clothingService.findByClothingId(clothingId);
        model.addAttribute("clothing", clothingDTO);
        return "clothingdetail";
    }
    @GetMapping("/clothing/delete/{clothingId}")
    public String delete(@PathVariable Long clothingId) {
        clothingService.delete(clothingId);
        return "redirect:/clothing/";
    }
    @GetMapping("/clothing/update/{clothingId}")
    public String updateForm(@PathVariable Long clothingId, Model model){
        ClothingDTO clothingDTO = clothingService.findByClothingId(clothingId);
        model.addAttribute("clothingUpdate", clothingDTO);
        return "clothingupdate";
    }
    @PostMapping("/clothing/update")
    public String update(@ModelAttribute ClothingDTO clothingDTO,Model model) {
        ClothingDTO clothing = clothingService.update(clothingDTO);
        model.addAttribute("clothing", clothing);
        return "clothingdetail";
    }
}

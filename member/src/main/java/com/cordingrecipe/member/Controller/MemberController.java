package com.cordingrecipe.member.Controller;


import com.cordingrecipe.member.dto.MemberDTO;
import com.cordingrecipe.member.service.MemberService;
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
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO ="+ memberDTO);
        memberService.save(memberDTO);
        return "login";
    }


    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/member/login")
    public  String login(@ModelAttribute MemberDTO memberDTO,HttpSession session){
        MemberDTO loginResult=memberService.login(memberDTO);
        if(loginResult != null){
          //로그인 성공
            session.setAttribute("loginEmail",loginResult.getId());
            if(loginResult.getUserAuthority().equals("1")){
                return "admin";
            }
            else{
                return "customer";
            }
            //MemberDTO의 userAuthority 값이 0일 때 일반 사용자
            //MemberDTO의 userAuthority 값이 1일 때 관리자 계정
        } else {
            // login 실패
            return "login";
        }
    }
    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }

    @GetMapping("/member/")
    public String findAll(Model model){
        List<MemberDTO> memberDTOList = memberService.findAll();
        model.addAttribute("memberList",memberDTOList);
        return "list";
    }
    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id,Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member",memberDTO);
        return "detail";
    }

    @GetMapping("/member/admin")
    public String adminForm() {return "admin";}

    @GetMapping("/member/customer")
    public String customerForm() {return "customer";}

    @GetMapping("/member/delete/{id}")
    public String delete(@PathVariable Long id) {
        memberService.delete(id);
        return "redirect:/member/";
    }

    @GetMapping("/member/update/{id}")
    public String updateForm(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("memberUpdate", memberDTO);
        return "memberupdate";
    }
    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDTO memberDTO, Model model) {
        MemberDTO member = memberService.update(memberDTO);
        model.addAttribute("member",member);
        return "detail";
    }
}

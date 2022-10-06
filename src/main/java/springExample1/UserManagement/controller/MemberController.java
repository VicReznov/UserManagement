package springExample1.UserManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springExample1.UserManagement.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 스프링 컨테이너가 자동으로 연결해줌, DI
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}

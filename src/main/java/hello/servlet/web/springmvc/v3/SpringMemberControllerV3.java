package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/springmvc/v3/members/")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "new-form", method = RequestMethod.GET)
    @GetMapping("new-form")
    public String newForm() {
        return "new-form";
    }

//    @RequestMapping(value = "save", method = RequestMethod.POST)
    @PostMapping("save")
    public String save(@RequestParam Map<String,String> param
//                       ,@RequestParam String username
//                       ,@RequestParam int age
            , Model model) {
        String username = param.get("username");
        int age = Integer.parseInt(param.get("age"));
        Member member = new Member(username, age);
        memberRepository.save(member);
        model.addAttribute("member", member);
        return "save-result";
    }

//    @RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping("")
    public String members() {
        List<Member> members = memberRepository.findAll();
        return "members";
    }
}

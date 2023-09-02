package dh.example.webservice.web;

import dh.example.webservice.config.auth.LoginUser;
import dh.example.webservice.config.auth.dto.SessionUser;
import dh.example.webservice.service.posts.PostsService;
import dh.example.webservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        // 로그인 성공 시 세션에 저장 (어노테이션으로 처리)

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }


    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }


    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto posts = postsService.findById(id);
        model.addAttribute("post", posts);

        return "posts-update";
    }
}

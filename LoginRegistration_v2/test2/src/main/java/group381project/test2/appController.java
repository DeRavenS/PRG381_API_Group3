package group381project.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class appController {
    
    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @Autowired
    private studentRepository studentRepo;

}

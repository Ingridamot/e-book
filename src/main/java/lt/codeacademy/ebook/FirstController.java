package lt.codeacademy.ebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class FirstController {

    @GetMapping("hello")
    public String sayHelloToCustomer(){
        return "hello";
    }
}

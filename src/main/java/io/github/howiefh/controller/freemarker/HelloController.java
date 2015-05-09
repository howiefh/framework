package io.github.howiefh.controller.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model){
		model.addAttribute("username", "张三");
		return "hello";
	}
	
	@RequestMapping("/helloworld")
	public String helloworld(Model model){
		model.addAttribute("username", "李四");
		return "helloworld";
	}
}

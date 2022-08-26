package com.springboot.App.DataAccessLayer.routeController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginRouter {
    
    @GetMapping("/admin/login")
	public String adminLogIn(Model model) 
	{
		return "adminLogin.html";
	}


    



}

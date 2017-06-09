package jp.alh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.alh.dto.UserDto;
import jp.alh.form.UserForm;
import jp.alh.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
    	
    	UserForm userForm = new UserForm();
    	
    	model.addAttribute("userForm", userForm);
        model.addAttribute("message", "ログイン");
        return "login";
        
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(Model model, @ModelAttribute UserForm userForm, HttpSession session) {
    	
    	UserDto user = userService.getLoginUser(userForm);
    	
    	if(user == null){
    		session.setAttribute("errorMessages", "ログインに失敗しました");
    		return "redirect:/login";
    	}
    	
    	session.setAttribute("loginUser", user);
    	
        return "redirect:/home";
    }
}
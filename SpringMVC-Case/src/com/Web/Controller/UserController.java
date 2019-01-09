package com.Web.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.Entry.User;
import com.Service.UserService;
@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/list")
	public ModelAndView listAll() {
		System.out.println("begin...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("list");
		mv.addObject("User",service.list());
		return mv;
	}
	
	//跳转视图控制器
	@RequestMapping("/edit")
	public ModelAndView edit() {
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("edit");
		 return mv;
	}
	
	//运行控制器
		@RequestMapping("/su")
		public String save(@Valid User user,BindingResult result,Model model) {
			List<ObjectError> erroys = result.getAllErrors();
			//如果出现错误
			if(erroys.size() > 0) {
				model.addAttribute("erroys", erroys);
				return "/edit";
			}
			if(user.getId() == null) {
				service.save(user);
			}else {
				service.update(user);
			}
			return "redirect:/User/list";
		}
	
	//删除控制器
		@RequestMapping("/delete")
		public String delete(Long id) {
			System.out.println("执行删除成功");
			if(id != null) {
				service.delete(id);
			}
			return "redirect:/User/list";
			
		}

}

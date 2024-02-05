package com.devrezaur.main.maincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devrezaur.main.model.QuestionForm;
import com.devrezaur.main.model.Result;
import com.devrezaur.main.service.QuizService;

@Controller	
public class mainController {
   @Autowired
   Result result;
   @Autowired
   QuizService qService;
   Boolean submitted = false;
   
   @ModelAttribute("result")
   public Result getResult() {
	   return result;
   }
   
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@PostMapping("/questions")
	public String questions(@RequestParam String username,Model m,RedirectAttributes r) {
		if(username.equals("")) {
			r.addFlashAttribute("warning", "Please input your name!!");
			return "redirect:/";
		}
		submitted=false;
		result.setUsername(username);
		QuestionForm qForm = qService.getQuestion();
		m.addAttribute("qForm",qForm);
			
		return "quiz.html";
	}
	
	@PostMapping("/submit")
	public String submit(@ModelAttribute QuestionForm qForm,Model m) {
		if(!submitted) {
			submitted=true;
			result.setTotalCorrect(qService.totalScore(qForm));
			qService.saveResult(result);
		}
		
		return "result.html";
	}
	
	@GetMapping("/score")
	public String score(Model m) {
		List<Result> r= qService.getAllResult();
		m.addAttribute("list",r);
		return "scoreboard.html";
	}
	
	
}

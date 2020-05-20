package flore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FloreController {

	@GetMapping("/flore")
	public String flore(Model model) {
		model.addAttribute("page", "flore");

		return "/flore";
	}


}

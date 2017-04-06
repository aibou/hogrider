package io.aibou.study.spring.controller;

import io.aibou.study.spring.entity.GameStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by aibou on 2017/04/05.
 */
@Controller
@RequestMapping("/")
public class WebController {
	@RequestMapping(method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("name", "aibou");
		return "web/hello";
	}

	/**
	 * model.addAttribute("gs", gs) を記載せずにやってくれる。
	 * ちなみに、引数の @ModelAttribute("gs") がないと、無理やり new GameStatus() をしようとする
	 * @param gs
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String bye(@ModelAttribute("gs") GameStatus gs) {
		return "web/bye";
	}

	@ModelAttribute("gs")
	public GameStatus newGameStatus() {
		return new GameStatus("aibou", 100);
	}
}

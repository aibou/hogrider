package io.aibou.study.spring.controller;

import io.aibou.study.spring.entity.GameStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aibou on 2017/04/05.
 */
@RestController
@RequestMapping("/api")
public class ApiController {
	/**
	 * 単純な文字列返す
	 * curl localhost:8080/api/hogrider
	 * @return Hello, world
	 */
	@RequestMapping(path = "/hogrider", method = RequestMethod.GET)
	public String get() {
		return "Hello, world";
	}

	/**
	 * 任意のオブジェクトをJSON化して返す。オブジェクトのクラスでgetterが必須
	 * curl -XPOST localhost:8080/api/hogrider
	 * @return {"name":"aibou","score":100}
	 */
	@ResponseBody
	@RequestMapping(path = "/hogrider", method = RequestMethod.POST)
	public GameStatus post() {
		return new GameStatus("aibou", 100);
	}
}

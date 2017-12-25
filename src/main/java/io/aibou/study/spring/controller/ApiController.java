package io.aibou.study.spring.controller;

import io.aibou.study.spring.entity.GameStatus;
import io.aibou.study.spring.exception.BadRequestException;
import io.aibou.study.spring.exception.DatabaseException;
import io.aibou.study.spring.mapper.GameStatusMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * フィールド単位で @Autowired アノテーションを付けることは推奨されておらず、コンストラクタを使ってInjectionする方法が推奨されている。
 * 理由の一つにfinal修飾子を付与できることが上げられている。
 * そのため、Lombokで @RequiredArgsConstructor で代用（ついでにNonNullも付与）
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ApiController {
	@NonNull
	private final GameStatusMapper gameStatusMapper;

	/**
	 * 単純な文字列返す
	 * curl localhost:8080/api/hogrider
	 *
	 * @return Hello, world
	 */
	@RequestMapping(path = "/hogrider", method = RequestMethod.GET)
	public String get() {
		return "Hello, world";
	}

	/**
	 * 任意のオブジェクトをJSON化して返す。オブジェクトのクラスでgetterが必須
	 * curl -XPOST localhost:8080/api/hogrider
	 *
	 * @return {"name":"aibou","score":100}
	 */
	@ResponseBody
	@RequestMapping(path = "/hogrider", method = RequestMethod.POST)
	public GameStatus post() {
		return new GameStatus("aibou", 50);
	}


	@ResponseBody
	@RequestMapping(path = "/status", method = RequestMethod.GET)
	public GameStatus fetch() {
		return this.gameStatusMapper.findByScore(100);
	}

	@ResponseBody
	@RequestMapping(path = "/status", method = RequestMethod.POST)
	public List<GameStatus> select() {
		return this.gameStatusMapper.selectByScore(100);
	}

	@ResponseBody
	@RequestMapping(path = "/error", method = RequestMethod.GET)
	public List<GameStatus> requestError() throws BadRequestException {
		throw new BadRequestException();
	}

	@ResponseBody
	@RequestMapping(path = "/error", method = RequestMethod.POST)
	public List<GameStatus> databaseError() throws DatabaseException {
		throw new DatabaseException();
	}

}

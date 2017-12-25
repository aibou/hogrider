package io.aibou.study.spring.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by aibou on 2017/04/05.
 */
@RequiredArgsConstructor
@Getter
public class GameStatus {
	private final String name;
	private final int score;
}

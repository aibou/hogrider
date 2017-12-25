package io.aibou.study.spring.mapper;

import io.aibou.study.spring.entity.GameStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by aibou on 2017/04/11.
 */
@Mapper
public interface GameStatusMapper {
	@Select("SELECT name, score FROM game_status WHERE score = #{score} LIMIT 1")
	GameStatus findByScore(@Param("score") int score);

	@Select("SELECT name, score FROM game_status WHERE score = #{score}")
	List<GameStatus> selectByScore(@Param("score") int score);
}

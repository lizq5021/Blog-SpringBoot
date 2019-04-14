package com.songhaozhi.mayday.mapper.custom;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.Options;
import org.springframework.stereotype.Repository;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月14日
 * 
 */
@Repository
public interface OptionsMapperCustom {
	/**
	 * 保存
	 * 
	 * @param map
	 */
	void saveMap(@Param("map") Map<String, Object> map);

	/**
	 * 所有设置选项
	 * 
	 * @return map
	 */
	List<Options> selectMap();

}

package com.songhaozhi.mayday.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @author 宋浩志
* @createDate 创建时间：2019年1月9日 下午10:09:57
* 
*/
@Repository
public interface ThemeMapperCustom {

	void updateStatus(@Param(value="status")int status,@Param(value="id") int id);

}

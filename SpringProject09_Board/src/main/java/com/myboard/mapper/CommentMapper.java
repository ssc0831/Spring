package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.myboard.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	
	//�߰�
	@Insert("insert into commentboard(userid, content, regdate, bnum) "
			+ "values(#{userid}, #{content}, now(), #{bnum})")
	public void insert(CommentDTO comment);
	
	//��ü����
	@Select("select * from commentboard where bnum=#{bnum}")
	public List<CommentDTO> getList(int bnum);
	
	//����
	@Delete("delete from commentboard where cnum=#{cnum}")
	public void delete(int cnum);
	
	//��� ���� ���ϱ�
	@Select("select count(*) from commentboard where bnum=#{bnum}")
	public int getReplyCount(int bnum);
	
	// read
	@Select("select * from commentboard where cnum=#{cnum}")
	public CommentDTO read(int cnum);
}
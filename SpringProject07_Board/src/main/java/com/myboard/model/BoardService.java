package com.myboard.model;

import java.util.HashMap;
import java.util.List;

import com.myboard.dto.BoardDTO;
import com.myboard.dto.FileBoardDTO;

public interface BoardService {
	//추가
	public void insert(BoardDTO board);
	//전체보기
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//상세보기
	public BoardDTO findByNum(int num);
	//수정
	public void update(BoardDTO board);
	//삭제
	public void delete(int num);
	//개수
	public int getCount(HashMap<String, Object>hm);
	//파일업로드
	public void fileInsert(FileBoardDTO fboard);
	//파일리스트
	public List<FileBoardDTO> fileList();
}

package com.myboard.model;

import org.springframework.stereotype.Service;

import com.myboard.dto.MemberDTO;

public interface MemberService {
	//추가
	public void join(MemberDTO member);
	//아이디 중복확인
	public int idCheck(String id);
	//로그인 체크
	public MemberDTO loginCheck(String id);
	//수정	
	public void update(MemberDTO member);	
}

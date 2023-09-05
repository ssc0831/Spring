package com.myspring.app07;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myboard.dto.CommentDTO;
import com.myboard.dto.MemberDTO;
import com.myboard.model.CommentService;

@RequestMapping("/reply/*")
@RestController //@RestController = @Controller + @ResponseBody
public class CommentController {
	@Autowired
	private CommentService cService;
	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentDTO comment, HttpSession session) {
//		MemberDTO member = (MemberDTO) session.getAttribute("sMember");
//		comment.setUserid(member.getId());
		String id = ((MemberDTO)session.getAttribute("sMember")).getId();
		comment.setUserid(id);
		cService.insert(comment);
		return "success";
}
	//전체보기
	@GetMapping("/commentlist/{num}")
	public List<CommentDTO> getList(@PathVariable int num){
		int count = cService.getReplyCount(num);
		return cService.getList(num);
	}
	
	//삭제
	@DeleteMapping("delete/{cnum}")
	public int delete(@PathVariable int cnum) {
		cService.delete(cnum);
		return cnum;
	}

}

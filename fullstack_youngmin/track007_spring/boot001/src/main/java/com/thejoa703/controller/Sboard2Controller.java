package com.thejoa703.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.Sboard2Dto;
import com.thejoa703.service.Sboard2Service;
import com.thejoa703.util.UtilPaging;

@Controller
@RequestMapping("/board")   // 공통 prefix
public class Sboard2Controller {
	
	@Autowired
	private Sboard2Service service;
	
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="pageNo", defaultValue="1") int pageNo) {
		model.addAttribute("paging", new UtilPaging(service.selectTotalCnt(), pageNo));
		model.addAttribute("list", service.select10(pageNo));
		return "board/list";
	}
	
	@GetMapping("/search")
	@ResponseBody
	public  Map<String, Object> search(
			 @RequestParam(value="pageNo", defaultValue="1") int pageNo,
			 @RequestParam(value="keyword", defaultValue="false") String keyword){
		Map<String ,Object> result = new HashMap<>();
		int totalCnt =service.selectSearchTotalCnt(keyword);
		result.put("search", keyword); //검색키워드
		result.put("list", service.select3(keyword, pageNo)); //키워드 페이지3개
		result.put("paging",new UtilPaging(  totalCnt  , pageNo,3,10)); //페이징계산
		return result;                   //키워드검색갯수, 페이지번호, 몇개씩, 하단블록
	}
		
	
	@GetMapping("/write") public String write_get() {return "board/write";}
	
	@PostMapping("/write")public String write_post(
			MultipartFile file, Sboard2Dto dto, RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		if(service.insert(file,dto)>0) {result="글쓰기 성공!";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/list";
	}
	
	
	  //detail
	   @GetMapping("/detail")
	   public String detail(int id, Model model) {
	      model.addAttribute("dto",service.select(id));   //처리
	      return "board/detail";   //화면
	   }
	   
	   //edit   (폼)
	   @GetMapping("/edit")
	   public String edit_get(int id, Model model) {
	      model.addAttribute("dto",service.selectUpdateForm(id));
	      return "board/edit";   //화면
	   }
	   
	   //edit   (기능)
	   @PostMapping("/edit")
	   public String edit_post(Sboard2Dto dto, RedirectAttributes rttr, MultipartFile file) {
	      String result = "글수정 실패";
	      if(service.update(file, dto) > 0) {
	         result ="글수정 성공";
	      }
	      rttr.addFlashAttribute("success",result);
	      return "redirect:/board/detail?id="+dto.getId();   //화면
	   }
	   
	
	@GetMapping("/delete") 
	public String delete_get() {	
		return "board/delete";}
	
	@PostMapping("/delete")public String delete_post(
			Sboard2Dto dto, RedirectAttributes rttr) {
		String result = "글삭제 실패";
		if(service.delete(dto)>0) {result="글삭제 성공!";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/list";
	
	

	}
	
	//    /board/list
	//    /board/write (글쓰기 폼)
	//    /board/write (글쓰기 기능)
	//    /board/detail (상세보기)
	//    /board/edit   (수정폼)
	//    /board/edit   (수정기능)
	//    /board/delete (삭제폼)
	//    /board/delete (삭제기능)
	
}

package com.jiao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiao.domain.Student;
import com.jiao.service.ClassService;
import com.jiao.service.StuService;

@Controller
@RequestMapping("/student")
public class StuController {
	
	@Autowired
	private StuService stuService;
	@Autowired
	private ClassService classService;
	@GetMapping("/getAll")
	public String getAll (Model model) {
		 List<Student> allStudent = stuService.getAll();
		 model.addAttribute("allStudent", allStudent);
		return "index";
		
	}
	
	@GetMapping("/getByName")
	public String getStudentByName (Model model,Student stu) {
		List<Student> allStudent = stuService.getStudentByName(stu);
		 model.addAttribute("allStudent", allStudent);
		return "index";
		
	}
	@GetMapping("/modifyStudentShow/{id}")
	public String getAll (Model model,@PathVariable("id") Integer id) {
		 List<Student> allStudent = stuService.getStudentById(id);
		 List<Class> allClass = classService.getAll();
		 model.addAttribute("allStudent", allStudent);
		 model.addAttribute("allClasses", allClass);
		return "modifyList";
		
	}
	@PutMapping("/modifyStudent")
	@ResponseBody
	public Map<String, Object> modifyStudentById (Student stu) {
		Integer count = stuService.modifyById(stu);
		 Map<String,Object> msg = new HashMap<String,Object>();
		 if(count==1) {
			 msg.put("result", 1);
		 }
		return msg;
		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	@ResponseBody
	public Map<String, Object> deleteStudentById (@PathVariable("id") Integer id) {
		Integer count = stuService.deleteById(id);
		 Map<String,Object> msg = new HashMap<String,Object>();
		 if(count ==1) {
			 msg.put("result", count);
		 }
		return msg;
		
	}
	
	@GetMapping("/showBeforeAdd")
	public String getAllClass (Model model) {
		 List<Class> allClass = classService.getAll();
		 model.addAttribute("allClasses", allClass);
		
		return "add";
		
	}
	@PostMapping("/addStudent")
	public String addStudent(Student stu) {
		Integer count = stuService.addStudent(stu);
		if(count>0) {
			return "redirect:/student/getAll";
		}
		return "redirect:/student/showBeforeAdd";
		
	}
}

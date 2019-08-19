package com.ngoctuan.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ngoctuan.common.dto.ResponseModelDTO;
import com.ngoctuan.dao.model.Student;
import com.ngoctuan.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	public String findAll(Model model) {
		ResponseModelDTO<List<Student>> responseModelDTO = new ResponseModelDTO<>();
		if (studentService.findAllStudent() != null) {
			responseModelDTO.setCode(1);
			responseModelDTO.setMessage("Success");
			responseModelDTO.setData(studentService.findAllStudent());
			model.addAttribute("students", studentService.findAllStudent());
		} else {
			responseModelDTO.setCode(0);
			responseModelDTO.setMessage("Failure");
			responseModelDTO.setData(null);
		}
		return "index";
	}

//	@GetMapping(value = "/paging", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseModelDTO<Page<Student>> findAllStudentPage(Pageable pageable) {
//		ResponseModelDTO<Page<Student>> responseModelDTO = new ResponseModelDTO<>();
//		if (studentService.findAllStudentPage(pageable) != null) {
//			responseModelDTO.setCode(1);
//			responseModelDTO.setMessage("Success");
//			responseModelDTO.setData(studentService.findAllStudentPage(pageable));
//		} else {
//			responseModelDTO.setCode(0);
//			responseModelDTO.setMessage("Failure");
//			responseModelDTO.setData(null);
//		}
//		return responseModelDTO;
//	}

//	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public @ResponseBody ResponseModelDTO<Student> findById(@PathVariable("id") int id) {
//		ResponseModelDTO<Student> responseModelDTO = new ResponseModelDTO<>();
//		if (studentService.findById(id) != null) {
//			responseModelDTO.setCode(1);
//			responseModelDTO.setMessage("Success");
//			responseModelDTO.setData(studentService.findById(id));
//		} else {
//			responseModelDTO.setCode(0);
//			responseModelDTO.setMessage("Failure");
//			responseModelDTO.setData(studentService.findById(id));
//		}
//		return responseModelDTO;
//	}

	@GetMapping("addStudent")
	public String showSignUpForm(Student student) {
		return "addStudent";
	}

	@PostMapping(value = "")
	public String createStudent(@Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "addStudent";
		}
		studentService.createStudent(student);
		return "redirect:";
	}

//	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = {
//			MediaType.APPLICATION_JSON_UTF8_VALUE })
//	public ResponseModelDTO<Boolean> updateStudent(@RequestBody Student student) {
//		ResponseModelDTO<Boolean> responseModelDTO = new ResponseModelDTO<>();
//		if (studentService.updateStudent(student)) {
//			responseModelDTO.setCode(1);
//			responseModelDTO.setMessage("Success");
//			responseModelDTO.setData(true);
//		} else {
//			responseModelDTO.setCode(0);
//			responseModelDTO.setMessage("Failure");
//			responseModelDTO.setData(false);
//		}
//		return responseModelDTO;
//	}

	@GetMapping(value = "edit/{id}")
	public String showEditForm(@PathVariable("id") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "updateStudent";
	}

	@PostMapping(value = "{id}")
	public String updateStudent(@PathVariable("id") int id, @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "updateStudent";
		}
		studentService.updateStudent(student);
		model.addAttribute("students", studentService.findAllStudent());
		return "redirect:";
	}

	@GetMapping(value = "{id}")
	public String deleteStudent(@PathVariable("id") int id, Model model) {
		studentService.deleteStudent(id);
		model.addAttribute("students", studentService.findAllStudent());
		return "redirect:";
	}
}

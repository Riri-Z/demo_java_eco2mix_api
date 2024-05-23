package com.eco2mix.student;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

  private final StudentService studentService; //Reference à studentService

  public StudentController(StudentService studentService) {
    //On utilise la réference dans le controller
    // Pour éviter     this.studentService = new studentService();
    //avec Java 17 et Spring 4.3+, on peut omettre @Autowired sur les constructeurs si la classe n'a qu'un seul constructeur. Pour l'injection par champ ou par setter, @Autowired est toujours nécessaire.
    this.studentService = studentService;
  }

  @GetMapping()
  public List<Student> getStudents() {

    return studentService.getStudents();
  }

}

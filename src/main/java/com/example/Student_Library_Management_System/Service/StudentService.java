package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.StudentUpdateMob;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Model.Card;
import com.example.Student_Library_Management_System.Model.Student;
import com.example.Student_Library_Management_System.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student){

        //card should be generated when addStudent get call
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);//set foreign key attributes value

        //set the student attributes
        student.setCard(card);

        //if there was a unidirectional mapping : We have to save both of them
        //but by using bidirectional mapping : child will get save automatically

        studentRepository.save(student);

        //by cascading effect child get save automatically
        return "Student and Card Added Successfully";
    }

    public String findByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMobileNo(StudentUpdateMob studentUpdateMob){

        /*
        Without DTO
        //if we directly save the student, the attributes which are not be updating are not in RequestBody so they get
        // set to default values so we cant do that

//        Student oldDataOfStudent = studentRepository.findById(student.getId()).get();
//        oldDataOfStudent.setMobNo(student.getMobNo());
//        studentRepository.save(oldDataOfStudent);
         */

        //By using DTOs
        //Convert DTO to Entity : saved better
        Student oldDataOfStudent = studentRepository.findById(studentUpdateMob.getId()).get();
        oldDataOfStudent.setMobNo(studentUpdateMob.getMobileNo());
        studentRepository.save(oldDataOfStudent);

        return "Mobile no updated Successfully";
    }
}

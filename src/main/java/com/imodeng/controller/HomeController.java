package com.imodeng.controller;

import com.imodeng.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/azure")
public class HomeController {

    Logger logger = LoggerFactory.getLogger(HomeController.class);

    List<Student> students = new ArrayList<Student>();
    {
        students.add(new Student("Isaac", "XX", "Canada"));
        students.add(new Student("Maryam", "X", "USA"));
        students.add(new Student("Trump", "V", "USA"));
        students.add(new Student("Obama", "IV", "Kenya"));
        students.add(new Student("Bebeto", "II", "Brazil"));
        students.add(new Student("Oluwaseun", "I", "Nigeria"));
    }

    @GetMapping("/")
    public List<Student> index()
    {
        logger.info("Student Size " + students.size());
        return students;
    }


    @GetMapping("/getStudentByName/{name}")
    public Student getStudentByName(@PathVariable(value = "name")String name)
    {
        logger.info("searching for getStudentByName() with " + name);
        Student response = students.stream().filter(x->x.getName().equalsIgnoreCase(name))
                       .collect(Collectors.toList())
                       .get(0);

            return response;
    }

    @GetMapping("/getStudentByCountry/{country}")
    public List<Student> getStudentByCountry(@PathVariable(value = "country")String country)
    {
        logger.info("searching for getStudentByCountry() with " + country);
        List<Student> response =  students.stream().filter(x->x.getCountry().equalsIgnoreCase(country))
                                          .collect(Collectors.toList());
        if(response.size() > 0)
        {
            return response;
        }
            return null;
    }

    @GetMapping("/getStudentByCls/{cls}")
    public List<Student> getStudentByCls(@PathVariable(value = "cls")String cls)
    {
        logger.info("searching for getStudentByCls() with " + cls);
        List<Student> response =  students.stream().filter(x->x.getCls().equalsIgnoreCase(cls))
                .collect(Collectors.toList());
        if(response.size() > 0)
        {
            return response;
        }
            return null;
    }

}

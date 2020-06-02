/*
 *
 * Copyright (C)  2020  mike.education
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */

package cr.una.ejemplo.controller;

import cr.una.ejemplo.model.Student;
import cr.una.ejemplo.service.StudentService;
import cr.una.ejemplo.service.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Webservice using Spring Boot
 * Entity Student
 */
@Controller
@RequestMapping(value = "/api/students")
public class StudentController {

    private StudentService studentService = new StudentServiceImpl();

    @GetMapping()
    @ResponseBody
    public List<Student> findAll() {
        List<Student> studentList = null;
        studentList = studentService.findAll();
        return studentList;
    }

    @GetMapping("{course}")
    @ResponseBody
    public List<Student> findByCourse(@PathVariable String course) {
        List<Student> studentList = null;
        studentList = studentService.findByCourse(course);
        return studentList;
    }


}

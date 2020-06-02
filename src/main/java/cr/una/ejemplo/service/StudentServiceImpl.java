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

package cr.una.ejemplo.service;

import cr.una.ejemplo.dao.StudentDAO;
import cr.una.ejemplo.dao.StudentDAOImpl;
import cr.una.ejemplo.model.Student;

import java.util.List;

/**
 * Layer Service / Business Logic
 * Accessing the data from the external API
 */
public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO;
    List<Student> listStudents = null;


    /**
     * Find all student from External API
     *
     * @return the list of Students
     */
    @Override
    public List<Student> findAll() {
        List<Student> listStudents = null;
        studentDAO = new StudentDAOImpl();
        listStudents = studentDAO.findAll();
        return listStudents;
    }

    /**
     * Find all student from External API depending of the course name
     *
     * @param course
     * @return the list of Students
     */
    @Override
    public List<Student> findByCourse(String course) {
        List<Student> listStudents = null;
        studentDAO = new StudentDAOImpl();
        listStudents = studentDAO.findByCourse(course);
        return listStudents;
    }
}

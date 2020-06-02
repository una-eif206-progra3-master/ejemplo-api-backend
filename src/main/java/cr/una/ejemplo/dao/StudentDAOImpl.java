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

package cr.una.ejemplo.dao;

import cr.una.ejemplo.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Layer Data Access Object
 * Accessing the data from the external API
 */
public class StudentDAOImpl implements StudentDAO {

    // Using logger for project
    final Logger logger = LogManager.getLogger(StudentDAOImpl.class);

    private static final String REST_URI = "https://api.mlab.com/api/1/databases/students/collections/student?apiKey=12KfjNX97_amx0iUdS2I_eitAy3jSaOb";

    public StudentDAOImpl() {
    }

    /**
     * Find all student from External API
     *
     * @return the list of Students
     */
    @Override
    public List<Student> findAll() {

        List<Student> studentList = null;
        RestTemplate restTemplate = new RestTemplate();
        studentList = Arrays.asList(restTemplate.getForObject(REST_URI, Student[].class));

        return studentList;
    }

    /**
     * Find all student from External API depending of the course name
     *
     * @param course
     * @return the list of Students
     */
    @Override
    public List<Student> findByCourse(String course) {
        List<Student> studentList = null;
        String query = "{\"course\": \"" + course + "\"}";
        String URL = REST_URI + "&q={query}";
        RestTemplate restTemplate = new RestTemplate();
        studentList = Arrays.asList(restTemplate.getForObject(URL, Student[].class, query));

        return studentList;    }

}

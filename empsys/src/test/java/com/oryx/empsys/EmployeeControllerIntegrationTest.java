package com.oryx.empsys;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.oryx.empsys.model.Employee;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllEmployees() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees", HttpMethod.GET, entity,
                String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetEmployeeById() {
        Employee emp = restTemplate.getForObject(getRootUrl() + "/employees/1", Employee.class);
        System.out.println(emp.getFirstName());
        assertNotNull(emp);
    }

    @Test
    public void testCreateEmployee() {
        Employee emp = new Employee();
        emp.setEmailId("test@mail.com");
        emp.setFirstName("test_fname");
        emp.setLastName("test_lname");
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", emp,
                Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateEmployee() {
        int id = 1;
        Employee emp = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Employee.class);
        emp.setFirstName("test1_fname");
        emp.setLastName("test2_lname");
        restTemplate.put(getRootUrl() + "/employees/" + id, emp);
        Employee updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        int id = 2;
        Employee emp = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Employee.class);
        assertNotNull(emp);
        restTemplate.delete(getRootUrl() + "/employees/" + id);
        try {
            emp = restTemplate.getForObject(getRootUrl() + "/employees/" + id, Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}

package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import Model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ModelController {
    private List<Employee> employees=new ArrayList<>();

    @PostMapping("/employees")
    public Employee addemployee(@RequestBody Employee employee){
        employees.add(employee);
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getallemployee(){
        return employees;
    }

    @GetMapping("{/id}")
    public Stream<Employee> getEmployeeById(@PathVariable Long id){
        return employees.stream().filter(emp->emp.getId().equals(id));
    }

    @DeleteMapping("{/id}")
    public String deleteEmployees(@PathVariable Long id){
        employees.removeIf(emp->emp.getId().equals(id));
        return "Employee removed successfully";
    }

}

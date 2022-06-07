package Helper;

import java.util.List;

import com.ty.dto.EmployeeDto;
import com.ty.service.EmployeeService;

public class Test {
	
	
	public static void main(String[] args) {
		
		EmployeeService employeeService = new EmployeeService() ;
		List<EmployeeDto> emp =employeeService.searchEmployeeByName("bal") ;
		System.out.println(emp.size());
	}
}

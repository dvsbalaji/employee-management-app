package Helper;

import java.time.LocalDate;
import java.time.Period;

public class AgeCaliclator {

	public static int caliculateAge(LocalDate dob) {
		
		LocalDate currentDate = LocalDate.now() ;
		
		if((dob !=null)  && (currentDate != null)) {
			return Period.between(dob, currentDate).getYears() ;
		}else {
			return 0 ;
		}
	}
}

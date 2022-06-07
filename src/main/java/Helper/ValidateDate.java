package Helper;

import java.time.LocalDate;
import java.time.Period;

import com.google.protobuf.Duration;

public class ValidateDate {

	public static boolean validateDate(LocalDate selected, LocalDate joinedOn) {
		LocalDate present = LocalDate.now();
	
		if (selected != null && joinedOn != null && present != null) {
			int days = Period.between(selected, present).getMonths();
			int days2 = Period.between(present ,joinedOn ).getMonths() ;
		
			if (days >= 1 && days2 <= 0) {
				return true;
			}

		}
		return false;
	}
}

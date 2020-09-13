package telran.ashkelon2020.dto.customer;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerUpdateDTO {
	String firstName;
	String secondName;
	LocalDate birthDay;
	String password;

}

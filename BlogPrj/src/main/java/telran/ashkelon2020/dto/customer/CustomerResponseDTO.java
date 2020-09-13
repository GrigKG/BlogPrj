package telran.ashkelon2020.dto.customer;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.ashkelon2020.dto.accoun.AccountDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDTO {
	Integer id;
	String firstName;
	String secondName;
	LocalDate birthDay;
	Set<AccountDTO> accounts;

}

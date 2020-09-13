package telran.ashkelon2020.dto.subscriber;

import java.time.LocalDateTime;
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
public class SubscriberResponseDTO {
	String login;
	String name;
	LocalDateTime createDate;
	Set<AccountDTO> accounts;
}

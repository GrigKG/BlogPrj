package telran.ashkelon2020.dto.accoun;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.ashkelon2020.dto.customer.CustomerDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberDTO;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccounResponseDTO {
	String login;
	String name;
	LocalDateTime createDate;
	CustomerDTO customer;
	Set<String> tegs;
	Set<SubscriberDTO> subscribers;
}

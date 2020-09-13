package telran.ashkelon2020.dto.accoun;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {
	String login;
	String name;
	Set<String> tegs;
}

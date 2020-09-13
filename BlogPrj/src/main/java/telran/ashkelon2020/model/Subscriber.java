package telran.ashkelon2020.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"login"})
@Entity
public class Subscriber {
	@Id
	String login;
	String name;
	String password;
	LocalDateTime createDate = LocalDateTime.now();
	@ManyToMany
	Set<Account> accounts = new HashSet<>();
	
	public boolean addAccount(Account account) {
		return accounts.add(account);
	}
	
	public boolean removeAccount(Account account) {
		return accounts.remove(account);
	}
}

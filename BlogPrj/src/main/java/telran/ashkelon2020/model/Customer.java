package telran.ashkelon2020.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
//@Table(name="Big_Customers_Table")
public class Customer {
	@Id
	Integer id;
	String firstName;
	String secondName;
	LocalDate birthDay;
	String password;
	@OneToMany(mappedBy= "customer")
	Set<Account> accounts = new HashSet<>();
	
	 public boolean addAccount(Account account){
			 return accounts.add(account);
		 }
		 
	 public boolean removeAccount(Account account){
			return accounts.remove(account);
		 }
}

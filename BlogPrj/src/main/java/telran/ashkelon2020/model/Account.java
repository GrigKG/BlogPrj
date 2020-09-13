package telran.ashkelon2020.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Account {
	@Id
	String login;
	String name;
	LocalDateTime createDate = LocalDateTime.now();
	@ManyToOne
	Customer customer;
	//FIXME
	//Set<String> tegs = new HashSet<>();
	@ManyToMany
	Set<Subscriber> subscribers = new HashSet<>();
	
	 public boolean add(String teg){
		return false;
		// return tegs.add(teg);
	 }
	 
	 public boolean remove(String teg){
		return false;
		// return tegs.remove(teg);
	 }

	 public boolean add(Subscriber subscriber){
			return subscribers.add(subscriber);
		 }
		 
		 public boolean remove(Subscriber subscriber){
			return subscribers.remove(subscriber);
		 }
	 
	public Account(String login, String name, Customer customer) {
		super();
		this.login = login;
		this.name = name;
		this.customer = customer;
	}

	
}

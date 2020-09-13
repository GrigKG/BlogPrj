package telran.ashkelon2020.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {
}

package telran.ashkelon2020.service;

import java.time.LocalDate;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.ashkelon2020.dao.AccountRepository;
import telran.ashkelon2020.dao.CustomerRepository;
import telran.ashkelon2020.dao.SubscriberRepository;
import telran.ashkelon2020.dto.accoun.AccounResponseDTO;
import telran.ashkelon2020.dto.accoun.AccountDTO;
import telran.ashkelon2020.dto.accoun.AccountUpdateDTO;
import telran.ashkelon2020.dto.customer.CustomerCreateDTO;
import telran.ashkelon2020.dto.customer.CustomerResponseDTO;
import telran.ashkelon2020.dto.customer.CustomerUpdateDTO;
import telran.ashkelon2020.dto.exception.ObjectNotFoundException;
import telran.ashkelon2020.dto.subscriber.SubscriberDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberResponseDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberUpdateDTO;
import telran.ashkelon2020.model.Account;
import telran.ashkelon2020.model.Customer;
import telran.ashkelon2020.model.Subscriber;

@Service
public class BlogPrjServiceImpl implements BlogPrjService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	SubscriberRepository subscriberRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public boolean createCustomer(CustomerCreateDTO customerDTO) {
		if (customerRepository.existsById(customerDTO.getId())) {
			return false;
		}
		if (customerDTO.getId() == null || customerDTO.getPassword() == null || customerDTO.getFirstName() == null) {
			return false;
		}

		return customerRepository.save(modelMapper.map(customerDTO, Customer.class)) != null;
	}

	@Override
	public CustomerResponseDTO readCustomerById(Integer id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		return modelMapper.map(customer, CustomerResponseDTO.class);
	}

	@Override
	public CustomerResponseDTO updateCustomer(Integer id, CustomerUpdateDTO customerUpdateDTO) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		String firstName = customerUpdateDTO.getFirstName();
		String secondName = customerUpdateDTO.getSecondName();
		LocalDate birthDay = customerUpdateDTO.getBirthDay();
		String password = customerUpdateDTO.getPassword();
		boolean edit = false;
		if (firstName != null && firstName != customer.getFirstName()) {
			customer.setFirstName(firstName);
			edit = true;
		}
		if (secondName != null && secondName != customer.getSecondName()) {
			customer.setSecondName(secondName);
			edit = true;
		}
		if (birthDay != null && birthDay != customer.getBirthDay()) {
			customer.setBirthDay(birthDay);
			edit = true;
		}
		if (password != null && password != customer.getPassword()) {
			customer.setPassword(password);
			edit = true;
		}
		if (edit)
			customerRepository.save(customer);
		return modelMapper.map(customer, CustomerResponseDTO.class);
	}

	@Override
	public CustomerResponseDTO removeCustomer(Integer id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		customer.getAccounts().stream().map(a -> a.getLogin()).forEach(login->removeAccount(login));
		customerRepository.deleteById(id);
		return modelMapper.map(customer, CustomerResponseDTO.class);
	}

	@Override
	public boolean addAccount(Integer id, AccountDTO accountDTO) {
		if (accountRepository.existsById(accountDTO.getLogin())) {
			return false;
		}
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		if (accountDTO.getLogin() == null || accountDTO.getName() == null) {
			return false;
		}
		Account account = new Account(accountDTO.getLogin(), accountDTO.getName(), customer);
		customer.addAccount(account);
		return accountRepository.save(account) != null && customerRepository.save(customer) != null;
	}

	@Override
	public AccounResponseDTO readAccountById(String login) {
		Account account = accountRepository.findById(login).orElseThrow(() -> new ObjectNotFoundException(login));
		return modelMapper.map(account, AccounResponseDTO.class);
	}

	@Override
	public AccounResponseDTO updateAccount(String login, AccountUpdateDTO accountUpdateDTO) {
		Account account = accountRepository.findById(login).orElseThrow(() -> new ObjectNotFoundException(login));
		String name = accountUpdateDTO.getName();
		@SuppressWarnings("unused")
		//FIXME
		Set<String> tegs = accountUpdateDTO.getTegs();
		boolean edit = false;
		if (name != null && name != account.getName()) {
			account.setName(name);
			edit = true;
		}
		if (edit)
			accountRepository.save(account);
		return modelMapper.map(account, AccounResponseDTO.class);
	}

	@Override
	public AccounResponseDTO removeAccount(String login) {
		Account account = accountRepository.findById(login).orElseThrow(() -> new ObjectNotFoundException(login));
		account.getSubscribers().stream().forEach(s -> s.removeAccount(account));
		accountRepository.delete(account);
		return modelMapper.map(account, AccounResponseDTO.class);
	}

	@Override
	public boolean createSubscriber(SubscriberDTO subscriberDTO) {
		if (subscriberRepository.existsById(subscriberDTO.getLogin())) {
			return false;
		}
		System.out.println(subscriberDTO.getLogin()+"=="+subscriberDTO.getPassword()+"=="+subscriberDTO.getName());
		if (subscriberDTO.getLogin() == null || subscriberDTO.getPassword() == null
				|| subscriberDTO.getName() == null) {
			return false;
		}
		return subscriberRepository.save(modelMapper.map(subscriberDTO, Subscriber.class)) != null;
	}

	@Override
	public SubscriberResponseDTO readSubscriberById(String login) {
		Subscriber subscriber = subscriberRepository.findById(login)
				.orElseThrow(() -> new ObjectNotFoundException(login));
		return modelMapper.map(subscriber, SubscriberResponseDTO.class);
	}

	@Override
	public SubscriberResponseDTO updateSubscriber(String login, SubscriberUpdateDTO subscriberUpdateDTO) {
		Subscriber subscriber = subscriberRepository.findById(login)
				.orElseThrow(() -> new ObjectNotFoundException(login));
		String name = subscriberUpdateDTO.getName();
		String password = subscriberUpdateDTO.getPassword();
		boolean edit = false;
		if (name != null && name != subscriber.getName()) {
			subscriber.setName(name);
			edit = true;
		}
		if (password != null && password != subscriber.getPassword()) {
			subscriber.setPassword(password);
			edit = true;
		}

		if (edit)
			subscriberRepository.save(subscriber);
		return modelMapper.map(subscriber, SubscriberResponseDTO.class);
	}

	@Override
	public SubscriberResponseDTO removeSubscriber(String login) {
		Subscriber subscriber = subscriberRepository.findById(login)
				.orElseThrow(() -> new ObjectNotFoundException(login));
		subscriber.getAccounts().stream().forEach(a->a.remove(subscriber));
		subscriberRepository.delete(subscriber);
		return modelMapper.map(subscriber, SubscriberResponseDTO.class);
	}

	@Override
	public boolean addAccountToSubscriber(String loginAccount, String loginSubscriber) {
		Account account = accountRepository.findById(loginAccount)
				.orElseThrow(() -> new ObjectNotFoundException(loginAccount));
		Subscriber subscriber = subscriberRepository.findById(loginSubscriber)
				.orElseThrow(() -> new ObjectNotFoundException(loginSubscriber));
		subscriber.addAccount(account);
		account.add(subscriber);
		return accountRepository.save(account) != null&&subscriberRepository.save(subscriber) != null;
	}

	@Override
	public boolean removeAccountToSubscriber(String loginAccount, String loginSubscriber) {
		Account account = accountRepository.findById(loginAccount)
				.orElseThrow(() -> new ObjectNotFoundException(loginAccount));
		Subscriber subscriber = subscriberRepository.findById(loginSubscriber)
				.orElseThrow(() -> new ObjectNotFoundException(loginSubscriber));
		subscriber.removeAccount(account);
		account.remove(subscriber);
		return accountRepository.save(account) != null&&subscriberRepository.save(subscriber) != null;
	}

}

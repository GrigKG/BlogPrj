package telran.ashkelon2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.dto.accoun.AccounResponseDTO;
import telran.ashkelon2020.dto.accoun.AccountDTO;
import telran.ashkelon2020.dto.accoun.AccountUpdateDTO;
import telran.ashkelon2020.dto.customer.CustomerCreateDTO;
import telran.ashkelon2020.dto.customer.CustomerResponseDTO;
import telran.ashkelon2020.dto.customer.CustomerUpdateDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberResponseDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberUpdateDTO;
import telran.ashkelon2020.service.BlogPrjService;

@RestController
public class BlogPrjController implements BlogPrjService {

	@Autowired
	BlogPrjService service;
	
	
	@Override
	@PostMapping("/Customer")
	public boolean createCustomer(@RequestBody CustomerCreateDTO customerDTO) {
		return service.createCustomer(customerDTO);
	}

	@Override
	@GetMapping("/Customer/{id}")
	public CustomerResponseDTO readCustomerById(@PathVariable Integer id) {
		return service.readCustomerById(id);
	}

	@Override
	@PutMapping("/Customer/{id}")
	public CustomerResponseDTO updateCustomer(@PathVariable Integer id,@RequestBody CustomerUpdateDTO customerUpdateDTO) {
		return service.updateCustomer(id, customerUpdateDTO);
	}

	@Override
	@DeleteMapping("/Customer/{id}")
	public CustomerResponseDTO removeCustomer(@PathVariable Integer id) {
		return service.removeCustomer(id);
	}

	@Override
	@PostMapping("/Account/{id}")
	public boolean addAccount(@PathVariable Integer id,@RequestBody AccountDTO accountDTO) {
		return service.addAccount(id, accountDTO);
	}

	@Override
	@GetMapping("/Account/{login}")
	public AccounResponseDTO readAccountById(@PathVariable String login) {
		return service.readAccountById(login);
	}

	@Override
	@PutMapping("/Account/{login}")
	public AccounResponseDTO updateAccount(@PathVariable String login, @RequestBody AccountUpdateDTO accountUpdateDTO) {
		return service.updateAccount(login, accountUpdateDTO);
	}

	@Override
	@DeleteMapping("/Account/{login}")
	public AccounResponseDTO removeAccount(@PathVariable  String login) {
		return service.removeAccount(login);
	}

	@Override
	@PostMapping("/Subscriber")
	public boolean createSubscriber(@RequestBody SubscriberDTO subscriberDTO) {
		System.out.println(subscriberDTO);
		return service.createSubscriber(subscriberDTO);
	}

	@Override
	@GetMapping("/Subscriber/{login}")
	public SubscriberResponseDTO readSubscriberById(@PathVariable  String login) {
		return service.readSubscriberById(login);
	}

	@Override
	@PutMapping("/Subscriber/{login}")
	public SubscriberResponseDTO updateSubscriber(@PathVariable  String login,@RequestBody SubscriberUpdateDTO subscriberUpdateDTO) {
		return service.updateSubscriber(login, subscriberUpdateDTO);
	}

	@Override
	@DeleteMapping("/Subscriber/{login}")
	public SubscriberResponseDTO removeSubscriber(@PathVariable  String login) {
		return service.removeSubscriber(login);
	}

	@Override
	@PutMapping("/Subscriber/{loginSubscriber}/Account/{loginAccount}")
	public boolean addAccountToSubscriber(@PathVariable String loginAccount,@PathVariable String loginSubscriber) {
		return service.addAccountToSubscriber(loginAccount, loginSubscriber);
	}

	@Override
	@DeleteMapping("/Subscriber/{loginSubscriber}/Account/{loginAccount}")
	public boolean removeAccountToSubscriber(@PathVariable String loginAccount,@PathVariable String loginSubscriber) {
		return service.removeAccountToSubscriber(loginAccount, loginSubscriber);
	}

}

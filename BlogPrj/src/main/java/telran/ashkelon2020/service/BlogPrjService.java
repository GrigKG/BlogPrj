package telran.ashkelon2020.service;

import telran.ashkelon2020.dto.accoun.AccounResponseDTO;
import telran.ashkelon2020.dto.accoun.AccountDTO;
import telran.ashkelon2020.dto.accoun.AccountUpdateDTO;
import telran.ashkelon2020.dto.customer.CustomerCreateDTO;
import telran.ashkelon2020.dto.customer.CustomerResponseDTO;
import telran.ashkelon2020.dto.customer.CustomerUpdateDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberResponseDTO;
import telran.ashkelon2020.dto.subscriber.SubscriberUpdateDTO;

public interface BlogPrjService {
	
	//CRUD Customer
	boolean createCustomer (CustomerCreateDTO customerDTO);

	CustomerResponseDTO readCustomerById(Integer id);

	CustomerResponseDTO updateCustomer(Integer id, CustomerUpdateDTO customerUpdateDTO);

	CustomerResponseDTO removeCustomer(Integer id);

	//CRUD Account
	boolean addAccount(Integer id, AccountDTO accountDTO);

	AccounResponseDTO readAccountById(String login);

	AccounResponseDTO updateAccount(String login, AccountUpdateDTO accountUpdateDTO);
	
	AccounResponseDTO removeAccount(String login);
	
	//CRUD Subscriber
	boolean createSubscriber(SubscriberDTO subscriberDTO);

	SubscriberResponseDTO readSubscriberById(String login);

	SubscriberResponseDTO updateSubscriber(String login, SubscriberUpdateDTO subscriberUpdateDTO);

	SubscriberResponseDTO removeSubscriber(String login);
	
	boolean addAccountToSubscriber(String loginAccount, String loginSubscriber);
	
	boolean removeAccountToSubscriber(String loginAccount, String loginSubscriber);
	
	//Iterable<CustomerDTO> findBooksByAuthor(String authorName);

	//Iterable<CustomerDTO> findBooksByPublisher(String publisherName);


}

package telran.ashkelon2020.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, String> {
}

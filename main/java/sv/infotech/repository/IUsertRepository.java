package sv.infotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.infotech.entity.User;

public interface IUsertRepository extends JpaRepository<User, Integer> {

	User findByClientId(Integer clientId);

	List<User> findByIsActive(String IsActive);
}

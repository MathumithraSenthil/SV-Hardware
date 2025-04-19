package sv.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.infotech.entity.Upi;

public interface IupiRepository extends JpaRepository<Upi, Integer>{

	Upi findByUpiId(int upiId);
}

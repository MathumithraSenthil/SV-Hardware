package sv.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.infotech.entity.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Integer>{

	Instrument findByInstrumentId(int instrumentId);
}

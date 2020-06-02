package flore.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flore.model.Flore;
import flore.web.dto.Bonus;
import flore.web.dto.FloreForm;
import flore.web.dto.Malus;
import flore.web.dto.SimulateurUn;

public interface ISimulateurUnRepositoryCustom {
	SimulateurUn synergieUn(@Param("nomFlore1") String nomFlore1, @Param("nomFlore2") String nomFlore2);
}

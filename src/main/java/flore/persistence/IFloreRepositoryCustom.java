package flore.persistence;

import java.util.List;

import org.springframework.data.repository.query.Param;

import flore.model.Flore;
import flore.web.dto.FloreForm;

public interface IFloreRepositoryCustom {
	List<Flore> search(@Param("floreform") FloreForm floreform );
}

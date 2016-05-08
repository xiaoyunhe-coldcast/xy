package xy.yangtzeu.repository;

import org.springframework.stereotype.Repository;

import xy.yangtzeu.model.Storage;

@Repository("StorageRepository")
public class StorageRepository extends AbstractEntityRepository<Storage, Integer>{

	@Override
	protected Class<Storage> getEntityClazz() {
		return Storage.class;
	}

}

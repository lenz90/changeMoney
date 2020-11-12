package com.lenz.bcp.changeMoney.infrastructure.repository.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeTypeH2Repository extends CrudRepository<ChangeTypeEntity, String> {
}

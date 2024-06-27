package org.dwrik.logmonitor.repository;

import org.dwrik.logmonitor.entity.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogmonitorRepository extends CrudRepository<Log, Long> {
}

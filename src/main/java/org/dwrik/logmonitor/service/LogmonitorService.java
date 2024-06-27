package org.dwrik.logmonitor.service;

import org.dwrik.logmonitor.entity.Log;
import org.dwrik.logmonitor.repository.LogmonitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogmonitorService {

	private final LogmonitorRepository logmonitorRepository;

	@Autowired
	public LogmonitorService(LogmonitorRepository logmonitorRepository) {
		this.logmonitorRepository = logmonitorRepository;
	}

	@Transactional
	public Log createLog(Log log) {
		log.setId(null);
		return logmonitorRepository.save(log);
	}

	@Transactional(readOnly = true)
	public Iterable<Log> getAllLogs() {
		return logmonitorRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Log getLog(Long id) {
		return logmonitorRepository.findById(id).orElse(null);
	}

	@Transactional
	public void deleteLog(Long id) {
		logmonitorRepository.deleteById(id);
	}

}

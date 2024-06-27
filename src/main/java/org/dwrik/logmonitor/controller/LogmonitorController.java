package org.dwrik.logmonitor.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.dwrik.logmonitor.entity.Log;
import org.dwrik.logmonitor.service.LogmonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class LogmonitorController {

	private final LogmonitorService logmonitorService;

	@Autowired
	public LogmonitorController(LogmonitorService logmonitorService) {
		this.logmonitorService = logmonitorService;
	}

	@PostMapping
	ResponseEntity<Log> create(@Valid @RequestBody Log userLog) {
		var saved = logmonitorService.createLog(userLog);
		return ResponseEntity.ok(saved);
	}

	@GetMapping
	ResponseEntity<Iterable<Log>> getAll() {
		var logs = logmonitorService.getAllLogs();
		return ResponseEntity.ok(logs);
	}

	@GetMapping("/{id}")
	ResponseEntity<Log> getOne(@PathVariable Long id) {
		var saved = logmonitorService.getLog(id);
		if (saved == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(saved);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id) {
		logmonitorService.deleteLog(id);
		return ResponseEntity.noContent().build();
	}

}

package com.example.onlinedebate;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinedebate.model.Statement;
import com.example.onlinedebate.service.StatementService;

@RestController
@RequestMapping("/statement")
public class StatementResource {

	private final StatementService statementService;

	public StatementResource(StatementService statementService) {
		super();
		this.statementService = statementService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Statement>> getAllStatements() {
		List<Statement> statements = statementService.findAllStatements();
		return new ResponseEntity<>(statements, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Statement> getStatementById(@PathVariable("id") Long id) {
		Statement statement = statementService.findStatementById(id);
		return new ResponseEntity<>(statement, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Statement> addStatement(@RequestBody Statement statement) {
		Statement newStatement = statementService.addStatement(statement);
		return new ResponseEntity<>(newStatement, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Statement> updateStatement(@RequestBody Statement statement) {
		Statement updateStatement = statementService.updateStatement(statement);
		return new ResponseEntity<>(updateStatement, HttpStatus.OK);
	}
	
	@Transactional
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Statement> deleteStatement(@PathVariable Long id) {
		statementService.deleteStatement(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

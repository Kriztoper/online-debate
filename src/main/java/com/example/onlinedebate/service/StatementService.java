package com.example.onlinedebate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinedebate.exception.StatementNotFoundException;
import com.example.onlinedebate.model.Statement;
import com.example.onlinedebate.repo.StatementRepo;

@Service
public class StatementService {
	
	private final StatementRepo statementRepo;

	@Autowired
	public StatementService(StatementRepo statementRepo) {
		super();
		this.statementRepo = statementRepo;
	}
	
	public Statement addStatement(Statement statement) {
		return statementRepo.save(statement);
	}
	
	public List<Statement> findAllStatements() {
		return statementRepo.findAll();
	}
	
	public Statement updateStatement(Statement statement) {
		return statementRepo.save(statement);
	}
	
	public Statement findStatementById(Long id) {
		return statementRepo.findStatementById(id)
				.orElseThrow(() -> new StatementNotFoundException("Statement by id " + id + " was not found"));
	}
	
	public void deleteStatement(Long id) {
		statementRepo.deleteStatementById(id);
	}
	
}

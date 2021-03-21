package com.example.onlinedebate.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinedebate.model.Statement;

public interface StatementRepo extends JpaRepository<Statement, Long> {

	void deleteStatementById(Long id);

	Optional<Statement> findStatementById(Long id);

}

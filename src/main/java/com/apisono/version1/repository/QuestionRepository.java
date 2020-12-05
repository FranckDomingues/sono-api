package com.apisono.version1.repository;

import com.apisono.version1.model.Questions;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Questions,Long> {
}

package com.apisono.version1.repository;

import com.apisono.version1.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question,Long> {
}

package com.apisono.version1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apisono.version1.model.CsvFileDownload;

public interface Repository extends JpaRepository<CsvFileDownload, Long> {
}

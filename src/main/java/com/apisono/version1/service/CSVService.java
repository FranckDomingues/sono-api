package com.apisono.version1.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisono.version1.helper.CSVHelper;
import com.apisono.version1.model.CsvFileDownload;
import com.apisono.version1.repository.Repository;

@Service
public class CSVService {

    @Autowired
    Repository repository;
    public ByteArrayInputStream load() {
        List<CsvFileDownload> csvFileDownloads = repository.findAll();

        ByteArrayInputStream in = CSVHelper.CsvFileDownload(csvFileDownloads);
        return in;
    }
}

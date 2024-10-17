package org.fs.logfileanalyzeratweb.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class StorageProperties {

    //Festlegen des Spreicherortes für den StorageService
    @Value("${storage.location}")
    public String location;

}
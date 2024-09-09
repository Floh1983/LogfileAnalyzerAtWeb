package org.fs.logfileanalyzeratweb.Provider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputFileProvider {
    private String inputFile;

    public InputFileProvider(String inputFile) {
        this.inputFile = inputFile;
    }

}
package org.fs.logfileanalyzeratweb.Provider;

public class OutputFolderProvider {
    private String outputFolder;

    public OutputFolderProvider(String outputFolder) {
        this.outputFolder = outputFolder;
    }

    public String outputFolder() {
        return outputFolder;
    }
}

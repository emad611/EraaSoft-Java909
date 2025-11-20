package com.model.service;

import java.io.IOException;

public class MyIOException {

    // الميثود ترمي IOException
    public void readFile() throws IOException {
        throw new IOException("Something went wrong!");
    }
}
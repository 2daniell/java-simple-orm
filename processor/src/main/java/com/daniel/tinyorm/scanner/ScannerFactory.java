package com.daniel.tinyorm.scanner;

public final class ScannerFactory {

    private ScannerFactory() {}

    public static Scanner getScanner() {
        return new RuntimeScanner(Thread.currentThread().getContextClassLoader());
    }
}

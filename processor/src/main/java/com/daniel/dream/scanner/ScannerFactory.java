package com.daniel.dream.scanner;

public final class ScannerFactory {

    private ScannerFactory() {}

    public static Scanner getScanner() {
        return new RuntimeScanner(Thread.currentThread().getContextClassLoader());
    }
}

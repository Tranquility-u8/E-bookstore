package com.my.bookstore_backend.service;

import java.util.List;

public interface CountService {
    public void countKeywords(String path, List<String> keywords);
}

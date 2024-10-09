package com.pos.system.service;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.sql.SQLException;

public interface BatchService {
    public void create(String token) throws SQLException, IOException, WriterException;
}

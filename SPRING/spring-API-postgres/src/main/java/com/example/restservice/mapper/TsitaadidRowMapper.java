package com.example.restservice.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.example.restservice.model.Tsitaadid;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TsitaadidRowMapper implements RowMapper<Tsitaadid> {

    @Override
    public Tsitaadid mapRow(ResultSet rs, int arg1) throws SQLException {
        Tsitaadid emp = new Tsitaadid();
        emp.setId(rs.getLong("id"));
        emp.setQuotation(rs.getString("quotation"));
        emp.setAuthor(rs.getString("author"));
        return emp;
    }
}

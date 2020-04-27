package com.example.restservice.dao;

import com.example.restservice.mapper.TsitaadidRowMapper;
import com.example.restservice.model.Tsitaadid;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TsitaadidDaoImpl implements TsitaadidDao {

    public TsitaadidDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;


    @Override
    public List<Tsitaadid> findAll() {
        return template.query("select * from tsitaadid", new TsitaadidRowMapper());
    }
}

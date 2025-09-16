package com.stockbrokeragesim.repo;
import com.stockbrokeragesim.model.ConnectToSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SQL_ConnectionRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }




    public List<ConnectToSQL> findAll() {
        String sql = "select * from stockBrokerageSimSQL1table1";

        return template.query(sql, (rs, rowNum) -> {
            return new ConnectToSQL();
        });
    }
}

package com.achui.community.dao.impl;

import com.achui.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

/**
 * @author Eurus.T
 */
@Repository("alphaMybatis")
public class AlphaDaoImpl implements AlphaDao {

    @Override
    public String select() {
        return "alphaDao";
    }
}

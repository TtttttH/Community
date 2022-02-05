package com.achui.community.dao.impl;

import com.achui.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

/**
 * @author Eurus.T
 */
@Repository("BetaDaoImpl")
public class BetaDaoImpl implements AlphaDao {
    @Override
    public String select() {
        return "betaDao";
    }
}

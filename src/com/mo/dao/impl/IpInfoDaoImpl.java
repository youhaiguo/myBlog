package com.mo.dao.impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mo.dao.IpInfoDao;
import com.mo.po.IpInfo;
import com.mo.util.DBCPUtil;

public class IpInfoDaoImpl implements IpInfoDao {

	private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

	public void add(IpInfo ipInfo) {
		try {
			qr.update("INSERT INTO ipinfo(ip,addresslocation,firstTime) VALUES(?,?,?)",ipInfo.getIp(),ipInfo.getAddressLocation(),ipInfo.getFirstTime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {
	}

	public IpInfo findByIp(String ip) {
		try {
			return qr.query("SELECT * FROM ipinfo WHERE ip = ?",new BeanHandler<IpInfo>(IpInfo.class),ip);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void update(IpInfo ipInfo) {
		try {
			qr.update("UPDATE ipinfo SET lastTime= ? ,visitTimes = ? WHERE ip = ?",ipInfo.getLastTime(),ipInfo.getVisitTimes(),ipInfo.getIp());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int findTotalCount() {
		try {
			return ((Long)qr.query("SELECT COUNT(*) FROM ipinfo", new ScalarHandler(1))).intValue();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

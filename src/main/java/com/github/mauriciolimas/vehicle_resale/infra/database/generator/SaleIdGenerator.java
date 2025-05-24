package com.github.mauriciolimas.vehicle_resale.infra.database.generator;

import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SaleIdGenerator implements IdentifierGenerator {

	private static final long serialVersionUID = 9186281270432433620L;
	public static final String PREFIX_REGEX = "SALE%06d";
	
	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		try {
			Statement statement = session.getJdbcConnectionAccess().obtainConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT nextval('sale_id_seq')");
			if(resultSet.next()) {
				long sequence = resultSet.getLong(1);
				return String.format(PREFIX_REGEX, sequence);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to generate ID", e);
		}
		throw new RuntimeException("Failed to generate ID");
	}

}

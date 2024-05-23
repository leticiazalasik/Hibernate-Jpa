package br.com.padaria;

import javax.persistence.Persistence;

import org.hibernate.hql.spi.id.persistent.PersistentTableBulkIdStrategy;

public class TestJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persistence.createEntityManagerFactory("padaria"); 
		
	}

}

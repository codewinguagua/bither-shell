package com.xhis.bitherShell.db.base;

import java.sql.SQLException;

import net.bither.bitherj.db.AbstractDb;

import org.junit.Test;

import com.xhis.bitherShell.db.AbstractDbInitializer;

public class SqliteTest {

	@Test
	public void dbTest() throws SQLException {
		new AbstractDbInitializer("c:/tmp/bitherShell");

		SqliteDb db = new SqliteDb("c:/tmp/bitherShell");
		db.initDb();
		boolean hasTable = db.hasTable(AbstractDb.Tables.TXS);
		System.out.println(hasTable);
		db.close();
	}

}

package com.xhis.bitherShell.db.base;

import net.bither.bitherj.db.imp.AbstractProvider;
import net.bither.bitherj.db.imp.base.IDb;

public class SqliteProvider extends AbstractProvider {

	private IDb db;

	public SqliteProvider(IDb db) {
		super();
		this.db = db;
	}

	@Override
	public IDb getReadDb() {
		return db;
	}

	@Override
	public IDb getWriteDb() {
		return db;
	}

}

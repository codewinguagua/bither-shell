package com.xhis.bitherShell.db;

import net.bither.bitherj.core.In;
import net.bither.bitherj.core.Out;
import net.bither.bitherj.core.Tx;
import net.bither.bitherj.db.imp.AbstractTxProvider;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;

public class TxProviderImpl extends AbstractTxProvider {

	IProvider provider;

	public TxProviderImpl(IProvider provider) {
		super();
		this.provider = provider;
	}

	@Override
	public IDb getReadDb() {
		return provider.getReadDb();
	}

	@Override
	public IDb getWriteDb() {
		return provider.getWriteDb();
	}

	@Override
	protected void insertTxToDb(IDb db, Tx tx) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void insertInToDb(IDb db, In in) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void insertOutToDb(IDb db, Out out) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

}

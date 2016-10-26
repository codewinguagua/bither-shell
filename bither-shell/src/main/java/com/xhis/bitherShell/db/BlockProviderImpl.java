package com.xhis.bitherShell.db;

import net.bither.bitherj.db.imp.AbstractBlockProvider;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;

public class BlockProviderImpl extends AbstractBlockProvider {

	IProvider provider;

	public BlockProviderImpl(IProvider provider) {
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

}

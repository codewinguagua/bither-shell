package com.xhis.bitherShell.db;

import net.bither.bitherj.db.imp.AbstractHDAccountAddressProvider;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;

public class HDAccountAddressProviderImpl extends
		AbstractHDAccountAddressProvider {

	IProvider provider;

	public HDAccountAddressProviderImpl(IProvider provider) {
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

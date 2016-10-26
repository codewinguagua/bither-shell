package com.xhis.bitherShell.db;

import net.bither.bitherj.db.imp.AbstractPeerProvider;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;

public class PeerProviderImpl extends AbstractPeerProvider {

	IProvider provider;

	public PeerProviderImpl(IProvider provider) {
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

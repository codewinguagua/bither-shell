package com.xhis.bitherShell.db;

import net.bither.bitherj.crypto.PasswordSeed;
import net.bither.bitherj.db.imp.AbstractHDAccountProvider;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;

public class HDAccountProviderImpl extends AbstractHDAccountProvider {
	IProvider provider;

	public HDAccountProviderImpl(IProvider provider) {
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
	protected int insertHDAccountToDb(IDb db, String encryptedMnemonicSeed,
			String encryptSeed, String firstAddress, boolean isXrandom,
			byte[] externalPub, byte[] internalPub) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected boolean hasPasswordSeed(IDb db) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void addPasswordSeed(IDb db, PasswordSeed passwordSeed) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected int insertMonitorHDAccountToDb(IDb db, String firstAddress,
			boolean isXrandom, byte[] externalPub, byte[] internalPub) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

}

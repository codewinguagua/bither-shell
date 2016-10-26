package com.xhis.bitherShell.db;

import net.bither.bitherj.core.Address;
import net.bither.bitherj.db.imp.AbstractAddressProvider;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;

public class AddressProviderImpl extends AbstractAddressProvider {

	IProvider provider;

	public AddressProviderImpl(IProvider provider) {
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
	protected int insertHDKeyToDb(IDb db, String encryptedMnemonicSeed,
			String encryptHdSeed, String firstAddress, boolean isXrandom) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected int insertEnterpriseHDKeyToDb(IDb db,
			String encryptedMnemonicSeed, String encryptHdSeed,
			String firstAddress, boolean isXrandom) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void insertHDMAddressToDb(IDb db, String address, int hdSeedId,
			int index, byte[] pubKeysHot, byte[] pubKeysCold,
			byte[] pubKeysRemote, boolean isSynced) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	protected void insertAddressToDb(IDb db, Address address) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

}

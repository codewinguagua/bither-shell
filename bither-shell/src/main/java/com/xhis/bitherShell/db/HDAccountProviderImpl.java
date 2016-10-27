package com.xhis.bitherShell.db;

import javax.annotation.Nullable;

import com.google.common.base.Function;

import net.bither.bitherj.crypto.PasswordSeed;
import net.bither.bitherj.db.imp.AbstractHDAccountProvider;
import net.bither.bitherj.db.imp.base.ICursor;
import net.bither.bitherj.db.imp.base.IDb;
import net.bither.bitherj.db.imp.base.IProvider;
import net.bither.bitherj.utils.Base58;

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

		String sql = "insert into hd_account("
				+ "encrypt_seed, encrypt_mnemonic_seed, hd_address, "
				+ "external_pub, internal_pub, is_xrandom) values(?,?,?,?,?,?)";
		Object[] params = {
			encryptSeed, encryptedMnemonicSeed, firstAddress,
			Base58.encode(externalPub), Base58.encode(internalPub),
			new Integer(isXrandom ? 1:0)
		};
		this.getWriteDb().execUpdate(sql, params);
		final Integer[] accountId = {0};
		this.getWriteDb().execQueryOneRecord(
				"select last_insert_rowid()", (Object[])null, new Function<ICursor, Void>() {
            @Nullable
            @Override
            public Void apply(@Nullable ICursor c) {
                if (c != null) {
                	accountId[0] = c.getInt(0);
                }
                return null;
            }
		});
        
		return accountId[0];

	}

	@Override
	protected boolean hasPasswordSeed(IDb db) {
		String sql = "select count(0) cnt from password_seed where password_seed is not null";
		final int[] count = {0};
		this.execQueryOneRecord(db, sql, null, new Function<ICursor, Void>() {
			@Nullable
			@Override
			public Void apply(@Nullable ICursor c) {
				int idColumn = c.getColumnIndex("cnt");
				if (idColumn != -1) {
					count[0] = c.getInt(idColumn);
				}
				return null;
			}
		});
		return count[0] > 0;
	}

	@Override
	protected void addPasswordSeed(IDb db, PasswordSeed passwordSeed) {
		if (!passwordSeed.toPasswordSeedString().isEmpty()) {
			String sql = "replace into password_seed(password_seed) values(?)";
			this.execUpdate(db, sql, new String[] {passwordSeed.toPasswordSeedString()});
		}
	}

	@Override
	protected int insertMonitorHDAccountToDb(IDb db, String firstAddress,
			boolean isXrandom, byte[] externalPub, byte[] internalPub) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

}

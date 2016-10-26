package com.xhis.bitherShell.db;

import java.sql.SQLException;

import com.xhis.bitherShell.db.base.SqliteDb;
import com.xhis.bitherShell.db.base.SqliteProvider;

import net.bither.bitherj.db.AbstractDb;
import net.bither.bitherj.db.IAddressProvider;
import net.bither.bitherj.db.IBlockProvider;
import net.bither.bitherj.db.IDesktopAddressProvider;
import net.bither.bitherj.db.IDesktopTxProvider;
import net.bither.bitherj.db.IEnterpriseHDMProvider;
import net.bither.bitherj.db.IHDAccountAddressProvider;
import net.bither.bitherj.db.IHDAccountProvider;
import net.bither.bitherj.db.IPeerProvider;
import net.bither.bitherj.db.ITxProvider;
import net.bither.bitherj.db.imp.base.IProvider;

public class AbstractDbInitializer extends AbstractDb {
	
	private IProvider provider;

	public AbstractDbInitializer(String dbDir) throws SQLException {
		super();
		
		SqliteDb db = new SqliteDb(dbDir);
		db.initDb();
		this.onCreate(db);

		this.provider = new SqliteProvider(db);
		this.construct();
	}

	@Override
	public IBlockProvider initBlockProvider() {
		return new BlockProviderImpl(this.provider);
	}

	@Override
	public IPeerProvider initPeerProvider() {
		return new PeerProviderImpl(this.provider);
	}

	@Override
	public ITxProvider initTxProvider() {
		return new TxProviderImpl(this.provider);
	}

	@Override
	public IAddressProvider initAddressProvider() {
		return new AddressProviderImpl(this.provider);
	}

	@Override
	public IHDAccountAddressProvider initHDAccountAddressProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHDAccountProvider initHDAccountProvider() {
		return new HDAccountProviderImpl(this.provider);
	}

	@Override
	public IEnterpriseHDMProvider initEnterpriseHDMProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDesktopAddressProvider initEnDesktopAddressProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDesktopTxProvider initDesktopTxProvider() {
		// TODO Auto-generated method stub
		return null;
	}


	private void onCreate(SqliteDb db) throws SQLException {
    	if (db.hasTable(AbstractDb.Tables.TXS)) {
            return;
        }

        createBlocksTable(db);

        createPeersTable(db);

        createAddressTxsTable(db);

        createTxsTable(db);
        createOutsTable(db);
        createInsTable(db);

        createHDAccountAddress(db);
    }

    private void createBlocksTable(SqliteDb db) throws SQLException {
        db.execUpdate(AbstractDb.CREATE_BLOCKS_SQL, null);
        db.execUpdate(AbstractDb.CREATE_BLOCK_NO_INDEX, null);
        db.execUpdate(AbstractDb.CREATE_BLOCK_PREV_INDEX, null);
    }

    private void createTxsTable(SqliteDb db) throws SQLException {
        db.execUpdate(AbstractDb.CREATE_TXS_SQL, null);
        db.execUpdate(AbstractDb.CREATE_TX_BLOCK_NO_INDEX, null);
    }

    private void createAddressTxsTable(SqliteDb db) throws SQLException {
    	db.execUpdate(AbstractDb.CREATE_ADDRESSES_SQL, null);

    	db.execUpdate(AbstractDb.CREATE_ADDRESSTXS_SQL, null);
    }

    private void createInsTable(SqliteDb db) throws SQLException {
        db.execUpdate(AbstractDb.CREATE_INS_SQL, null);
        db.execUpdate(AbstractDb.CREATE_IN_PREV_TX_HASH_INDEX, null);
    }

    private void createOutsTable(SqliteDb db) throws SQLException {
        db.execUpdate(AbstractDb.CREATE_OUTS_SQL, null);
        db.execUpdate(AbstractDb.CREATE_OUT_OUT_ADDRESS_INDEX, null);
    }

    private void createPeersTable(SqliteDb db) throws SQLException {
        db.execUpdate(AbstractDb.CREATE_PEER_SQL, null);
    }

    private void createHDAccountAddress(SqliteDb db) throws SQLException {
    	db.execUpdate(AbstractDb.CREATE_HD_SEEDS_SQL, null);
    	db.execUpdate(AbstractDb.CREATE_HD_ACCOUNT, null);
    	db.execUpdate(AbstractDb.CREATE_ALIASES_SQL, null);
    	db.execUpdate(AbstractDb.CREATE_VANITY_ADDRESS_SQL, null);
    	
    	db.execUpdate(AbstractDb.CREATE_HD_ACCOUNT_ADDRESSES, null);
        db.execUpdate(AbstractDb.CREATE_HD_ACCOUNT_ADDRESS_INDEX, null);
    }

}

package com.xhis.bitherShell.db.base;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.bither.bitherj.db.imp.base.ICursor;

public class SqliteCursor implements ICursor {

	private ResultSet rs;

	public SqliteCursor(ResultSet rs) {
		super();
		this.rs = rs;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public boolean moveToNext() {
		try {
			return rs.next();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getColumnIndex(String var1) {
		try {
			return getColumnIndexOrThrow(var1);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getColumnIndexOrThrow(String var1)
			throws IllegalArgumentException {
		try {
			int cnt = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= cnt; i++) {
				if (var1.equals(rs.getMetaData().getColumnName(i))) {
					return i-1;
				}
			}
			throw new IllegalArgumentException();
		} catch (SQLException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public byte[] getBlob(int var1) {
		try {
			Blob blob = rs.getBlob(var1+1);
			return (blob == null) ? null:blob.getBytes(1, (int)blob.length());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getString(int var1) {
		try {
			return rs.getString(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public short getShort(int var1) {
		try {
			return rs.getShort(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getInt(int var1) {
		try {
			return rs.getInt(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public long getLong(int var1) {
		try {
			return rs.getLong(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public float getFloat(int var1) {
		try {
			return rs.getFloat(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public double getDouble(int var1) {
		try {
			return rs.getDouble(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getType(int var1) {
		try {
			return rs.getMetaData().getColumnType(var1+1);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isNull(int var1) {
		try {
			return rs.getObject(var1+1) == null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
		try {
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean isClosed() {
		try {
			return rs.isClosed();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

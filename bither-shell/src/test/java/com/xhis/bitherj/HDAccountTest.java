package com.xhis.bitherj;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import net.bither.bitherj.core.HDAccount;
import net.bither.bitherj.crypto.mnemonic.MnemonicCode;
import net.bither.bitherj.crypto.mnemonic.MnemonicException.MnemonicChecksumException;
import net.bither.bitherj.crypto.mnemonic.MnemonicException.MnemonicLengthException;
import net.bither.bitherj.crypto.mnemonic.MnemonicException.MnemonicWordException;
import net.bither.bitherj.db.AbstractDb;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xhis.bitherShell.db.AbstractDbInitializer;

public class HDAccountTest {

	@BeforeClass
	static public void setup() throws SQLException, IOException {
		new AbstractDbInitializer("c:/tmp/bitherShell");
		MnemonicCode.setInstance(new MnemonicCodeImpl());
	}

	@Test
    public void testListAccount() {

		List<Integer> seeds = AbstractDb.hdAccountProvider.getHDAccountSeeds();
		for (Integer accountId:seeds) {
			String address = AbstractDb.hdAccountProvider.getHDFirstAddress(accountId);
			System.out.println(accountId + "\t" + address);
		}

    }

	@Test
	public void testCreateAccount() throws MnemonicLengthException {
		SecureRandom random = new SecureRandom();
		CharSequence password = (CharSequence)"password";
		HDAccount account = new HDAccount(random, password, null);
		assertNotNull(account);

		List<String> words = account.getSeedWords(password);
		System.out.println(words);
	}

	@Test
	public void testGetAccount() throws MnemonicLengthException {
		CharSequence password = (CharSequence)"password";
		HDAccount account = new HDAccount(6);
		assertNotNull(account);

		List<String> words = account.getSeedWords(password);
		System.out.println(words);
		
	}

	@Test
	public void testImportAccount() throws MnemonicLengthException, MnemonicWordException, MnemonicChecksumException {
		CharSequence password = (CharSequence)"password";
		String[] words = {
		};

		byte[] entropy = MnemonicCode.instance().toEntropy(Arrays.asList(words));
		HDAccount account = new HDAccount(entropy, password, false);
		System.out.println("account imported, address = " + account.getAddress());
		List<String> words_imp = account.getSeedWords(password);
		System.out.println(words_imp);
	}
	
    public static final class MnemonicCodeImpl extends MnemonicCode {
        private static final String WordListPath = "wordlist/english.txt";

        public MnemonicCodeImpl() throws IOException {
            super();
        }

        @Override
        protected InputStream openWordList() throws IOException {
            InputStream stream = MnemonicCode.class.getResourceAsStream(WordListPath);
            if (stream == null) {
                throw new FileNotFoundException(WordListPath);
            }
            return stream;
        }
    }

}

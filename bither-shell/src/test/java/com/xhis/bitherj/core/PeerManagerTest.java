/*
 * Copyright 2014 http://Bither.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xhis.bitherj.core;

import java.sql.SQLException;

import net.bither.bitherj.core.AddressManager;
import net.bither.bitherj.core.Block;
import net.bither.bitherj.core.BlockChain;
import net.bither.bitherj.core.PeerManager;

import org.junit.BeforeClass;
import org.junit.Test;

import com.xhis.bitherShell.AbstractAppInitializer;
import com.xhis.bitherShell.db.AbstractDbInitializer;

public class PeerManagerTest {

	@BeforeClass
	static public void before() throws SQLException {
		new AbstractDbInitializer("c:/tmp/bitherShell");
		new AbstractAppInitializer();
		AddressManager.getInstance();
	}

	@Test
    public void testNormal() throws InterruptedException {
//        Block block = new Block(2,
//       		"00000000000000000ee9b585e0a707347d7c80f3a905f48fa32d448917335366",
//        		"4d60e37c7086096e85c11324d70112e61e74fc38a5c5153587a0271fd22b65c5",
//        		1400928750, 409544770l, 4079278699l, 302400);
//        Block block = new Block(536870912,
//        		"0000000000000000027fd968d41741f31c73c4a3b304472da0165245278e2ea3",
//       		"0138c1cf3f774df6793460fd67c0adff82ccb203ca3d73371ad3c24265a48f94",
//        		1477159378, 402937298L, 3034795581L, 435456);
        Block block = new Block(536870912,
        		"00000000000000000025b8961d1d0cfba33b0205ec10b3ce541618e352b0bbd5",
        		"8c55637368e07a5838cb8b3d8b276750904ee29a5f46d3a355ac34234c97acfd",
        		1474795015, 402951892L, 4022704741L, 431424);
        BlockChain.getInstance().addSPVBlock(block);
        PeerManager.instance().start();

        while (true) {
            Thread.sleep(1000);
        }
    }
}

package com.xhis.bitherShell.bitherjimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

public class BlockNotificationCenter {
    public interface IBlockListener {
        public void blockChange();
    }

    private static List<IBlockListener> blockChangeList = new ArrayList<IBlockListener>();

    public static void notificationBlockChange() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (IBlockListener blockChange : blockChangeList) {
                    blockChange.blockChange();
                }
            }
        });

    }

    public static void addBlockChange(IBlockListener blockChange) {
        if (!blockChangeList.contains(blockChange)) {
            blockChangeList.add(blockChange);
        }
    }

    public static void removeBlockChange(IBlockListener blockChange) {
        blockChangeList.remove(blockChange);
    }
}

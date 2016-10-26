package com.xhis.bitherShell.bitherjimpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.bither.bitherj.NotificationService;
import net.bither.bitherj.core.HDAccount;
import net.bither.bitherj.core.Tx;
import net.bither.bitherj.utils.UnitUtil;
import net.bither.bitherj.utils.Utils;

public class TxNotificationCenter {

	private static final Logger log = LoggerFactory.getLogger(NotificationService.class);

	public interface ITxListener {
        public void notificatTx(String address, Tx tx,
                                Tx.TxNotificationType txNotificationType, long deltaBalance);
    }

    private static List<ITxListener> txListenerList = new ArrayList<ITxListener>();

    public static void notificatTx(final String address, final Tx tx,
                                   final Tx.TxNotificationType txNotificationType, final long deltaBalance) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (ITxListener txListener : txListenerList) {
                    txListener.notificatTx(address, tx, txNotificationType, deltaBalance);
                }
                if (txNotificationType == Tx.TxNotificationType.txReceive) {
                    boolean isReceived = deltaBalance > 0;
                    long balance = Math.abs(deltaBalance);
                    notifyCoins(address, balance, isReceived);
                }
            }
        });


    }

    public static void addTxListener(ITxListener txListener) {
        if (!txListenerList.contains(txListener)) {
            txListenerList.add(txListener);
        }
    }

    public static void removeTxListener(ITxListener txListener) {
        txListenerList.add(txListener);
    }

    private static void notifyCoins(String address, final long amount,
                                    boolean isReceived) {
        String contentText = address;
        if (Utils.compareString(address, HDAccount.HDAccountPlaceHolder)) {
            contentText = "add_hd_account_tab_hd";
        }
        String title = UnitUtil.formatValue(amount, UnitUtil.BitcoinUnit.BTC) + " " + UnitUtil.BitcoinUnit.BTC.name();
        if (isReceived) {
            title = "feed_received_btc" + " " + title;
        } else {
            title = "feed_send_btc" + " " + title;
        }
        final String msg = contentText + " \n" + title;
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.info(msg);
            }
        });

    }
}

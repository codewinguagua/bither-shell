package com.xhis.bitherShell.bitherjimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.bither.bitherj.AbstractApp;
import net.bither.bitherj.NotificationService;
import net.bither.bitherj.core.Tx;

public class NotificationServiceImpl implements NotificationService {
    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);


    @Override
    public void sendLastBlockChange() {
        BlockNotificationCenter.notificationBlockChange();

    }

    @Override
    public void notificatTx(String address, Tx tx, Tx.TxNotificationType txNotificationType, long deltaBalance) {
        TxNotificationCenter.notificatTx(address, tx, txNotificationType, deltaBalance);

    }

    @Override
    public void sendBroadcastAddressLoadCompleteState() {
        AddressNotificationCenter.notificationAddressLoadComplete();

    }

    @Override
    public void sendBroadcastPeerState(final int numPeers) {
        PeerNotificationCenter.sendBroadcastPeerState(numPeers);

    }

    @Override
    public void sendConnectedChangeBroadcast(String connectedChangeBroadcast, boolean isConnected) {
        PeerNotificationCenter.sendConnectedChangeBroadcast(connectedChangeBroadcast, isConnected);
    }

    @Override
    public void sendBroadcastProgressState(double value) {
        PeerNotificationCenter.sendBroadcastProgressState(value);

    }

    @Override
    public void removeProgressState() {
        PeerNotificationCenter.removeProgressState();
    }


    @Override
    public void sendBroadcastSyncSPVFinished(boolean isFinished) {
        if (isFinished) {
            AbstractApp.bitherjSetting.setBitherjDoneSyncFromSpv(isFinished);
            //PeerUtil.startPeer();
            throw new RuntimeException("Not implemented");
        }
    }

    @Override
    public void removeBroadcastSyncSPVFinished() {

    }

    @Override
    public void sendBroadcastGetSpvBlockComplete(boolean isComplete) {

    }

    @Override
    public void removeBroadcastPeerState() {

    }

    @Override
    public void removeAddressLoadCompleteState() {

    }
}

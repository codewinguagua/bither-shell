package com.xhis.bitherShell;

import java.io.File;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;

import com.xhis.bitherShell.bitherjimpl.NotificationServiceImpl;

import net.bither.bitherj.AbstractApp;
import net.bither.bitherj.BitherjSettings;
import net.bither.bitherj.ISetting;
import net.bither.bitherj.NotificationService;
import net.bither.bitherj.BitherjSettings.ApiConfig;
import net.bither.bitherj.api.TrustCert;
import net.bither.bitherj.qrcode.QRCodeUtil;

public class AbstractAppInitializer extends AbstractApp {

    private CookieStore cookieStore = new BasicCookieStore();

    public AbstractAppInitializer() {
		super();
		this.construct();
	}

	@Override
    public TrustCert initTrustCert() {
        return null;
    }

    @Override
    public ISetting initSetting() {
        return new ISetting() {
            @Override
            public BitherjSettings.AppMode getAppMode() {
                return BitherjSettings.AppMode.HOT;
            }

            @Override
            public boolean getBitherjDoneSyncFromSpv() {
                return true;
            }

            @Override
            public void setBitherjDoneSyncFromSpv(boolean isDone) {
                // AppSharedPreference.getInstance().setBitherjDoneSyncFromSpv(isDone);
            }

            @Override
            public BitherjSettings.TransactionFeeMode getTransactionFeeMode() {
                return BitherjSettings.TransactionFeeMode.Low;
            }

            @Override
            public File getPrivateDir(String dirName) {
                File file = new File("c:/tmp/bitherj/wallet");
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file;
            }

            @Override
            public boolean isApplicationRunInForeground() {
                return true;
            }

            @Override
            public QRCodeUtil.QRQuality getQRQuality() {
                return QRCodeUtil.QRQuality.Normal;
            }

            @Override
            public boolean getDownloadSpvFinish() {
                return true;
            }

            @Override
            public void setDownloadSpvFinish(boolean finish) {
                // AppSharedPreference.getInstance().setDownloadSpvFinish(finish);
            }

            @Override
            public CookieStore getCookieStore() {
                return cookieStore;
            }

			@Override
			public ApiConfig getApiConfig() {
				// TODO Auto-generated method stub
				// MC: missing from bitherj project
				return null;
			}

        };
    }

    @Override
    public NotificationService initNotification() {
        return new NotificationServiceImpl();
    }

}

package org.opensms.helper;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

public class UiHelper {

	public static synchronized boolean checkDataAvlable(Context context) {

		boolean status = false;

		final ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (null != connManager) {
			NetworkInfo[] allNetworks = connManager.getAllNetworkInfo();
			if (null != allNetworks) {
				for (NetworkInfo info : allNetworks) {
					if (info.getState() == NetworkInfo.State.CONNECTED) {
						status = true;
						break;
					}
				}
			}
		}

		if (!status) {
			buildAlertMessageNoData(context);
			return false;
		}

		return true;
	}

	private static void buildAlertMessageNoData(final Context context) {
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setMessage(
				"Your Data seems disabled, This application needs Data to process info, Do you want to enable it now?")
				.setCancelable(false)
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(final DialogInterface dialog,
									final int id) {

								Intent intent = new Intent(
										Settings.ACTION_NETWORK_OPERATOR_SETTINGS);

								ComponentName cName = new ComponentName(
										"com.android.phone",
										"com.android.phone.Settings");

								intent.setComponent(cName);

								context.startActivity(intent);

								dialog.cancel();
								dialog.dismiss();
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					public void onClick(final DialogInterface dialog,
							final int id) {
						dialog.cancel();
						dialog.dismiss();
					}
				});
		final AlertDialog alert = builder.create();
		alert.show();
	}

}

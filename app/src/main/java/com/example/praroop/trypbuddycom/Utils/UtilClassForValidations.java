package com.example.praroop.trypbuddycom.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

public class UtilClassForValidations
{
	//Pattern EMAIL_ADDRESS_PATTERN;
	public static void alatMassageBox(Context ctx, String msg)
	{	
		AlertDialog.Builder altDialog= new AlertDialog.Builder(ctx);
		altDialog.setMessage(msg); // here add your message
		altDialog.setNeutralButton("OK", new DialogInterface.OnClickListener()
		{		   
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		altDialog.show();

	}


	public static boolean haveInternet(Context ctx) {
		try {
			NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx
					.getSystemService(Context.CONNECTIVITY_SERVICE))
					.getActiveNetworkInfo();

			if (info == null || !info.isConnected()) {
				return false;
			}
		} catch (Exception e) {
			//
		}
		return true;
	}
	
	// CHECK FOR GPS METHOD
		public static final boolean isGpsOn(Context ctx, LocationManager lm, boolean showAlert) {
			boolean isGpsOn = false;

			if (lm.isProviderEnabled(LocationManager.GPS_PROVIDER)){
				isGpsOn = true;
			}else if(!isGpsOn && showAlert){
				isGpsOn = false;
				showGPSDisabledAlertToUser(ctx);
			}
			return isGpsOn;	
		}
		private static void showGPSDisabledAlertToUser(final Context context){
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
			alertDialogBuilder.setMessage("GPS is disabled in your device. Please enable it before registration.")
			.setCancelable(false)
			.setPositiveButton("Yes",
					new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int id){
					Intent callGPSSettingIntent = new Intent(
							android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
					context.startActivity(callGPSSettingIntent);
				}
			});
			alertDialogBuilder.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog, int id){
					dialog.cancel();
				}
			});
			AlertDialog alert = alertDialogBuilder.create();
			alert.show();
		}
	
	public static boolean checkEmail(String email)
	{
		final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(

				"[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
						"\\@" +
						"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
						"(" +
						"\\." +
						"[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
						")+"
				);

		return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
	}

	public static String convertStringFromInputStream(InputStream is ) throws IOException
	{
		
		try {
			byte[] bytes = new byte[1024];

			StringBuilder x = new StringBuilder();

			int numRead = 0;
			while ((numRead = is.read(bytes)) >= 0) 
			{
				x.append(new String(bytes, 0, numRead));
			}
			return x.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String convertStringFromFile(String file, Context context) throws IOException
	{	
		AssetManager am = context.getAssets();
		InputStream is = am.open(file);
		return convertStringFromInputStream( is );
	}
	


	// check tab n mobiles
		public static boolean isTablet(Context context) {
			return (context.getResources().getConfiguration().screenLayout
					& Configuration.SCREENLAYOUT_SIZE_MASK)
					>= Configuration.SCREENLAYOUT_SIZE_LARGE;
		}
}

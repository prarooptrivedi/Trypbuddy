package com.example.praroop.trypbuddycom.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Utils {
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
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
            //
        }
        return true;
    }

    public static String getPreviousDate() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        Date date = dateFormat.parse(Utils.getCurrentDateddMMyyyy());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        String yesterdayAsString = dateFormat.format(calendar.getTime());
        return yesterdayAsString;
    }
    public static String getCurrentDateddMMyyyy(){
        try
        {
            long timeInMillis = System.currentTimeMillis();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(timeInMillis);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // hh // MM-dd-yyyy HH:mm:ss
            final String currentDate = dateFormat.format(cal1.getTime());
            return currentDate;
        }catch (Exception e) {
            return null;
        }
    }
    public static String getLastsevenDate(String date){
        try
        {Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)-6);
            Date myDate = cal.getTime();
            return date;
        }catch (Exception e) {
            return null;
        }
    }
    public static String addDay(String dd, String addValue) throws ParseException {
        String result="";
        // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dd));
        c.add(Calendar.DATE, Integer.parseInt(addValue));  // number of days to add
        result = sdf.format(c.getTime());
        return result;
    }
    public static String NumberFormate(String inputString){
        String resultString="";
        try {
            Float litersOfPetrol = Float.parseFloat(inputString);


            DecimalFormat df = new DecimalFormat("0.00");
            df.setMaximumFractionDigits(2);
            resultString = df.format(litersOfPetrol);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return resultString;
    }
    public static String NewFormateDMY(String dd){
        String result="";
        try{ //20161001
            Date date = new SimpleDateFormat("ddmmyyyy", Locale.ENGLISH).parse(dd);
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
            SimpleDateFormat monthyear = new SimpleDateFormat("yy");
            result =
//dayFormat.format(date)
//+ suffixes[Integer.parseInt(dayFormat.format(date))]
                    monthFormat.format(date)
                            + " " + monthyear.format(date);
        }
        catch (Exception e){}
        return result;
    }
    public static String getAddress(Double latitude, Double longitude, Activity act){
        String adrs="",address="",city="",state="",country="",postalCode;
        try{
            // Geocoder geocoder;
            List<Address> addresses;
            Geocoder geocoder = new Geocoder(act, Locale.getDefault());
            addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5
            address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
            city = addresses.get(0).getLocality();
            state = addresses.get(0).getAdminArea();
            country = addresses.get(0).getCountryName();
           // postalCode = addresses.get(0).getPostalCode();
            //String knownName = addresses.get(0).getFeatureName(); // Only if available else return NULL
            adrs = address+" "+city+" "+state+" "+country+" ";
        }
        catch(Exception ex){
            ex.printStackTrace();
            adrs = "Address not found !!!";
        }
        return adrs;
    }

    public static boolean getSpecial(String strP){
        boolean result=false;
        try{
            Pattern p = Pattern.compile("[\\p{Alpha}]*[\\p{Punct}][\\p{Alpha}]*");
            Matcher m = p.matcher(strP);
            boolean b = m.matches();
            if (b == true) {
                result = true;
// System.out.println("There is a sp. character in my string");
            }
            else{
                result =false;
//System.out.println("There is no sp. char.");
            }
        }
        catch (Exception e){}
        return result;
    }
    // / Custom Alert Dialog
    public static void customDialog(Context ctx, String msg) {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(ctx, AlertDialog.THEME_DEVICE_DEFAULT_DARK)
                .setMessage(msg).setNeutralButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                dialog.dismiss();
                            }
                        }).create();
        myQuittingDialogBox.show();
    }

    public static String roundTwoDecimals(Float d) {
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        return twoDForm.format(d);
    }
    public static String replaceNull(String input) {
        return input == null ? "" : input;
    }
    public static String replaceNull1(String input) {
        return input == null ? "" : input;
    }
    public static String replaceNullOne(String input) {
       String inn = input == null ? "" : input;
        if(inn.equalsIgnoreCase("")){
            inn = "";
        }
        return inn;
    }
    public static String replaceNullthree(String input) {
        String inn = input == null ? "" : input;
        if(inn.equalsIgnoreCase("")){
            inn = "0";
        }
        return inn;
    }
    public static String replaceNullOne11(String input) {
        String inn = input == null ? "" : input;
        if(inn.equalsIgnoreCase("")){
            inn = "";
        }
        return inn;
    }
    public static String minusOneMinute(String input) {
        String dateAndTime = "";
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(input);
            long milliseconds = date.getTime();
            //long millisecondsFromNow = milliseconds - (new Date()).getTime();
            long res = (milliseconds - (60 * 1000));//2 * 24 * 60 * 60 * 1000;//days * hours * minutes* seconds *thousand
            Date resDate = new Date(res);

            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            //System.out.println(format1.format(resDate));
            dateAndTime = format1.format(resDate);


        } catch (ParseException e) {
            //e.printStackTrace();
            dateAndTime = "";
        }

        return dateAndTime;
    }

    public static String replaceNullTwo(String input) {
        String inn = input == null ? "" : input;
        if(inn.equalsIgnoreCase("")){
            inn = "";
        }
        return inn;
    }
    public static String replaceNullOne1(String input) {
        String inn = input == null ? "" : input;
        if(inn.equalsIgnoreCase("")){
            inn = "0";
        }
        return inn;
    }
    public static String replaceNulltwo(String input) {
        String inn = input == null ? "" : input;
        if(inn.equalsIgnoreCase("")){
            inn = "0";
        }
        return inn;
    }

    @SuppressLint("SimpleDateFormat")
    public static String getCurrentDate(){
        try
        {
            long timeInMillis = System.currentTimeMillis();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(timeInMillis);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // hh // MM-dd-yyyy HH:mm:ss
            final String currentDate = dateFormat.format(cal1.getTime());
            return currentDate;
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

 /*   public static String getCurrentDate() {
        try {
            long timeInMillis = System.currentTimeMillis();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(timeInMillis);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // hh // MM-dd-yyyy HH:mm:ss
            final String currentDate = dateFormat.format(cal1.getTime());
            return currentDate;
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }*/
    public static String changeformat(String str){
try {

    String dateString="Jun 1 2016 12:00AM";
    DateFormat dateFormat=new SimpleDateFormat("MMM dd yyyy HH:mmaaa");
    try { Date date= dateFormat.parse(dateString);
        Calendar calendar= Calendar.getInstance(); calendar.setTime(date);
        String formatedDate=calendar.get(Calendar.DATE)+"- "+(calendar.get(Calendar.MONTH)+1)+"- "+calendar.get(Calendar.YEAR); System.out.println(formatedDate);
        return  formatedDate;
    }
    catch (ParseException e)
    {
        e.printStackTrace();
    }
}
catch (Exception e)
{
    e.printStackTrace();
}
        return  null;
    }
    /*@SuppressLint("SimpleDateFormat")
    public static String getCurrentDate1(){
        try
        {
            long timeInMillis = System.currentTimeMillis();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(timeInMillis);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // hh // MM-dd-yyyy HH:mm:ss
            final String currentDate = dateFormat.format(cal1.getTime());
            return currentDate;
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }*/
    public static String convertdate(String str){
        try
        {
            String strr=str;
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            String inputDateStr="2013-06-24";
            Date date = inputFormat.parse(strr);
            String outputDateStr = outputFormat.format(date);
            return  outputDateStr;
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    public static String convertdate1(String str){
        try
        {
            String strr=str;
            DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String inputDateStr="2013-06-24";
            Date date = outputFormat.parse(strr);
            String outputDateStr = inputFormat.format(date);
            return  outputDateStr;
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }
    public static String getTomarrow(){
        String strtomarrow = "";
        try{
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, +1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dt1=dateFormat.parse(dateFormat.format(cal.getTime()));
            DateFormat format2=new SimpleDateFormat("EEEE");
            strtomarrow=format2.format(dt1);
        }
        catch (Exception e){
//
        }
        return strtomarrow.substring(0,3);

    }
    public static String getdateTomarrow(String input_date){
        String finalday="";
        try{
            SimpleDateFormat format1=new SimpleDateFormat("dd-MM-yyyy");
            Date dt1=format1.parse(input_date);
            DateFormat format2=new SimpleDateFormat("EEEE");
            finalday=format2.format(dt1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return finalday.substring(0,3);
    }
    public static String convertDateFormateToNewFormate(String dd){
        String result="";
        try{
            Date date = new SimpleDateFormat("MMddyyyy", Locale.ENGLISH).parse(dd);
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
            SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
            SimpleDateFormat monthyear = new SimpleDateFormat("yyyy");
            result =
                    dayFormat.format(date)
                            + suffixes[Integer.parseInt(dayFormat.format(date))]
                            + " " + monthFormat.format(date)
                            + " " + monthyear.format(date);
        }
        catch (Exception e){}
        return result;
    }
    static String[] suffixes =
// 0 1 2 3 4 5 6 7 8 9
            { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
// 10 11 12 13 14 15 16 17 18 19
                    "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
// 20 21 22 23 24 25 26 27 28 29
                    "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
// 30 31
                    "th", "st" };

    public static String removeyear(String olddate){
        String converteddate="";
        try {
            Date d1,d2;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dateFormatnew = new SimpleDateFormat("dd-MM");
            d1 = dateFormat.parse(olddate);
            String sdate = dateFormat.format(d1);
            d2= dateFormatnew.parse(sdate);
            converteddate= dateFormatnew.format(d2);
            return  converteddate;
        }
        catch (Exception e){
            return converteddate;
        }
    }
    public static String getTodayDay(String input_date){
        String finalday="";
        try{
            SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
            Date dt1=format1.parse(input_date);
            DateFormat format2=new SimpleDateFormat("EEEE");
            finalday=format2.format(dt1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return finalday;
    }



    public static String getCurrenttime() {
        String reportDate = "";
        reportDate = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        return reportDate;
    }
    public static String getCurrenttime1() {
        //date output format
        String reportDate = "";
        DateFormat dateFormat = new SimpleDateFormat(" HH:mm");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
   /* public static Comparator<ProductMaster> nameComparator = new Comparator<ProductMaster>() {
        @SuppressLint("DefaultLocale")
        @Override
        public int compare(ProductMaster pm1, ProductMaster pm2) {
            String str1 = pm1.getName().toUpperCase();
            String str2 = pm2.getName().toUpperCase();
            // ascending order
            return str1.compareTo(str2);
            // descending order
            //return str2.compareTo(str1);
        }
    };*/

    public static String getIMEI(Context context){
        String newIMEI="";
        try {
            String android_id = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);
            byte bytes[] = android_id.getBytes();
            Checksum checksum = new CRC32();
            checksum.update(bytes, 0, bytes.length);
            long lngChecksum = checksum.getValue();
            String strVal = String.valueOf(lngChecksum);
            newIMEI = strVal.substring(Math.max(strVal.length() - 5, 0));
            return newIMEI;
        }
        catch (Exception e){
//
            return newIMEI;
        }
    }
    public static String convertDF(String strUserdate){
        String strResult="";
        try{
            SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
            strResult = myFormat.format(fromUser.parse(strUserdate));
        }
        catch (Exception e){}
        return strResult;
    }
    public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
    public static String repNull(String input) {
        return input == null ? "" : input;
    }
    public static boolean checkPermission(Context context)

    {
        String permission = "android.permission.CALL_PHONE";
        int res = context.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }
    public static void startInstalledAppDetailsActivity(final Context context) {
        if (context == null) {
            return;
        }
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
	/*	i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);*/
        context.startActivity(i);
    }


    // do encrypt code
    public static String doDecrypt(String data, String key){
        String decryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] keyBytes = new byte[16];
            byte[] b = key.getBytes("UTF-8");
            int len = b.length;
            if (len > keyBytes.length)
                len = keyBytes.length;
            System.arraycopy(b, 0, keyBytes, 0, len);
            SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] results = new byte[data.length()];
            try {
                results = cipher.doFinal(Base64.decode(data, Base64.DEFAULT));
            } catch (Exception e) {
                Log.i("Erron in Decryption", e.toString());
            }
            Log.i("Data", new String(results, "UTF-8"));
            decryptedData = new String(results, "UTF-8");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return decryptedData;
    }

    public static String getNetworkType(Context context) {
        TelephonyManager mTelephonyManager = (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        int networkType = mTelephonyManager.getNetworkType();
        switch (networkType) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return "2G Network";
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
                return "3G Network";
            case TelephonyManager.NETWORK_TYPE_LTE:
                return "4G Network";
            default:
                return "";
        }
    }
}

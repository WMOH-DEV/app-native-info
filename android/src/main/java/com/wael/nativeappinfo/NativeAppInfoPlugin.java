package com.wael.nativeappinfo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@CapacitorPlugin(name = "NativeAppInfo")
public class NativeAppInfoPlugin extends Plugin {

    private NativeAppInfo implementation = new NativeAppInfo();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getAppInstaller(PluginCall call) {
        try {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            String installerPackageName;

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                // API 30+
                installerPackageName = packageManager.getInstallSourceInfo(context.getPackageName())
                        .getInstallingPackageName();
            } else {
                // API 29 and below
                installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            }

            // Format installer name if necessary
            String installerName = getFormattedInstallerName(installerPackageName);

            // Send result back to Capacitor
            JSObject result = new JSObject();
            result.put("installer", installerName);
            call.resolve(result);

        } catch (Exception e) {
            call.reject("Error fetching installer info", e);
        }
    }

    // Helper method to format installer name
    private String getFormattedInstallerName(String installerPackageName) {
        if (installerPackageName == null) {
            return "Unknown Installer";
        }

        switch (installerPackageName) {
            case "com.android.vending":
                return "Google Play Store";
            case "com.amazon.venezia":
                return "Amazon App Store";
            case "com.android.chrome":
                return "Google Chrome";
            case "com.google.android.packageinstaller":
                return "Package Installer";
            case "com.whatsapp":
                return "WhatsApp";
            case "org.mozilla.firefox":
                return "Firefox";
            default:
                return installerPackageName; // Return the raw package name if no match
        }
    }

    @PluginMethod
    public void getManifestValues(PluginCall call) {
        try {
            Context context = getContext();
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            Map<String, Object> manifestValues = new HashMap<>();
            if (appInfo.metaData != null) {
                for (String key : appInfo.metaData.keySet()) {
                    manifestValues.put(key, appInfo.metaData.get(key));
                }
            }
            call.resolve(new JSObject().put("values", new JSONObject(manifestValues)));
        } catch (Exception e) {
            call.reject("Error fetching manifest values", e);
        }
    }
}

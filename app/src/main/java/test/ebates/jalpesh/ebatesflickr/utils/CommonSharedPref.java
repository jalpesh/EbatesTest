package test.ebates.jalpesh.ebatesflickr.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class CommonSharedPref {

    private static final String PREFS_STORAGE = "FLICKR_preference_file";

    private static SharedPreferences getPreferences(Context context) {
        int mode = Context.MODE_PRIVATE;
        if (context != null) {
            return context.getSharedPreferences(PREFS_STORAGE, mode);
        }
        return null;
    }

    private static SharedPreferences getPreferences(Context context, String filename) {
        int mode = Context.MODE_PRIVATE;
        return context.getSharedPreferences(filename, mode);
    }

    public static void clear(Context context) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();
        }
    }

    /**
     * Get the value for given key in particular pref file
     *
     * @param key Key name.
     * @return Value or null.
     */
    public static synchronized String getString(Context context, String filename, String key, String defaultValue) {
        SharedPreferences prefs = getPreferences(context, filename);
        if (prefs != null) {
            return prefs.getString(key, defaultValue);
        }
        return null;
    }

    /**
     * Set value for given key in particular pref file.
     *
     * @param key   Key name.
     * @param value Key Value.
     */
    public static synchronized void putString(Context context, String filename, String key, String value) {
        SharedPreferences prefs = getPreferences(context, filename);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putString(key, value).apply();
        }
    }

    /**
     * Get the value for given key
     *
     * @param key key name.
     * @return Value or null.
     */
    public static synchronized String getString(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getString(key, null);
        }
        return null;
    }

    public static synchronized String getString(Context context, String key, String defaultValue) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getString(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * Set value for given key.
     *
     * @param key   key name.
     * @param value Value.
     */
    public static synchronized void putString(Context context, String key, String value) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putString(key, value).apply();
        }
    }

    /**
     * Set value for given key.
     *
     * @param key   key name.
     * @param value Value.
     */
    public static synchronized void commitString(Context context, String key, String value, boolean immediateBlockWrite) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            if (immediateBlockWrite) {
                prefsEditor.putString(key, value).commit();
            } else {
                prefsEditor.putString(key, value).apply();
            }
        }
    }

    /**
     * Get the value for given key
     *
     * @param key Key name.
     * @return Value or null.
     */
    public static synchronized boolean getBoolean(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getBoolean(key, false);
        }
        return false;
    }

    /**
     * Get the value for given key
     *
     * @param key Key name.
     * @return Value or null.
     */
    public static synchronized boolean getBoolean(Context context, String key, boolean defaultValue) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getBoolean(key, defaultValue);
        }
        return false;
    }

    /**
     * Get the value for given key in particular pref file
     *
     * @param key key name.
     * @return Value or null.
     */
    public static synchronized boolean getBoolean(Context context, String filename, String key, boolean defaultValue) {
        SharedPreferences prefs = getPreferences(context, filename);
        return prefs != null && prefs.getBoolean(key, defaultValue);
    }

    /**
     * Set value for given key.
     *
     * @param key   key name.
     * @param value Value.
     */
    public static synchronized void putBoolean(Context context, String key, boolean value) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putBoolean(key, value).apply();
        }
    }

    /**
     * Set value for given key.
     *
     * @param key   key name.
     * @param value Value.
     */
    public static synchronized void commitBoolean(Context context, String key, boolean value, boolean immediateBlock) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            if (immediateBlock) {
                prefsEditor.putBoolean(key, value).commit();
            } else {
                prefsEditor.putBoolean(key, value).apply();
            }

        }
    }

    /**
     * Set value for given key in particular pref file.
     *
     * @param key   key name.
     * @param value Value.
     */
    public static synchronized void putBoolean(Context context, String filename, String key, boolean value) {
        SharedPreferences prefs = getPreferences(context, filename);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putBoolean(key, value).apply();
        }
    }

    /**
     * Get the value for given key
     *
     * @param key key name.
     * @return Value.
     */
    public static synchronized int getInt(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getInt(key, Integer.MIN_VALUE);
        }
        return Integer.MIN_VALUE;
    }

    public static synchronized int getInt(Context context, String key, int defaultValue) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getInt(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * Set value for given key.
     *
     * @param key   Key name.
     * @param value Value.
     */
    public static synchronized void putInt(Context context, String key, int value) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putInt(key, value).apply();
        }
    }

    /**
     * Get the value for given key
     *
     * @param key key name.
     * @return Value.
     */
    public static synchronized long getLong(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getLong(key, Long.MIN_VALUE);
        }
        return Long.MIN_VALUE;
    }

    public static synchronized long getLong(Context context, String key, long defaultValue) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            return prefs.getLong(key, defaultValue);
        }
        return defaultValue;
    }

    /**
     * Set value for given key.
     *
     * @param key   Key name.
     * @param value Value.
     */
    public static synchronized void putLong(Context context, String key, long value) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.putLong(key, value).apply();
        }
    }

    /**
     * To remove the given key
     *
     * @param key used as key
     */
    public static synchronized void remove(Context context, String key) {
        SharedPreferences prefs = getPreferences(context);
        if (prefs != null) {
            SharedPreferences.Editor prefsEditor = prefs.edit();
            prefsEditor.remove(key).apply();
        }
    }

    /**
     * Method returns all key value pairs
     *
     * @return @return Returns a map containing a list of pairs key/value representing
     */
    public static synchronized Map<String, ?> getAll(Context context) {
        SharedPreferences prefs = getPreferences(context);
        Map<String, ?> all = null;
        if (prefs != null) {
            all = prefs.getAll();
        }
        return all;
    }

    public static String getPrefFileName() {
        return PREFS_STORAGE;
    }

}

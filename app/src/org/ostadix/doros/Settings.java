/*
 * Doros settings. Copyright (C) 2026 Lee Daghlar Ostadi. GPL-3.0-or-later; see LICENSE.
 */
package org.ostadix.doros;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.SecureRandom;

final class Settings {
    static final String STORE = "doros";
    static final int MIN_SPEED_PERCENT = 2, MAX_SPEED_PERCENT = 200;
    final SharedPreferences prefs;
    Settings(Context context) {
        prefs = context.getSharedPreferences(STORE, Context.MODE_PRIVATE);
        if (!prefs.contains("seed")) prefs.edit().putLong("seed", new SecureRandom().nextLong()).apply();
    }
    long seed() { return prefs.getLong("seed", 1L); }
    int rate() { return prefs.getInt("rate", 1) == 1 ? 1 : 4; }
    double strength() { return Math.max(0, Math.min(100, prefs.getInt("strength", 100))) / 100.0; }
    double motionSpeed() { return speed("motion_speed", 11); }
    double formSpeed() { return speed("form_speed", 10); }
    double colorSpeed() { return speed("color_speed", 41); }
    private double speed(String key, int defaultPercent) {
        return Math.max(MIN_SPEED_PERCENT, Math.min(MAX_SPEED_PERCENT,
            prefs.getInt(key, defaultPercent))) / 100.0;
    }
    int count() { return Math.max(1, Math.min(9, prefs.getInt("count", 7))); }
    boolean varyCount() { return prefs.getBoolean("vary_count", true); }
    boolean collisions() { return prefs.getBoolean("collisions", true); }
    boolean merging() { return prefs.getBoolean("merging", true); }
    /** Bodies respond to touch and to their person's return. */
    boolean companion() { return prefs.getBoolean("companion", true); }
    /** Colours of apps used, read on this phone with usage access. */
    boolean knowMyDay() { return prefs.getBoolean("know_my_day", true); }
    boolean touchRipples() { return prefs.getBoolean("touch_ripples", false); }
    boolean autoReseed() { return prefs.getBoolean("auto_reseed", true); }
    void newSeed() { prefs.edit().putLong("seed", new SecureRandom().nextLong()).apply(); }
    void configure(LatticeRenderer renderer) {
        renderer.configure(rate(), strength(), 14000, false, autoReseed());
        renderer.setAnimationSpeeds(motionSpeed(), formSpeed(), colorSpeed());
        renderer.configurePopulation(count(), varyCount(), collisions(), merging());
        renderer.setTouchRipplesEnabled(touchRipples());
    }
}

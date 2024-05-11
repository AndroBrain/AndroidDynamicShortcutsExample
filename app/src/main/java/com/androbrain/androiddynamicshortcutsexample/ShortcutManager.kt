package com.androbrain.androiddynamicshortcutsexample

import android.content.Context
import android.content.Intent
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat

object ShortcutManager {
    private const val PROFILE_ID = "profile_id"
    private const val ACTION = "ACTION"

    fun enableLoginShortcuts(context: Context) {
        val shortcut = ShortcutInfoCompat.Builder(context, PROFILE_ID)
            // This is what the user will see
            .setShortLabel("Profile")
            .setLongLabel("Open Profile")
            .setIcon(IconCompat.createWithResource(context, R.drawable.ic_person))
            // Intent that will be launched
            .setIntent(
                Intent(context, ProfileActivity::class.java).apply {
                    // Must be set even if not handled
                    // or your app will crash
                    setAction(ACTION)
                }
            )
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(context, shortcut)
    }

    fun disableLoginShortcuts(context: Context) {
        ShortcutManagerCompat.removeDynamicShortcuts(context, listOf(PROFILE_ID))
        // Or for all:
        // ShortcutManagerCompat.removeAllDynamicShortcuts(context)
    }
}

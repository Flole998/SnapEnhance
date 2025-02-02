package me.rhunk.snapenhance.features.impl.ui.menus

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.View
import android.widget.Switch
import android.widget.TextView
import me.rhunk.snapenhance.Constants

object ViewAppearanceHelper {
    fun applyIndentation(view: TextView) {
        view.setPadding(70, 0, 55, 0)
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode", "RtlHardcoded", "DiscouragedApi")
    fun applyTheme(viewModel: View, view: TextView) {
        //remove the shadow
        view.setBackgroundColor(0x00000000)
        view.setTextColor(viewModel.resources.getColor(viewModel.resources.getIdentifier("sig_color_text_primary_light", "color", Constants.SNAPCHAT_PACKAGE_NAME), null))
        view.setShadowLayer(0f, 0f, 0f, 0)
        view.outlineProvider = null
        view.gravity = Gravity.LEFT or Gravity.CENTER_VERTICAL
        view.width = viewModel.width
        //FIXME: hardcoded dimensions
        view.height = 160
        view.setPadding(35, 0, 55, 0)
        view.isAllCaps = false
        view.textSize = 15f
        view.typeface = Typeface.DEFAULT

        //remove click effect
        if (view.javaClass == TextView::class.java) {
            view.setBackgroundColor(0)
        }
        if (view is Switch) {
            val colorStateList = ColorStateList(
                arrayOf(intArrayOf(-android.R.attr.state_checked), intArrayOf(android.R.attr.state_checked)
                ), intArrayOf(
                    Color.parseColor("#3d3d3d"),
                    Color.parseColor("#2196F3")
                )
            )
            view.trackTintList = colorStateList
            view.thumbTintList = colorStateList
        }
    }
}

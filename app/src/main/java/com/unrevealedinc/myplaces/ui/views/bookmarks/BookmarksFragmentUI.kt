package com.unrevealedinc.myplaces.ui.views.bookmarks

import android.graphics.Typeface
import android.view.Gravity
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import com.unrevealedinc.myplaces.R
import com.unrevealedinc.myplaces.ui.components.placeCard
import com.unrevealedinc.myplaces.ui.utils.OverScrollBehavior
import org.jetbrains.anko.*
import org.jetbrains.anko.design.coordinatorLayout
import org.jetbrains.anko.support.v4.nestedScrollView

class BookmarksFragmentUI: AnkoComponent<Fragment> {
    override fun createView(ui: AnkoContext<Fragment>) = with(ui) {
        coordinatorLayout {
            lparams(matchParent, matchParent)
            nestedScrollView {
                scrollView {
                    linearLayout {
                        orientation = LinearLayout.VERTICAL

                        textView(R.string.bottom_navigation_search) {
                            textSize = 26f
                            typeface = Typeface.DEFAULT_BOLD
                        }.lparams {
                            gravity = Gravity.START
                            setMargins(dip(16), dip(24), dip(16), dip(8))
                        }

                        //init bookmarks from PlacesDb
                        placeCard(
                            logoRes = R.drawable.logo_place,
                            iconRes = R.drawable.ic_type_park,
                            backgroundIconRes = R.drawable.background_type_icon,
                            titleRes = R.string.place_card_title,
                            descriptionRes = R.string.place_card_description
                        )

                        //place cards here

                    }.lparams(matchParent, matchParent)
                }.lparams(matchParent, matchParent)
            }.lparams(matchParent, matchParent) {
                behavior = OverScrollBehavior()
                overScrollMode = CoordinatorLayout.OVER_SCROLL_NEVER
            }
        }
    }
}
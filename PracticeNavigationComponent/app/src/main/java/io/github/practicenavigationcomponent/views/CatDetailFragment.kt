package io.github.practicenavigationcomponent.views

import android.content.Context
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import coil.load
import io.github.practicenavigationcomponent.R

/**
 * A simple [Fragment] subclass.
 */
class CatDetailFragment : Fragment(R.layout.fragment_cat_detail) {

    private val mArgs by navArgs<CatDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(requireContext(), view)
    }

    private fun initViews(context: Context, view: View) {
        initAppBarTitle(context, mArgs.cat.name)
        initText(view, mArgs.cat.name)
        initSubText(view, mArgs.cat.description)
        initImageView(view, mArgs.cat.imageUrl)
        initLinkText(view, mArgs.cat.referenceUrl)
    }

    private fun initAppBarTitle(context: Context, title: String) {
        val activity = context as? FragmentActivity ?: return
        activity.window.findViewById<TextView>(R.id.app_bar_text).text = title
    }

    private fun initText(view: View, catName: String) {
        view.findViewById<TextView>(R.id.text).text = catName
    }

    private fun initSubText(view: View, description: String) {
        view.findViewById<TextView>(R.id.sub_text).text = description
    }

    private fun initImageView(view: View, imageUrl: String) {
        val imageView = view.findViewById<ImageView>(R.id.image_view)
        imageView.background =
            ResourcesCompat.getDrawable(resources, android.R.drawable.screen_background_dark, null)
        imageView.load(imageUrl)
    }

    private fun initLinkText(view: View, url: String) {
        val linkText = view.findViewById<TextView>(R.id.link_text)
        val displayText =
            Html.fromHtml(
                "<a href=\"$url\">${resources.getString(R.string.wikipedia)}</a>",
                Html.FROM_HTML_MODE_LEGACY
            )
        linkText.text = displayText
        linkText.movementMethod = LinkMovementMethod.getInstance()
    }
}
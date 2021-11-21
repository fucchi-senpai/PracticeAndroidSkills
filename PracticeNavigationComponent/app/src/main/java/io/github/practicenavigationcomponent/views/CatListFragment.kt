package io.github.practicenavigationcomponent.views

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import io.github.practicenavigationcomponent.R
import io.github.practicenavigationcomponent.model.Cats
import io.github.practicenavigationcomponent.model.decodeJson
import io.github.practicenavigationcomponent.utils.AssetsUtil

/**
 * A simple [Fragment] subclass.
 */
class CatListFragment : Fragment(R.layout.fragment_cat_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(requireContext(), view)
    }

    private fun initViews(context: Context, view: View) {
        initAppBarTitle(context)
        initListView(context, view)
    }

    private fun initAppBarTitle(context: Context) {
        val activity = context as? FragmentActivity ?: return
        activity.window.findViewById<TextView>(R.id.app_bar_text).text =
            resources.getString(R.string.app_name)
    }

    private fun initListView(context: Context, view: View) {
        val cats = decodeJson<Cats>(AssetsUtil.readFile(context, AssetsUtil.JsonFile.cats))
        cats.cats.sortBy { it.name }
        val adapterList = cats.cats.map { hashMapOf("name" to it.name) }

        val adapter = SimpleAdapter(
            context,
            adapterList,
            android.R.layout.simple_list_item_1,
            arrayOf("name"),
            intArrayOf(android.R.id.text1)
        )

        val listView = view.findViewById<ListView>(R.id.list_view)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val cat = cats.cats[position]
            val action = CatListFragmentDirections.actionCatListFragmentToCatDetailFragment(cat)
            view.findNavController().navigate(action)
        }
    }
}
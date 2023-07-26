package com.example.cursoandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class PageFragment : Fragment() {

    companion object {
        private const val ARG_PAGE_NUMBER = "page_number"

        fun newInstance(pageNumber: Int): PageFragment {
            val fragment = PageFragment()
            val args =Bundle()
            args.putInt(ARG_PAGE_NUMBER, pageNumber)
            fragment.arguments = args
            return fragment

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container:ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onViewCreated(view, savedInstanceState)
        val textView : TextView

        val pageNumber = arguments?.getInt(ARG_PAGE_NUMBER)
        textView = view.findViewById(R.id.idtemary)
        textView.text = "Página $pageNumber"

        //val imageView: ImageView = view.findViewById(R.id.your_image_view_id)
        //val pageNumber = arguments?.getInt(ARG_PAGE_NUMBER)
        //val imageUrl = getPageImageUrl(pageNumber)

       // Glide.with(this)
           // .load(imageUrl)
           // .into(imageView)

    }
}


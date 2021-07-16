package com.gayathri.preparation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gayathri.preparation.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentB.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentB : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.d("fragment_transaction", "onCreate B")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("fragment_transaction", "onCreateView B")
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("fragment_transaction", "onViewCreated B")
    }

    // called after onViewCreated()
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("fragment_transaction", "onViewStateRestored B")
    }

    override fun onStart() {
        super.onStart()
        Log.d("fragment_transaction", "onStart B")
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment_transaction", "onResume B")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_transaction", "onPause B")
    }

    override fun onStop() {
        super.onStop()
        Log.d("fragment_transaction", "onStop B")
    }

    // called after onStop()
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("fragment_transaction", "onSaveInstanceState B")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("fragment_transaction", "onDestroyView B")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("fragment_transaction", "onDestroy B")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("fragment_transaction", "onAttach B")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("fragment_transaction", "onDetach A")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentB.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentB().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
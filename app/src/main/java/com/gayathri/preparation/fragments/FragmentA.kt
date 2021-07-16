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
 * Use the [FragmentA.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentA : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        Log.d("fragment_transaction", "onCreate A")
        initUI()
    }

    private fun initUI() {
        // Here name and canonicalName are same
        Log.d(FragmentA::class.java.simpleName, "simpleName ${FragmentA::class.java.simpleName}")
        Log.d(FragmentA::class.java.simpleName, "name ${FragmentA::class.java.name}")
        Log.d(
            FragmentA::class.java.simpleName,
            "canonicalName ${FragmentA::class.java.canonicalName}"
        )
        Log.d(FragmentA::class.java.simpleName, "package ${FragmentA::class.java.`package`}")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("fragment_transaction", "onCreateView A")
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("fragment_transaction", "onViewCreated A")
    }

    // called after onViewCreated()
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("fragment_transaction", "onViewStateRestored A")
    }

    override fun onStart() {
        super.onStart()
        Log.d("fragment_transaction", "onStart A")
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment_transaction", "onResume A")
    }

    override fun onPause() {
        super.onPause()
        Log.d("fragment_transaction", "onPause A")
    }

    override fun onStop() {
        super.onStop()
        Log.d("fragment_transaction", "onStop A")
    }

    // called after onStop()
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("fragment_transaction", "onSaveInstanceState A")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("fragment_transaction", "onDestroyView A")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("fragment_transaction", "onDestroy A")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("fragment_transaction", "onAttach A")
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
         * @return A new instance of fragment FragmentA.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentA().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
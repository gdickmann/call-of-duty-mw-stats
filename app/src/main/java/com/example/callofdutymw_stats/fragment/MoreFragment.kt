package com.example.callofdutymw_stats.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.callofdutymw_stats.R
import com.example.callofdutymw_stats.model.multiplayer.lifetime.all.properties.UserInformationMultiplayer
import com.example.callofdutymw_stats.view.util.UserConstants
import com.example.callofdutymw_stats.viewmodel.UserInformationViewModel
import java.text.DecimalFormat

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MoreFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textViewAccuracy: TextView
    private lateinit var textViewHeadshots: TextView
    private lateinit var textViewSuicides: TextView
    private lateinit var textViewAssists: TextView
    private lateinit var textViewRecordDeathsInMatch: TextView
    private lateinit var textViewRecordWinStreak: TextView
    private lateinit var textViewRecordXP: TextView
    private lateinit var textViewTotalShots: TextView
    private lateinit var textViewTotalShotsMisses: TextView
    private lateinit var textViewTotalShotsHits: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_more, container, false)
        setGeneralUserInformations(view)
        return view
    }

    private fun setGeneralUserInformations(view: View) {
        val user =
            activity?.intent?.getSerializableExtra(UserConstants.OBJECT_USER) as UserInformationMultiplayer
        findViews(view)
        val formatter = DecimalFormat("##,###,###")
        if (UserInformationViewModel.responseAccuracyIsValid(user.accuracy)) {
            if (UserInformationViewModel.responseAccuracyIsValid(user.accuracy)) {
                textViewAccuracy.text =
                    user.accuracy.substring(0, 4)
            } else {
                textViewAccuracy.text =
                    user.accuracy
            }
            textViewHeadshots.text = formatter.format(user.headshots.toInt())
            textViewSuicides.text = formatter.format(user.suicides.toInt())
            textViewAssists.text = formatter.format(user.assists.toInt())
            textViewRecordDeathsInMatch.text = formatter.format(user.recordDeathsInMatch.toInt())
            textViewRecordWinStreak.text = formatter.format(user.recordWinStreak.toInt())
            textViewRecordXP.text = formatter.format(user.recordXP.toInt())
            textViewTotalShots.text = formatter.format(user.totalShots)
            textViewTotalShotsMisses.text =
                formatter.format(user.totalShotsMisses.toString().toInt())
            textViewTotalShotsHits.text = formatter.format(user.totalShotsHits)
        }
    }

    private fun findViews(view: View) {
        textViewAccuracy = view.findViewById(R.id.textViewAccuraccy) as TextView
        textViewHeadshots = view.findViewById(R.id.textViewHeadshots) as TextView
        textViewSuicides = view.findViewById(R.id.textViewSuicides) as TextView
        textViewAssists = view.findViewById(R.id.textViewAssists) as TextView
        textViewRecordDeathsInMatch =
            view.findViewById(R.id.textViewRecordDeathsInMatch) as TextView
        textViewRecordWinStreak = view.findViewById(R.id.textViewRecordWins) as TextView
        textViewRecordXP = view.findViewById(R.id.textViewTotalXP) as TextView
        textViewTotalShots = view.findViewById(R.id.textViewTotalShots) as TextView
        textViewTotalShotsMisses = view.findViewById(R.id.textViewTotalShotsMisses) as TextView
        textViewTotalShotsHits = view.findViewById(R.id.textViewTotalShotsHits) as TextView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GeneralFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
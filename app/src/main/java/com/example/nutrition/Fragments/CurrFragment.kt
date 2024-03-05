package com.example.nutrition.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nutrition.GoS.Day
import com.example.nutrition.R
import com.parse.Parse
import com.parse.ParseQuery
import com.parse.ParseUser
import org.eazegraph.lib.charts.PieChart


class CurrFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_curr, container, false)
        //Declarations
        var pieChart : PieChart = view.findViewById(R.id.currPiechart)
        var currProtein : TextView = view.findViewById(R.id.currProtein)
        var currCalories : TextView = view.findViewById(R.id.currCalories)
        var currFats : TextView = view.findViewById(R.id.currFats)
        var currCarbs : TextView = view.findViewById(R.id.currCarbs)
        var currDay : Day

        //QueryDays
        var query : ParseQuery<Day> = ParseQuery.getQuery("Day")
        query.whereContains("user", ParseUser.getCurrentUser().username)
        query.findInBackground { objects, e ->
            if(e != null){
                Log.e("CurrFragment 43:" , e.toString())
                return@findInBackground
            }
            if(objects.size < 1){

            }else{
                var prevDay : Day = objects[0]

            }
        }
        // Inflate the layout for this fragment
        return view
    }
}
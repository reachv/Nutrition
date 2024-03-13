package com.example.nutrition.Fragments

import android.graphics.Color
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
import org.eazegraph.lib.models.PieModel
import java.util.Date


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
        val currProtein : TextView = view.findViewById(R.id.currProtein)
        val currCalories : TextView = view.findViewById(R.id.currCalories)
        val currFats : TextView = view.findViewById(R.id.currFats)
        val currCarbs : TextView = view.findViewById(R.id.currCarbs)
        var currDate : TextView = view.findViewById(R.id.currDate)

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
                val curr : Day = objects[0]
                //TextView
                currProtein.setText(curr.protein)
                currCalories.setText(curr.calories)
                currCarbs.setText(curr.carbs)
                currFats.setText(curr.fats)
                currDate.text = curr.createdAt.toString()

                //PieChart
                pieChart.addPieSlice(
                    PieModel(
                        "Protein",
                        curr.protein.toFloat(),
                        Color.parseColor("#FFA726")
                    )
                )
                pieChart.addPieSlice(
                    PieModel(
                        "Carbs",
                        curr.carbs.toFloat(),
                        Color.parseColor("#FFA726")
                    )
                )
                pieChart.addPieSlice(
                    PieModel(
                        "Fats",
                        curr.fats.toFloat(),
                        Color.parseColor("#FFA726")
                    )
                )
            }
        }

        // Inflate the layout for this fragment
        return view
    }
}
package com.example.nestedrecycler

import com.example.nestedrecycler.Models.ChildModel
import java.util.*

object ChildDataFactory{
    private val random = Random()

    private val titles =  arrayListOf( "Aviator", "Now you can See me", "God Father", "Mission Impossible", "3 idiots")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }
    private fun randomImage() : Int{
        return R.drawable.undraw
    }
    fun getChildren(count : Int) : List<ChildModel> {
        val children = mutableListOf<ChildModel>()
        repeat(count) {
            val child = ChildModel(randomImage(), randomTitle())
            children.add(child)
        }
        return children
    }
}
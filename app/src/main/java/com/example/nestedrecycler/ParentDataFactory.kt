package com.example.nestedrecycler

import com.example.nestedrecycler.Models.ChildModel
import com.example.nestedrecycler.Models.ParentModel
import kotlin.random.Random
object ParentDataFactory {
    private val random = java.util.Random()

    private val titles =  arrayListOf( "Now Playing", "Classic", "Comedy", "Thriller", "Action", "Horror", "TV Series")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomChildren() : List<ChildModel>{
        return ChildDataFactory.getChildren(20)
    }

    fun getParents(count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel(randomTitle(), randomChildren())
            parents.add(parent)
        }
        return parents
    }
}
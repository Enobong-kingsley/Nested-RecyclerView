package com.example.nestedrecycler.Models

data class ParentModel(
    val title : String = "", var children:List<ChildModel>
)
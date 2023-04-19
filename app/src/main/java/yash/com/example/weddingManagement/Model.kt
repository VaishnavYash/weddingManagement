package yash.com.example.weddingManagement

data class Model (
    val image : Int,
    val title : String,
    val desc : String
){
    constructor() : this(0, "", "" )
}
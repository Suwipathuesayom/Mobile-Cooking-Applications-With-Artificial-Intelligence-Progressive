package com.example.myfoodlab

class CardModel {
    var title:String? = null
    var image:String? = null
    constructor()
    constructor(title:String, image:String){
        this.title = title
        this.image = image
    }
    fun toMap(): Map<String, Any>{
        val result = HashMap<String, Any>()
        result.put("title", title!!)
        result.put("image", image!!)
        return result
    }
}
package com.example.myfoodlab

class CardModel {
    var title:String? = null
    var image:String? = null
    var key:String? = null
    var detail:String? = null
    constructor()
    constructor(title:String, image:String , key:String?){
        this.title = title
        this.image = image
        this.key = key
        this.detail = detail
    }
    fun toMap(): Map<String, Any>{
        val result = HashMap<String, Any>()
        result.put("title", title!!)
        result.put("image", image!!)
        result.put("key", key!!)
        result.put("detail",detail!!)
        return result
    }
}
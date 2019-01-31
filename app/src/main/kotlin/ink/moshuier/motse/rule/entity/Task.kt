package ink.moshuier.motse.rule.entity

data class Task(val map:MutableMap<String,Any?>){
    var _id:Int by map
    var title:String by map
    var weight:Int by map
    constructor():this(HashMap()){

    }
    constructor(_id:Int,title:String,weight:Int):this(HashMap()){
        this._id = _id
        this.title = title
        this.weight = weight
    }
    constructor(title:String,weight:Int):this(HashMap()){
        this.title = title
        this.weight = weight
    }
}
package models

class Categories {
    private var nameCategories: String = ""
    private var imageCategories: Int = 0

    constructor(nameCategories: String, imageCategories: Int){
        this.nameCategories = nameCategories
        this.imageCategories = imageCategories
    }

    fun  setNameCategories(nameCategories: String){
        this.nameCategories = nameCategories
    }

    fun  setImageCategories(imageCategories: Int){
        this.imageCategories = imageCategories
    }

    fun getNameCategories(): String {
        return nameCategories
    }

    fun imageCategories(): Int {
        return imageCategories
    }


}
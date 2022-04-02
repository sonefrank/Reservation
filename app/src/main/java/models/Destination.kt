package models

class Destination {
    private var note: String = ""
    private var txtBafou: String = ""
    private var txtIndo: String = ""
    private var prix: String = ""
    private var periode: String = ""

    constructor(note: String, txtBafou: String, txtIndo: String, prix: String, periode: String) {
        this.note = note
        this.txtBafou = txtBafou
        this.txtIndo = txtIndo
        this.prix = prix
        this.periode = periode
    }

    fun  setNote(note: String){
        this.note = note
    }

    fun  setTxtBafou(txtBafou: String){
        this.txtBafou = txtBafou
    }

    fun  setTxtIndo(txtIndo: String){
        this.txtIndo = txtIndo
    }

    fun  setPrix(prix: String){
        this.prix = prix
    }
    fun  setPeriode(periode: String){
        this.periode = periode
    }

    fun getNote(): String {
        return note
    }

    fun getPrix(): String {
        return prix
    }
    fun getTxtBafou(): String {
        return txtBafou
    }

    fun getTxtIndo(): String {
        return txtIndo
    }
    fun getPeriode(): String {
        return periode
    }

}
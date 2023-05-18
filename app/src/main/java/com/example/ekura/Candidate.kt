package com.example.ekura

class Candidate {
    var cand_id:String? = null
    var cand_name:String? = null
    var cand_party:String? = null
    var cand_position:String? = null

    constructor(cand_id: String?, cand_name: String?, cand_party: String?, cand_position: String?) {
        this.cand_id = cand_id
        this.cand_name = cand_name
        this.cand_party = cand_party
        this.cand_position = cand_position
    }
}




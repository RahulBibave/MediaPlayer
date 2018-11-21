package kumarworld.rahul.mediaplayer

class SongInfo {
    var Tital:String?=null
    var AuthorName:String?=null
    var songUrl:String?=null

    constructor(Tital: String?, AuthorName: String?, songUrl: String?) {
        this.Tital = Tital
        this.AuthorName = AuthorName
        this.songUrl = songUrl
    }
}
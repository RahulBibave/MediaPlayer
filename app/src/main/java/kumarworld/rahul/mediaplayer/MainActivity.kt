package kumarworld.rahul.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.song_ticket.view.*

class MainActivity : AppCompatActivity() {

    var ListSongs=ArrayList<SongInfo>()
    var adpter:MySongAdapter?=null
    var mp: MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LoadURLOnline()
        adpter=MySongAdapter(ListSongs)
        lsListSongs.adapter=adpter
    }
    fun LoadURLOnline(){
        ListSongs.add(SongInfo("001","Ahmed","http://server6.mp3quran.net/thubti/001.mp3"))
        ListSongs.add(SongInfo("002","Ahmed","http://server6.mp3quran.net/thubti/002.mp3"))
        ListSongs.add(SongInfo("003","Alex","http://server6.mp3quran.net/thubti/003.mp3"))
        ListSongs.add(SongInfo("004","Ahmed","http://server6.mp3quran.net/thubti/004.mp3"))
        ListSongs.add(SongInfo("005","Alex","http://server6.mp3quran.net/thubti/005.mp3"))

    }
    inner class MySongAdapter:BaseAdapter{

        var mySongList=ArrayList<SongInfo>()

        constructor(mySongList: ArrayList<SongInfo>) : super() {
            this.mySongList = mySongList
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val myView=layoutInflater.inflate(R.layout.song_ticket,null)
            val song=this.mySongList[position]
            myView.tvSongName.text=song.Tital
            myView.tvAuthor.text=song.AuthorName

            myView.buPlay.setOnClickListener(){
                if( myView.buPlay.text.equals("Stop") ){
                    mp!!.stop()
                    myView.buPlay.text = "Start"
                }else {

                    mp = MediaPlayer()
                    try {
                        mp!!.setDataSource(song.songUrl)
                        mp!!.prepare()
                        mp!!.start()
                        myView.buPlay.text = "Stop"
                        sbProgress.max=mp!!.duration
                    } catch (ex: Exception) {
                    }
                }
            }


            return myView
      }

        override fun getItem(position: Int): Any {
            return this.mySongList[position]
           }

        override fun getItemId(position: Int): Long {
            return  position.toLong()    }

        override fun getCount(): Int {
          return mySongList.size
        }

    }
}

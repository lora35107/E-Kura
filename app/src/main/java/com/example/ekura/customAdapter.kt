package com.example.ekura

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class CustomAdapter(var context: Context, var data:ArrayList<Candidate>): BaseAdapter() {
    private class ViewHolder(row: View?){
        var mTxtName: TextView
        var mTxtID: TextView
        var mTxtPosn: TextView
        var mBtnVote: Button
        init {
            this.mTxtName = row?.findViewById(R.id.mTvName) as TextView
            this.mTxtID = row?.findViewById(R.id.mTvID) as TextView
            this.mTxtPosn = row?.findViewById(R.id.mTvPosn) as TextView
            this.mBtnVote = row?.findViewById(R.id.mTVvote) as Button
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.myitem_layout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Candidate = getItem(position) as Candidate
        viewHolder.mTxtName.text = item.cand_name
        viewHolder.mTxtID.text = item.cand_id
        viewHolder.mTxtPosn.text = item.cand_position
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}



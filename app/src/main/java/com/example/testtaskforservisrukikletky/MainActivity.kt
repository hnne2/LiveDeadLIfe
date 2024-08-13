package com.example.testtaskforservisrukikletky

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wallet.ui.home.EssenceRecyclerViewAdapter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getLiveButton=findViewById<Button>(R.id.toLiveButton)
       val liveRecyclerView = findViewById<RecyclerView>(R.id.liveRecyclerView)
       val essensesList = arrayListOf(ItemEssence(getString(R.string.itemDeadText),getString(R.string.itemDeadTextdicription),getString(R.string.head),R.drawable.deadimage))
        val onClickListener = EssenceRecyclerViewAdapter.OnClickListener{item,position ->
            println(item.itemName)
        }
        var tipesItemslist= arrayListOf<Int>()
        val adapter= EssenceRecyclerViewAdapter(baseContext,essensesList,onClickListener)
        liveRecyclerView.adapter=adapter;
        liveRecyclerView.layoutManager= LinearLayoutManager((baseContext))
        getLiveButton.setOnClickListener {
            tipesItemslist.add(Random.nextInt(2))

            val newItem = when (tipesItemslist.last()) {
                0 -> ItemEssence(
                    getString(R.string.itemDeadText),
                    getString(R.string.itemDeadTextdicription),
                    getString(R.string.head),
                    R.drawable.deadimage
                )
                1 -> ItemEssence(
                    getString(R.string.itemLiveText),
                    getString(R.string.itemLiveTextdicription),
                    getString(R.string.fire),
                    R.drawable.leave
                )
                else -> null
            }
            newItem?.let {
                essensesList.add(0, it)
                adapter.notifyItemInserted(0)
                liveRecyclerView.scrollToPosition(0)
            }
            if (tipesItemslist.size > 3) {
                if (tipesItemslist[tipesItemslist.size - 1] == 1 && tipesItemslist[tipesItemslist.size - 2] == 1 && tipesItemslist[tipesItemslist.size - 3] == 1) {
                    val lifeItem = ItemEssence(
                        getString(R.string.itemLifeText),
                        getString(R.string.itemLifeTextdicription),
                        getString(R.string.chiken),
                        R.drawable.life
                    )
                    essensesList.add(0, lifeItem)
                    adapter.notifyItemInserted(0)
                    liveRecyclerView.scrollToPosition(0)
                    tipesItemslist.add(2)
                }

                if (tipesItemslist[tipesItemslist.size - 1] == 0 && tipesItemslist[tipesItemslist.size - 2] == 0 && tipesItemslist[tipesItemslist.size - 3] == 0 && tipesItemslist[tipesItemslist.size - 4] == 2) {
                    essensesList.removeAt(essensesList.size - 4)
                    adapter.notifyItemRemoved(essensesList.size - 4)
                }
            }
        }
    }
}
package com.example.kazuma.kotlinmomenttest

import android.os.Bundle
import android.os.Debug
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.Menu
import android.view.MenuItem
import me.mattak.moment.Duration
import me.mattak.moment.Moment
import me.mattak.moment.TimeUnit
import java.util.*

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        })

        // Try playing KotlinMoment
        val moment = Moment()
        Log.d("debug_moment", "now = ${moment}")
        Log.d("debug_moment", "format = ${moment.format("yyyy年MM月dd日 HH時mm分ss秒　タイムゾーン：ZZZZ")}")

        // 年
        val year = moment.year
        // 月 （他のmomentの風習とは違い、1~12の値が入る）
        val month = moment.month
        // 日
        val day = moment.day
        // 時
        val hour = moment.hour
        // 分
        val minute = moment.minute
        // 秒
        val second = moment.second
        // ミリ秒
        val milliSecond: String = moment.millisecond
        // 曜日
        val weekdayName = moment.weekdayName

        val calendar = Calendar.getInstance()
        calendar.set(2016, 4, 29, 0, 0, 0)
        val date1 = calendar.time
        calendar.set(2016, 4, 30, 0, 0, 0)
        val date2 = calendar.time

        val timeZone = TimeZone.getDefault()
        val locale = Locale.JAPAN

        val moment1 = Moment(date1, timeZone, locale)
        val moment2 = Moment(date2, timeZone, locale)

        if (moment1.compareTo(moment2) == 0) {
            // moment1とmoment2は同じ日付　(ミリ秒単位で)
        } else if (moment1.compareTo(moment2) > 0) {
            // moment1はmoment2より進んでいる
        } else if (moment1.compareTo(moment2) < 0) {
            // moment1はmoment2より遅れている (今回の例でいえばここに入る)
        }

        Log.d("debug_moment", "moment1 = ${moment1.compareTo(moment2)}")
        Log.d("debug_moment", "moment1 = ${moment2.compareTo(moment1)}")
        Log.d("debug_moment", "moment1 = ${moment1.compareTo(moment1)}")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}

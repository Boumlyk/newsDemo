package com.hmzeda.newsdemo.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hmzeda.newsdemo.data.local.doa.NewsDao
import com.hmzeda.newsdemo.module.cookies.Cookies
import com.hmzeda.newsdemo.module.news.NewsObject
import dagger.hilt.android.qualifiers.ApplicationContext

@TypeConverters(DataConverter::class)
@Database(entities = [NewsObject::class], version = 3, exportSchema = false)
abstract class DemoDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    companion object{
          var instance : DemoDatabase?=null
        private const val dataBaseName:String="db-demo"

        private fun createDataBase(context: Context):DemoDatabase{
            // here our pass phrase is hardcoded just because its a demo app. however
            // passPhrase contain a hash of some data related to our app to make our data base secure
//            val factory = SupportFactory("passphrase".toByteArray())
            return Room.databaseBuilder(context,DemoDatabase::class.java,dataBaseName)
                .fallbackToDestructiveMigration()
//                .openHelperFactory(factory)
                .build()
        }

        @Synchronized
        fun getInstance(@ApplicationContext context: Context): DemoDatabase {
            if (instance==null){
                synchronized(DemoDatabase::class.java){
                    instance=createDataBase(context)
                }
            }
            return instance as DemoDatabase
        }
    }


}